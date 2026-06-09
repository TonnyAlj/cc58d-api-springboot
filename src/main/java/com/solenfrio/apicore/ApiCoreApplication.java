package com.solenfrio.apicore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(title = "API Core TAC",
	 version = "1.0.1", 
	 contact = @Contact(name = "Solenfrio", email = "solenfrio@example.com"),
	 description = "API da disciplina TAC...",
	summary = "Api Bagual kkk",
	license = @License(name = "MIT", url = "https://opensource.org/license/mit/")
	),
	servers = {
		@Server(url = "http://localhost:8080", description = "Servidor local"),
		@Server(url = "https://api-core-tac-production.up.railway.app", description = "Servidor de produção"),
	}
)
@SpringBootApplication
public class ApiCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCoreApplication.class, args);
	}

}
