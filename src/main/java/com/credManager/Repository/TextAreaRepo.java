package com.credManager.Repository;

import com.credManager.model.UserLoginDetails;
import com.credManager.model.WritersContent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

//public interface TextAreaRepo extends CrudRepository<WritersContent,Integer> {
//}
public interface TextAreaRepo extends MongoRepository<WritersContent,Integer> {
}