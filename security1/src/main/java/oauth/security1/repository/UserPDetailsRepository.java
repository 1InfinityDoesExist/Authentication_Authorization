package oauth.security1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import oauth.security1.entity.UserPDetails;

@Repository
public interface UserPDetailsRepository extends MongoRepository<UserPDetails, String> {

	public UserPDetails findByUserName(String username);

}
