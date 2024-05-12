package com.alianza.fiduciaria.controller;


import com.alianza.fiduciaria.DTO.ClientDTO;
import com.alianza.fiduciaria.facade.ClientFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientFacade clientFacade;

    public ClientController(final ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClient() {
        return new ResponseEntity<List<ClientDTO>>(this.clientFacade.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/shared-key/{sharedKey}")
    public ResponseEntity<ClientDTO> getBySharedKey(@PathVariable(name = "sharedKey") String sharedKey) {
        return new ResponseEntity<ClientDTO>(this.clientFacade.getBySharedKey(sharedKey), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO studentToCreate) {
        return new ResponseEntity<ClientDTO>(this.clientFacade.createStudent(studentToCreate), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO studentToUpdate) {
        return new ResponseEntity<ClientDTO>(this.clientFacade.updateStudent(studentToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable(name = "ID") String ID) {
        return new ResponseEntity<ClientDTO>(this.clientFacade.deleteStudent(ID), HttpStatus.OK);
    }
}
