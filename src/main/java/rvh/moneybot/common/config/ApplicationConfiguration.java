package rvh.moneybot.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = "classpath:moneybot.properties")
public class ApplicationConfiguration {

	@Value("${oauth2.client.id}")
	private String oauthClientId;
	
	@Value("${outh2.client.secret}")
	private String oauthClientSecret;
	
	@Value("${oauth2.redirect.uri}")
	private String oauthRedirectUri;
	
	@Value("${oauth2.login.uri}")
	private String oauthLoginUri;
	
	@Value("${oauth2.login.state}")
	private String ouathLoginState;
	
	@Value("${oauth2.login.scope}")
	private String ouathLoginScope;
	
	@Value("${oauth2.base.uri}")
	private String oauthBaseUri;
	
	@Value("${oauth2.token.resource}")
	private String	oauthTokenResource;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
