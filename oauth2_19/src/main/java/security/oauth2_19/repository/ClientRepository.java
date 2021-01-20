package security.oauth2_19.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import security.oauth2_19.entity.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

	public Client findClientByClientId(String clientId);

}
