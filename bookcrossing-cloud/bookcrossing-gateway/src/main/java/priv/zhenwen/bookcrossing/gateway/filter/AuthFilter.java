package priv.zhenwen.bookcrossing.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhenwen
 * @date 2022/4/11
 */

@Component
public class AuthFilter implements GlobalFilter, Ordered {
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //获取响应对象
        ServerHttpResponse response = exchange.getResponse();
        //判断当前请求是否为登录请求
        if (request.getURI().getPath().contains("/login")) {
            return chain.filter(exchange);
        }
        //获取当前所有请求头信息
        HttpHeaders headers = request.getHeaders();
        //获取jwt令牌信息
        String jwtToken = headers.getFirst("token");
        //判断当前令牌是否存在
        if (jwtToken == null || jwtToken.equals("")) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.setComplete();
        }

        try {
            //解析令牌

        }

        return null;
    }

    public int getOrder() {
        return 0;
    }
}
