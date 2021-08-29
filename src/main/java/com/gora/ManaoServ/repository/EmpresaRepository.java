package com.gora.ManaoServ.repository;

import com.gora.ManaoServ.model.Autonomo;
import com.gora.ManaoServ.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Query("SELECT s FROM Empresa s WHERE s.cnpj = ?1")
    Empresa findEmpresaByCNPJ(Integer cnpj);
}
