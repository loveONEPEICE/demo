package com.lhl.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity//启用 Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true) //拦截注解了@PreAuthorize 注解的接口
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserService userInfoService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")//login.html
                .defaultSuccessUrl("/home.html")
                .successHandler(new MyAuthenctiationSuccessHandler())
                .failureHandler(new MyAuthenctiationFailureHandler())
                .loginProcessingUrl("/user/login")
                .and()
                .authorizeRequests()//授权配置
                .antMatchers("/login.html").permitAll()
                .anyRequest()
                .authenticated()
//                .and().csrf().disable()
        ;
//                .loginProcessingUrl("/login")
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        Spring Security 拦截配置
        web.ignoring().antMatchers("/swagger-ui.html", "login.html", "sign_up.html","home.html"
                , "/v2/**", "/templates/*"
                , "/swagger-resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("test1").password(setPassword().encode("000000")).roles("admin");
//        auth.userDetailsService(userInfoService).passwordEncoder(setPassword());
    }

    @Bean
    public PasswordEncoder setPassword() {
        return new BCryptPasswordEncoder();
    }
}
