package com.ayala.workshopmongo.services.exception;

// Utilizamos a RuntimeException pois o compilador não exige o tratamento dessa exceção
public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
