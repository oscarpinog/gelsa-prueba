package com.alianza.fiduciaria.config;


import com.alianza.fiduciaria.model.RecargaEntity;
import com.alianza.fiduciaria.respository.RecargaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSetup {

    @Autowired
    private RecargaRepository clientRepository;

    @PostConstruct
    public void setupData() {
        List<RecargaEntity> recargaEntities = new ArrayList<>();

        RecargaEntity recEntity = RecargaEntity.builder()
				.cantidad(10)
				.valor(30450)
				.operador("Claro")
				.vendedor("Oscar Pino")
                .build();

        RecargaEntity recEntity2 = RecargaEntity.builder()
				.cantidad(10)
				.valor(21560)
				.operador("Movistar")
				.vendedor("Oscar Pino")
                .build();

        RecargaEntity recEntity3 = RecargaEntity.builder()
				.cantidad(10)
				.valor(38000)
				.operador("Tigo")
				.vendedor("Claudia Rodriguez")
                .build();

        recargaEntities.add(recEntity);
        recargaEntities.add(recEntity2);
        recargaEntities.add(recEntity3);
        this.clientRepository.saveAll(recargaEntities);
    }
}
