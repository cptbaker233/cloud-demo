package cn.itcast.gateway.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class LoadBalancerConfig {

    @Bean
    public IRule getLB() {
        return new RandomRule();
    }

}
