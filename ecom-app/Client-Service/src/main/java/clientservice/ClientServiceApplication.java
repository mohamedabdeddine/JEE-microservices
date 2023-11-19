package clientservice;

import clientservice.entities.Client;
import clientservice.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientServiceApplication implements CommandLineRunner{
    @Autowired
    ClientRepo clientRepo;

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    clientRepo.save(new Client(null, "client1", "test1", "test1"));
    clientRepo.save(new Client(null, "client2", "test2", "test2"));
    clientRepo.save(new Client(null, "client3", "test3", "test3"));
    }
}
