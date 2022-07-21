package cn.itcast.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(value = 1)
@Component
public class AuthorizationFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /* 1.获取请求参数 */
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        /* 2. 获取authorization参数 */
        String authVal = params.getFirst("authorization");
        if ("admin".equals(authVal)) {
            return chain.filter(exchange);
        } else {
            /* 获取response对象 */
            ServerHttpResponse resp = exchange.getResponse();
            resp.setStatusCode(HttpStatus.UNAUTHORIZED);
            return resp.setComplete();
        }
    }
}
