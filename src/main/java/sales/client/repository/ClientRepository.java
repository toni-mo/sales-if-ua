package sales.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.client.domain.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public void removeById(Long id);

    public List<Client> findByFirstNameAndLastName(String name, String surname);

}
