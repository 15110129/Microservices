package com.microservices.zuulgateway.config;

import com.microservices.zuulgateway.entity.RoleName;
import com.microservices.zuulgateway.security.CustomUserDetailsService;
import com.microservices.zuulgateway.security.JwtAuthenticationEntryPoint;
import com.microservices.zuulgateway.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                .permitAll()
                .antMatchers("/api/auth/**")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/products" + "/product")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/products" + "/product/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products" + "/product/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/products" + "/product/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/products" + "/category/")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/products" + "/category/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products" + "/category/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/products" + "/category/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/review" + "/")
                .hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/review" + "/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/review" + "/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/review" + "/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/order" + "/order")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/order" + "/order/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/order" + "/order/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/order" + "/order/")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/order" + "/order/active/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/order" + "/order/username/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.POST, "/order" + "/orderdetail/")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/order" + "/orderdetail/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/order" + "/orderdetail/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.GET, "/order" + "/orderdetail/**")
                .hasRole("USER")
                .anyRequest()
                .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
