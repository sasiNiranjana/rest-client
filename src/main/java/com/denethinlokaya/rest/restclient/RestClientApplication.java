package com.denethinlokaya.rest.restclient;

import com.denethinlokaya.rest.restclient.entity.Request;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.set("Authorization","Basic YWRtaW46cHVibGlj");
			Request request=new Request("h1",2,0,"hello");
			HttpEntity<?> request1 = new HttpEntity<Object>(request,requestHeaders);
			int i;
			for(i=0;i<10000;i++){
				ResponseEntity<String> out=restTemplate.postForEntity("http://localhost:8080/api/v2/mqtt/publish",request1,String.class);
				System.out.println("code : "+out.getStatusCode()+" body : "+out.getBody());
			}
		};
	}
}
