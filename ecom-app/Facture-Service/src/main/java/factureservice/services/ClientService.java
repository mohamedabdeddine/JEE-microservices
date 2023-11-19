package factureservice.services;


import factureservice.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientService {
    @GetMapping("/clients/{clientId}")
    Client findById(@PathVariable Long clientId);

    @GetMapping("/clients")
    List<Client> findAllClients();
}
