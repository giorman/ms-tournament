package co.com.esport.app.api.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Configuration
public class WebConfig {

    @Bean
    public WebProperties.Resources webResources() {
        return new WebProperties.Resources();
    }
}