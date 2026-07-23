package com.ayala.workshopmongo.services;

import com.ayala.workshopmongo.domain.User;
import com.ayala.workshopmongo.dto.UserDTO;
import com.ayala.workshopmongo.repository.UserRepository;
import com.ayala.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id){
        // Optional evita o NullPointerException, lidando explicitamente com a ausência de um valor.
        Optional<User> obj = repo.findById(id);
        // orElseThrow faz com que a exceção seja lançada de uma forma mais limpa no código.
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}