package br.com.curso.infrastructure.repository;

import br.com.curso.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByUserEntityTaxNumber(String taxNumber);
}
