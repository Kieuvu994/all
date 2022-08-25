package com.coeding.springmvc.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static String CLIENT_PROPERTY_KEY  = "spring.security.oauth2.client.registration.";

	@Autowired
	private Environment env;
	
	private static List<String> clients = Arrays.asList("google", "facebook");
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private GoogleOAuth2Handler googleOAuth2Handler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}
	
	@Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> registrations = clients.stream()
          .map(c -> getRegistration(c))
          .filter(registration -> registration != null)
          .collect(Collectors.toList());
        
        return new InMemoryClientRegistrationRepository(registrations);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String loginPage = "/login";
		String logoutPage = "/logout";

		http.authorizeRequests().antMatchers(loginPage,"/showCustomerForm", "/register").permitAll()
				.antMatchers("/checkout", "/order", "/pay/**", "/profile").hasAuthority("USER")
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and().csrf().disable()
				.formLogin().loginPage(loginPage).failureUrl("/login?error=true").defaultSuccessUrl("/", true)
				.usernameParameter("username").passwordParameter("password")
//				.and().oauth2Login().loginPage(loginPage).successHandler(googleOAuth2Handler)
				.and().oauth2Login().clientRegistrationRepository(clientRegistrationRepository()).authorizedClientService(authorizedClientService())
				.loginPage(loginPage).successHandler(googleOAuth2Handler)
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher(logoutPage)).logoutSuccessUrl(loginPage)
				.invalidateHttpSession(true).deleteCookies("JESSIONID")
				.and().exceptionHandling();
		
		http.headers().frameOptions().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**",
				"/static/**", "/css/**", "/js/**", "/images/**",
				"/fonts/**", "/img/**","/sass/**");
	}
	
	private ClientRegistration getRegistration(String client) {
	    String clientId = env.getProperty(
	      CLIENT_PROPERTY_KEY + client + ".client-id");

	    if (clientId == null) {
	        return null;
	    }

	    String clientSecret = env.getProperty(
	      CLIENT_PROPERTY_KEY + client + ".client-secret");
	 
	    if (client.equals("google")) {
	        return CommonOAuth2Provider.GOOGLE.getBuilder(client)
	          .clientId(clientId).clientSecret(clientSecret).build();
	    }
	    if (client.equals("facebook")) {
	        return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
	          .clientId(clientId).clientSecret(clientSecret).build();
	    }
	    return null;
	}
	
	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
	 
	    return new InMemoryOAuth2AuthorizedClientService(
	      clientRegistrationRepository());
	}
}
