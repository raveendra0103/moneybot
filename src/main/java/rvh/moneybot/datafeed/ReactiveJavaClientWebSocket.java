package rvh.moneybot.datafeed;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveJavaClientWebSocket {
	private static Logger logger = LoggerFactory.getLogger(ReactiveJavaClientWebSocket.class);

	public static void main(String[] args) throws InterruptedException, Exception {

		/*
		 * WebSocketClient client = new ReactorNettyWebSocketClient();
		 * client.execute( URI.create("wss://echo.websocket.org/"), session ->
		 * session.send( Mono.just(session.textMessage(
		 * "event-spring-reactive-client-websocket")))
		 * .thenMany(session.receive() .map(WebSocketMessage::getPayloadAsText)
		 * .log()) .then() .block(Duration.ofSeconds(10L));
		 */

		logger.debug("Test");
		logger.info("Test");
		// myTest();
		/*
		 * WebSocketClient client = new ReactorNettyWebSocketClient();
		 * client.execute(URI.create("wss://echo.websocket.org"), session ->
		 * session.send(Mono.just( session.textMessage("{\"event\":\"ping\"}")))
		 * .thenMany(session .receive() .map(WebSocketMessage::getPayloadAsText)
		 * .log()) .then()).block(Duration.ofSeconds(10));
		 * System.out.println("End");
		 */

	}
}