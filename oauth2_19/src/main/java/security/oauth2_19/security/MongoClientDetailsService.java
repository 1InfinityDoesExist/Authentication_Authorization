package security.oauth2_19.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import security.oauth2_19.entity.Client;
import security.oauth2_19.entity.SecurityClient;
import security.oauth2_19.repository.ClientRepository;

public class MongoClientDetailsService implements ClientDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

		Client client = clientRepository.findClientByClientId(clientId);
		return new SecurityClient(client);
	}

	// tenantId + ClientId combination will work...

//	12345 ---- gaian
//	12345 -----epg

}
