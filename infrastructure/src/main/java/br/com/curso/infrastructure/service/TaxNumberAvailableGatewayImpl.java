package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Inicio da verificação se o TaxNumber está disponível");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
