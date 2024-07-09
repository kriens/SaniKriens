package it.kriens.Sanikriens.NotificationService;

import it.kriens.Sanikriens.NotificationService.model.RemoteData;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}


	@Bean
	public NewTopic topic(){

		return TopicBuilder.name("remoteData")
				.partitions(10)
				.replicas(1).build();
	}

	@KafkaListener(id = "notificationService", topics = "remoteData")
	public void listen(RemoteData remoteData){

		WebClient client = WebClient.create("http://localhost:8080");


		final Mono<ClientResponse> postResponse =
				client
						.post()
						.uri("/people")
						.body(Mono.just(remoteData), RemoteData.class)
						.accept(APPLICATION_JSON)
						.retrieve()
						.bodyToMono(ClientResponse.class);
		postResponse
				.map(ClientResponse::statusCode)
				.subscribe(status -> System.out.println("POST: " + status.getClass()));
	}
}
