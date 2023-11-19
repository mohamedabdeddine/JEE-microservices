package clientservice.Controllers;


import clientservice.repositories.ClientRepo;
import clientservice.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/clients")
public class ClientController {
    private final ClientRepo clientRepository;

    @Autowired
    public ClientController(ClientRepo clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
     return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    }
}
