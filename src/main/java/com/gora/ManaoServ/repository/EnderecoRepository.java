package com.gora.ManaoServ.repository;

import com.gora.ManaoServ.model.Empresa;
import com.gora.ManaoServ.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT s FROM Endereco s WHERE s.cep = ?1")
    Empresa findEnderecoByCEP(String cep);

}
