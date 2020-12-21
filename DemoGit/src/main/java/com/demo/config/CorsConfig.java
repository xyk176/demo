package com.demo.config;

<<<<<<< HEAD
/*
 * @author SMILE.Huang
 * @date 2019-10-17 16:22
 */

=======
>>>>>>> hjj
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**配置全局跨域
 * @author SMILE
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
<<<<<<< HEAD
        CorsConfiguration corsConfiguration = new  CorsConfiguration();
=======
        CorsConfiguration corsConfiguration = new CorsConfiguration();
>>>>>>> hjj
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        return corsConfiguration;
    }
<<<<<<< HEAD
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
=======

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
>>>>>>> hjj
        source.registerCorsConfiguration("/**", buildConfig());  // 4
        return new CorsFilter(source);
    }
}

