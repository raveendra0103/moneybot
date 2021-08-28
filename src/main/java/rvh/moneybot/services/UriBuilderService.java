package rvh.moneybot.services;

import static rvh.moneybot.common.MoneyBotConstants.CLIENT_ID_PARAM;
import static rvh.moneybot.common.MoneyBotConstants.REDIRECT_URI_PARAM;
import static rvh.moneybot.common.MoneyBotConstants.SCOPE_PARAM;
import static rvh.moneybot.common.MoneyBotConstants.STATE_PARAM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import rvh.moneybot.common.LoginDetails;
import rvh.moneybot.common.Oauth2LoginAuthorization;

@Service
public class UriBuilderService {
	@Autowired
	private Environment env;

	public LoginDetails buildLoginUri() {
		LoginDetails loginDetails = new LoginDetails();
		StringBuilder uriBuilder = new StringBuilder();
		uriBuilder.append(env.getProperty("oauth2.login.uri"));
		uriBuilder.append("&").append(CLIENT_ID_PARAM).append("=").append(env.getProperty("oauth2.client.id"));
		uriBuilder.append("&").append(REDIRECT_URI_PARAM).append("=").append(env.getProperty("oauth2.redirect.uri"));
		uriBuilder.append("&").append(SCOPE_PARAM).append("=").append(env.getProperty("oauth2.login.scope"));
		uriBuilder.append("&").append(STATE_PARAM).append("=").append(env.getProperty("oauth2.login.state"));
		System.out.println("Sample login URL - ");
		System.out.println(
				"https://ant.aliceblueonline.com/oauth2/auth?response_type=code&client_id=5YhbAKx4cM&redirect_uri=http://localhost:8080/login/oauth2/oauth/aliceblue&scope=orders&state=prod_state&access_type=authorization_code");
		System.out.println("Actual login URL - ");
		System.out.println(uriBuilder.toString());
		loginDetails.setOauthLoginUrl(uriBuilder.toString());
		return loginDetails;
	}
	
	public LoginDetails buildAccessTokenUri(Oauth2LoginAuthorization loginAuthorization){
		LoginDetails loginDetails = new LoginDetails();
		StringBuilder uriBuilder = new StringBuilder();
		
		return loginDetails;
	}
}
