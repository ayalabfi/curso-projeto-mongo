package com.ayala.workshopmongo.repository;

import com.ayala.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query Method para obter titulos contendo um texto específico
    List<Post> findByTitleContainingIgnoreCase(String text);

}