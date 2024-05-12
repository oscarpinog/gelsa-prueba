package com.alianza.fiduciaria.respository;


import com.alianza.fiduciaria.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {

    public ClientEntity findBySharedKey(String sharedKey);
}
