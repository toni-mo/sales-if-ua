package sales.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.client.domain.Client;
import sales.client.repository.ClientRepository;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findOne(id);
    }

    public Client deleteClientById(Long id) {
        Client client = clientRepository.findOne(id);
        clientRepository.removeById(id);
        return client;
    }

    public List getAllClients() {
        return clientRepository.findAll();
    }

    public Client editClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> searchClientByNameAndSurname(String name, String surname) {
        return clientRepository.findByFirstNameAndLastName(name, surname);
    }

    public List<Client> getAll(int page, int amount, String field) {
        Sort sort = new Sort(Sort.Direction.ASC, field);
        PageRequest pageRequest = new PageRequest(page, amount, sort);
        return clientRepository.findAll(pageRequest).getContent();
    }
}
