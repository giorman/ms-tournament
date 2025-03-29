package co.com.esport.app.api.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Component
public class ParametersFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String messageId = exchange.getRequest().getHeaders().getFirst("message-id");
        if (messageId != null) {
            exchange.getAttributes().put("message-id", messageId);
        }
        exchange.getAttributes().put("request-time", Instant.now().toString());
        return chain.filter(exchange);
    }
}