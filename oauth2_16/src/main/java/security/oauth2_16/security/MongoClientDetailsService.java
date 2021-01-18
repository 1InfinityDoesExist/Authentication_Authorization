package security.oauth2_16.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import security.oauth2_16.entity.Client;
import security.oauth2_16.entity.SecurityClient;
import security.oauth2_16.repository.ClientRepository;

public class MongoClientDetailsService implements ClientDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		Client client = clientRepository.findClientByClientId(clientId);
		return new SecurityClient(client);
	}

}
