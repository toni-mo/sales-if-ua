package sales.client.service;

import sales.client.domain.Client;

import java.util.List;

public interface IClientService {

    public Client addClient(Client client);
    public Client getClientById(Long id);
    public Client deleteClientById(Long id);
    public List getAllClients();
    public Client editClient(Client client);
    public List<Client> searchClientByNameAndSurname(String name, String surname);
    public List<Client> getAll(int page, int amount, String field);

}