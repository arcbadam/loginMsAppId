package com.ibm.loginAppId;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableOAuth2Sso //Enables OAuth2 Single Sign On, will automatically use application.yml properties for security
@EnableFeignClients	
public class LoginMsAppIdApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(LoginMsAppIdApplication.class, args);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
 
        //Configuring Spring security access. For /login, /user, and /userinfo, we need authentication.
        //Logout is enabled.
        //Adding csrf token support to this configurer.
        http.authorizeRequests()
                .antMatchers("/login**", "/user","/userInfo").authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
 
    }
	

}
