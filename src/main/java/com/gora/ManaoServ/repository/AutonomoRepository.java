package com.gora.ManaoServ.repository;

import com.gora.ManaoServ.model.Autonomo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutonomoRepository extends JpaRepository<Autonomo, Integer> {

    @Query("SELECT s FROM Autonomo s WHERE s.cpfAutonomo = ?1")
    Autonomo findAutonomoByCpf(Integer cpf);

}
