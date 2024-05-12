package com.alianza.fiduciaria.config;


import com.alianza.fiduciaria.model.ClientEntity;
import com.alianza.fiduciaria.respository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSetup {

    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void setupData() {
        List<ClientEntity> clientEntities = new ArrayList<>();

        ClientEntity clientEntity = ClientEntity.builder()
                .sharedKey("orodriguez")
                .businessId("Oscar Rodriguez")
                .email("oscar.rodriguez@hotmail.com")
                .phone("3108375232")
                .dataAdded(LocalDate.of(2024,5,10))
                .build();

        ClientEntity clientEntity2 = ClientEntity.builder()
                .sharedKey("mmartinez")
                .businessId("Manuela Martinez")
                .email("mmartinez@gmail.com.com")
                .phone("3108378888")
                .dataAdded(LocalDate.of(2019,5,10))
                .build();

        ClientEntity clientEntity3 = ClientEntity.builder()
                .sharedKey("cariza")
                .businessId("Carlos Ariza")
                .email("cariza@gmail.com")
                .phone("3104445232")
                .dataAdded(LocalDate.of(2015,5,10))
                .build();

        clientEntities.add(clientEntity);
        clientEntities.add(clientEntity2);
        clientEntities.add(clientEntity3);
        this.clientRepository.saveAll(clientEntities);
    }
}
