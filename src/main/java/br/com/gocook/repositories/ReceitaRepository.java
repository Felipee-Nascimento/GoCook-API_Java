package br.com.gocook.repositories;

import br.com.gocook.domain.receitas.Receita;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>, JpaSpecificationExecutor<Receita> {
    List<Receita> findByUserId(String userId);
}
