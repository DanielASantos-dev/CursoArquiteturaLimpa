package br.com.curso.infrastructure.repository;

import br.com.curso.infrastructure.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
