package com.project.magicurl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.magicurl.entity.MagicUrl;

@Repository
public interface MagicUrlRepository extends MongoRepository<MagicUrl, String>{
	
	@Query("{ 'shortUrl' : ?0 }")
    MagicUrl findMagicUrlByShortUrl(String shortUrl);

	@Query("{ 'user_name' : ?0}")
	List<MagicUrl> findMagicUrlsByyUsername(String user_name);
}
