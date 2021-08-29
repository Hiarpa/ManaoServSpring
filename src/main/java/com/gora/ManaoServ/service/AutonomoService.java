package com.gora.ManaoServ.service;

import com.gora.ManaoServ.model.Autonomo;
import com.gora.ManaoServ.repository.AutonomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AutonomoService {
    private final AutonomoRepository autonomoRepository;

    @Autowired
    public AutonomoService(AutonomoRepository autonomoRepository) {
        this.autonomoRepository = autonomoRepository;
    }

    public List<Autonomo> getAutonomos(){
        return autonomoRepository.findAll();
    }

    public Optional<Autonomo> getAutonomoById(Integer autonomoId){
        return autonomoRepository.findById(autonomoId);
    }

    public void addNewAutonomo(Autonomo autonomo){
        Optional<Autonomo> autonomoOptional = Optional.ofNullable(autonomoRepository.findAutonomoByCpf(autonomo.getCpfAutonomo()));
        if(autonomoOptional.isPresent()){
            throw new IllegalStateException("Este CPF já esta sendo utilizado!!");
        }
        autonomoRepository.save(autonomo);
    }


    @Transactional
    public void updateAutonomo(Integer autonomoId, Autonomo autonomoDetails){
        Autonomo autonomo = autonomoRepository.findById(autonomoId).orElseThrow(() -> new IllegalStateException("Profissional autônomo com id " + autonomoId + " não existe!!."));

        if (autonomoDetails.getNomeAutonomo() != null && autonomoDetails.getNomeAutonomo().length() > 0 && !Objects.equals(autonomo.getNomeAutonomo(), autonomoDetails.getNomeAutonomo())){
            autonomo.setNomeAutonomo(autonomoDetails.getNomeAutonomo());
        }
        if (autonomoDetails.getTelefoneAutonomo() != null && autonomoDetails.getTelefoneAutonomo().length() > 0 && !Objects.equals(autonomo.getTelefoneAutonomo(), autonomoDetails.getTelefoneAutonomo())){
            autonomo.setTelefoneAutonomo(autonomoDetails.getTelefoneAutonomo());
        }
        if (autonomoDetails.getEmailAutonomo() != null && autonomoDetails.getEmailAutonomo().length() > 0 && !Objects.equals(autonomo.getEmailAutonomo(), autonomoDetails.getEmailAutonomo())){
            autonomo.setEmailAutonomo(autonomoDetails.getEmailAutonomo());
        }
        if (autonomoDetails.getDescricaoAutonomo() != null && autonomoDetails.getDescricaoAutonomo().length() > 0 && !Objects.equals(autonomo.getDescricaoAutonomo(), autonomoDetails.getDescricaoAutonomo())){
            autonomo.setTelefoneAutonomo(autonomoDetails.getDescricaoAutonomo());
        }
    }

}
