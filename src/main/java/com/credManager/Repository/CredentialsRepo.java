package com.credManager.Repository;

import com.credManager.model.UserLoginDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

//public interface CredentialsRepo extends CrudRepository<UserLoginDetails,Integer> {
//}
public interface CredentialsRepo extends MongoRepository<UserLoginDetails,Integer> {
}