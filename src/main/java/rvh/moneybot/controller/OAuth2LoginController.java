package rvh.moneybot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rvh.moneybot.common.LoginDetails;
import rvh.moneybot.common.Oauth2LoginAuthorization;
import rvh.moneybot.services.Oauth2AccessTokenService;
import rvh.moneybot.services.UriBuilderService;

@RestController
public class OAuth2LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2LoginController.class);
	@Autowired
	private UriBuilderService uriBuilderService;

	@Autowired
	private Oauth2AccessTokenService accessTokenService;

	@GetMapping("/login/urls")
	public String getLoginDetails() {
		LOGGER.debug("Entered getLoginDetails()");
		LOGGER.info("info test");
		return uriBuilderService.buildLoginUri().getOauthLoginUrl();
	}

	@GetMapping("/login/oauth2/code/aliceblue")
	public String aliceBlueLogin(@RequestParam String code, @RequestParam String scope, @RequestParam String state) {
		Oauth2LoginAuthorization authTo = new Oauth2LoginAuthorization();
		authTo.setCode(code);
		authTo.setScope(scope);
		authTo.setState(state);
		accessTokenService.fetchAndSaveAccessToken(authTo);
		return "Success";
	}
}
