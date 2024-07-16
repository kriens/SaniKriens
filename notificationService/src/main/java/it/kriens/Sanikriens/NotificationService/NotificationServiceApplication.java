package it.kriens.Sanikriens.NotificationService;

import it.kriens.Sanikriens.NotificationService.model.RemoteData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}



	@KafkaListener(id = "notificationService", topics = "remoteData")
	public void listen(ConsumerRecord<String, RemoteData> record){

		WebClient client = WebClient.create("http://localhost:8080");


		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("codiceFiscale", record.key());

		client
						.post()
						.uri("/api/patient/remoteData")
						.headers(h -> h.addAll(headers))
						.body(Mono.just(record.value()), RemoteData.class)
						.accept(APPLICATION_JSON)
						.retrieve()
						.bodyToMono(String.class)
						.subscribe(log::info);

	}
}
