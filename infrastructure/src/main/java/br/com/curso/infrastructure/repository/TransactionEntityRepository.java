package br.com.curso.infrastructure.repository;

import br.com.curso.infrastructure.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
