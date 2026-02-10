package com.jpay.testbank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class MerchantApiKeyCheckConfig implements WebMvcConfigurer {
    public final MerchantInterceptor merchantInterceptor;
    public MerchantApiKeyCheckConfig(@Autowired MerchantInterceptor merchantInterceptor) {
        this.merchantInterceptor = merchantInterceptor;
    }

    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addInterceptor(merchantInterceptor)
                .addPathPatterns("/api/merchant/**","/api/transactions/**"); // Apply to merchant-related endpoints
    }

}
