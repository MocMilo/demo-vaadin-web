package com.sandystack.webpanel.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ConfigurationProperties("app")
@PropertySource("classpath:global.properties")
public class WebGlobalProperties {
    private String apiUrlValue;
    public String getApiUrlValue() {
        return apiUrlValue;
    }
    public void setApiUrlValue(String apiUrlValue) {
        this.apiUrlValue = apiUrlValue;
    }
}