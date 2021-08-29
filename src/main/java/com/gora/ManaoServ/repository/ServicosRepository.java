package com.gora.ManaoServ.repository;

import com.gora.ManaoServ.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Integer> {
}
