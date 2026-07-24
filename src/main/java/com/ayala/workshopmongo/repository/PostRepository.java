package com.ayala.workshopmongo.repository;

import com.ayala.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
/* Query Method do MongoDB. explicação abaixo:
  Query padrão: { '<field>': { $regex: /pattern/, $options: '<options>' } }.
  <field>: nome do campo que será utilizado para busca;
  $regex: qual será o valor buscado, ?0 é a primeira variável declarada, no caso abaixo, String text;
  $options: São as opções de incrementação de busca, que estão disponíveis no Doc. de Query MongoDB.

 */
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // Query Method para obter titulos contendo um texto específico
    List<Post> findByTitleContainingIgnoreCase(String text);

    /*
    Todas as Querys foram tiradas do doc. do MongoDB.
    and: serve para pegar 2 informações e comparar oque estiver entre (gte = maior ou igual | lte = menor ou igual)
    or: opção para pegar uma das opções dentro da chave
     */
    @Query("{ $and: [ { date: [$gte: ?1] }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    }
