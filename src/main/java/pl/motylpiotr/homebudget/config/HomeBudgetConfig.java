package pl.motylpiotr.homebudget.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EntityScan("pl.motylpiotr.homebudget")
public class HomeBudgetConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
