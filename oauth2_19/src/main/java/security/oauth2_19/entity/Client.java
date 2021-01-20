package security.oauth2_19.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.Data
@Document(collection = "client")
public class Client {

	@Id
	private String id;
	private String clientId;
	private String clientSecret;
	private String grantType;
	private String scope;
}
