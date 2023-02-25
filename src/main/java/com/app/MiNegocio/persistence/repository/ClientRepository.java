package com.app.MiNegocio.persistence.repository;

import com.app.MiNegocio.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByIdentificationNumber(Long identificationNumber);

    @Modifying
    @Query(value = "UPDATE CLIENT SET *", nativeQuery = true)
    Client updateClientData(Client client);

}
