package com.zachjohnson.fetchexercise;

import com.zachjohnson.fetchexercise.utils.WordHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public WordHelper wordHelper() {
        return new WordHelper();
    }
}
