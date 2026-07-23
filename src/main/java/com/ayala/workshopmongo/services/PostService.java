package com.ayala.workshopmongo.services;

import com.ayala.workshopmongo.domain.Post;
import com.ayala.workshopmongo.repository.PostRepository;
import com.ayala.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        // Optional evita o NullPointerException, lidando explicitamente com a ausência de um valor.
        Optional<Post> obj = repo.findById(id);
        // orElseThrow faz com que a exceção seja lançada de uma forma mais limpa no código.
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}