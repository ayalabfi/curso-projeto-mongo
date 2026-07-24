package com.ayala.workshopmongo.repository;

import com.ayala.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

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

}