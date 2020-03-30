package id.project.skripsi.manzone.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EntityScan("com.java.common.lib")
@ComponentScan("com.java.common.lib")
@EnableSwagger2
public class AppConfig {


    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        int timeout = 3000;
        return builder
                .setConnectTimeout(timeout)
                .setReadTimeout(timeout)
                .build();
    }

}
