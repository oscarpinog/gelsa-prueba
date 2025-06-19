package com.alianza.fiduciaria.respository;


import com.alianza.fiduciaria.model.RecargaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargaRepository extends JpaRepository<RecargaEntity, String> {

    //public RecargaEntity findById(String sharedKey);
}
