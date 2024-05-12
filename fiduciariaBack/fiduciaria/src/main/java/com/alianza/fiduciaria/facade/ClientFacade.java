package com.alianza.fiduciaria.facade;


import com.alianza.fiduciaria.DTO.ClientDTO;
import com.alianza.fiduciaria.service.ClientService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientFacade {

     private final ClientService clientService;

    public ClientFacade(final ClientService clientService) {
        this.clientService = clientService;
    }

    public List<ClientDTO> getAllStudents() {
        // Business Logic.
        return this.clientService.getAllClients();
    }

    public ClientDTO createStudent(final ClientDTO studentToCreate) {
        // Validations.
        if (studentToCreate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.clientService.createStudent(studentToCreate);
    }

    public ClientDTO updateStudent(final ClientDTO studentToUpdate) {
        // Validations.
        if (studentToUpdate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.clientService.updateStudent(studentToUpdate);
    }

    public ClientDTO deleteStudent(final String ID) {
        // Validations.
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException(String.format("The ID is null or empty", ID));
        }

        // Business Logic.
        return this.clientService.deleteStudent(ID);
    }


    public ClientDTO getBySharedKey(String sharedKey) {
        if (sharedKey.isEmpty() || sharedKey.isBlank()) {
            throw new IllegalArgumentException(String.format("The sharedKey is  empty", sharedKey));
        }

        // Business Logic.
        return this.clientService.getBySharedKey(sharedKey);

    }
}
