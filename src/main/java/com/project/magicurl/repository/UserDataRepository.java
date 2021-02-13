package com.project.magicurl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.magicurl.entity.User;

@Repository
public interface UserDataRepository extends MongoRepository<User, String>{

	@Query("{ 'userName' : ?0 }")
    User findByUserName(String userName);
}
