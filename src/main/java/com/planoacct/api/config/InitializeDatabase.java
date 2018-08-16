package com.planoacct.api.config;


import com.planoacct.api.data.ClientRepository;
import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class InitializeDatabase {
    @Bean
    public CommandLineRunner demo(ClientRepository repository) {
        return (args) -> {
            // save a couple of clients
            repository.save(new Client("Jack", ClientType.INDIVIDUAL, "Plano"));
        };
    }
}
