package com.alianza.fiduciaria.controller;


import com.alianza.fiduciaria.DTO.RecargaDTO;
import com.alianza.fiduciaria.facade.RecargaFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class RecargaController {

    private final RecargaFacade recargaFacade;

    public RecargaController(final RecargaFacade recargaFacade) {
        this.recargaFacade = recargaFacade;
    }

    @GetMapping
    public ResponseEntity<List<RecargaDTO>> getAllRecarga() {
        return new ResponseEntity<List<RecargaDTO>>(this.recargaFacade.getAllRecarga(),HttpStatus.OK);
    }

    @GetMapping("/shared-key/{sharedKey}")
    public ResponseEntity<RecargaDTO> getBySharedKey(@PathVariable(name = "sharedKey") String sharedKey) {
        return new ResponseEntity<RecargaDTO>(this.recargaFacade.getBySharedKey(sharedKey), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecargaDTO> createClient(@RequestBody RecargaDTO studentToCreate) {
        return new ResponseEntity<RecargaDTO>(this.recargaFacade.createRecarga(studentToCreate), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RecargaDTO> updateClient(@RequestBody RecargaDTO studentToUpdate) {
        return new ResponseEntity<RecargaDTO>(this.recargaFacade.updateRecarga(studentToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<RecargaDTO> deleteClient(@PathVariable(name = "ID") String ID) {
        return new ResponseEntity<RecargaDTO>(this.recargaFacade.deleteRecarga(ID), HttpStatus.OK);
    }
}
