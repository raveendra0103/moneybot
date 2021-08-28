package rvh.moneybot.services;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import rvh.moneybot.common.Oauth2LoginAuthorization;

@Service
public class Oauth2AccessTokenService {
	@Autowired
	private Environment env;

	public void fetchAndSaveAccessToken(Oauth2LoginAuthorization oauth2Authorization) {
		String clientID = env.getProperty("oauth2.client.id");
		String clientSecret = env.getProperty("outh2.client.secret");
		StringBuilder encoderBuilder = new StringBuilder();
		encoderBuilder.append(clientID);
		encoderBuilder.append(":");
		encoderBuilder.append(env.getProperty("outh2.client.secret"));
		byte[] bytes = encoderBuilder.toString().getBytes(StandardCharsets.UTF_8);
		String basicauthentication = Base64Utils.encodeToString(bytes);
		String authenticationHeader = "Basic " + basicauthentication + "";
		String baseURL = env.getProperty("oauth2.base.uri");
		WebClient client1 = WebClient.builder().baseUrl(baseURL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.defaultUriVariables(Collections.singletonMap("url", baseURL)).build();

		@SuppressWarnings("unchecked")
		ResponseSpec resultPost = client1.post().uri(uriBuilder -> uriBuilder.path("/oauth2/token").build())
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).header("Authorization", authenticationHeader)
				.body(BodyInserters.fromFormData(buildRequestBody(oauth2Authorization))).retrieve();
		String responseBodyPost = resultPost.bodyToMono(String.class).block();
		System.out.println("authorize response - " + responseBodyPost);
	}

	private MultiValueMap<String, String> buildRequestBody(Oauth2LoginAuthorization oauth2Authorization) {
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
		formData.add("code", oauth2Authorization.getCode());
		formData.add("grant_type", "authorization_code");
		formData.add("response_type", "code");
		formData.add("client_id", env.getProperty("oauth2.client.id"));
		formData.add("redirect_uri", env.getProperty("oauth2.redirect.uri"));
		formData.add("authorization_response", "authorization_response");
		formData.add("client_secret_post", env.getProperty("outh2.client.secret"));
		return formData;
	}
}
