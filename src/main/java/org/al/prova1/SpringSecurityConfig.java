package org.al.prova1;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOG = LoggerFactory.getLogger(SpringSecurityConfig.class);
	
	private static final String SPECIAL_AUTHORITY_FOR_AUTHORIZED_USERS = "SPECIAL";
	
	@Value("${billing.authorized.users}")
	private List<String> authorizedUsers;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().and().csrf().disable()
			.authorizeRequests()
				.antMatchers("/webjars/**").permitAll()
//				.antMatchers("/ui").permitAll()
				.anyRequest().hasAuthority(SPECIAL_AUTHORITY_FOR_AUTHORIZED_USERS) 
			.and()
			.oauth2Login()
			;
		;
	}
	
	@Bean
	public GrantedAuthoritiesMapper userAuthoritiesMapper() {
		return (authorities) -> {
			Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
			authorities.forEach(authority -> {
				LOG.debug("Checking if oauth2 user is authorized user.");
				if (OAuth2UserAuthority.class.isInstance(authority)) {
					OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority)authority;
					Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();
					String currentUser = (String)userAttributes.get("login");
					if (authorizedUsers.contains(currentUser)) {
						LOG.debug("Adding billing role ({}) to user ({})", SPECIAL_AUTHORITY_FOR_AUTHORIZED_USERS, currentUser);
						mappedAuthorities.add(new SimpleGrantedAuthority(SPECIAL_AUTHORITY_FOR_AUTHORIZED_USERS));
					}
					mappedAuthorities.add(authority);
				}
				
			});
			return mappedAuthorities;
		};
	}
	
	public static String getOauthUser (Authentication authentication) {
		String userDesc = "-";
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof DefaultOAuth2User){
				DefaultOAuth2User oAuth2User = (DefaultOAuth2User)principal;
				Map<String, Object> attributes = oAuth2User.getAttributes();
				userDesc = (String)attributes.get("login");
			}
			else {
				LOG.debug("Principal class: "+principal.getClass().getName());
				LOG.debug(""+authentication);
				userDesc = authentication.getName();
			}
		}
		return userDesc;
	}
}
