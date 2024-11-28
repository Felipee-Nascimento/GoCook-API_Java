package br.com.gocook.specification;

import br.com.gocook.domain.receitas.Receita;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class ReceitaSpecification {

    public static Specification<Receita> hasUserId(String userId) {
        return (root, query, criteriaBuilder) ->
                userId == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("user").get("id"), userId);
    }

    public static Specification<Receita> hasNome(String nome) {
        return (root, query, criteriaBuilder) ->
                nome == null || nome.isEmpty() ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Receita> hasCategoria(String categoria) {
        return (root, query, criteriaBuilder) ->
                categoria == null || categoria.isEmpty() ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("categoria"), categoria);
    }
}