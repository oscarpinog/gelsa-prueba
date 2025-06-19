package com.alianza.fiduciaria.facade;


import com.alianza.fiduciaria.DTO.RecargaDTO;
import com.alianza.fiduciaria.service.RecargaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecargaFacade {

     private final RecargaService recargaService;

    public RecargaFacade(final RecargaService recargaService) {
        this.recargaService = recargaService;
    }

    public List<RecargaDTO> getAllRecarga() {
        // Business Logic.
        return this.recargaService.getAllRecarga();
    }

    public RecargaDTO createRecarga(final RecargaDTO recarga) {
        // Validations.
        if (recarga == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.recargaService.createRecarga(recarga);
    }

    public RecargaDTO updateRecarga(final RecargaDTO recargaUpdate) {
        // Validations.
        if (recargaUpdate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.recargaService.updateRecarga(recargaUpdate);
    }

    public RecargaDTO deleteRecarga(final String ID) {
        // Validations.
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException(String.format("The ID is null or empty", ID));
        }

        // Business Logic.
        return this.recargaService.deleteRecarga(ID);
    }


    public RecargaDTO getBySharedKey(String sharedKey) {
        if (sharedKey.isEmpty() || sharedKey.isBlank()) {
            throw new IllegalArgumentException(String.format("The sharedKey is  empty", sharedKey));
        }

        // Business Logic.
        return this.recargaService.getBySharedKey(sharedKey);

    }
}
