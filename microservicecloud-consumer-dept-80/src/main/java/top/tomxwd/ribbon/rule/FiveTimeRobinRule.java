package top.tomxwd.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 五次轮询策略
 *
 * @author xieweidu
 * @createDate 2019-12-07 21:38
 */
public class FiveTimeRobinRule extends AbstractLoadBalancerRule {

    /**
     * 当total==5的时候，才往下走一步轮询，然后total置零 currentIndex++，需要注意总共的index有多少
     */
    private AtomicInteger total = new AtomicInteger(0);
    /**
     * 当前对外提供服务的服务器地址
     */
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
            // 主要就是下面这段代码做到了5次轮询
            if (total.get() < 5) {
                total.incrementAndGet();
                server = upList.get(currentIndex.get());
            } else {
                total.set(0);
                currentIndex.incrementAndGet();
                if (currentIndex.get() >= upList.size()) {
                    currentIndex.set(0);
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
