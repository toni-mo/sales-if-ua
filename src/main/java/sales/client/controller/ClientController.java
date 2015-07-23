package sales.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sales.client.domain.Client;
import sales.client.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;


    public ClientController() {
    }

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Client getClientByID(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes="application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            consumes="application/json",
            produces = "application/json")
    public Client updateClient(@RequestBody Client client) {
        return clientService.editClient(client);
    }

    @RequestMapping(value = "/remove/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public Client removeClient(@PathVariable("id") Long id) {
        return clientService.deleteClientById(id);
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public List<Client> clientSearch(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "surname") String surname) {
        return clientService.searchClientByNameAndSurname(name, surname);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/page",
            produces = "application/json")
    public List<Client> getAll(@RequestParam(value ="page") int page, @RequestParam(value = "amount") int amount) {
        return clientService.getAll(page, amount, "id");
    }
}
