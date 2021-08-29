package com.gora.ManaoServ.service;

import com.gora.ManaoServ.model.Endereco;
import com.gora.ManaoServ.model.Servicos;
import com.gora.ManaoServ.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServicoAppService {
    private final ServicosRepository servicosRepository;

    @Autowired
    public ServicoAppService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public List<Servicos> getServico(){
        return servicosRepository.findAll();
    }

    public Optional<Servicos> getServicoById(Integer servicoId){
        return servicosRepository.findById(servicoId);
    }

    public void addNewServico(Servicos servico){
        servicosRepository.save(servico);
    }

    @Transactional
    public void updateServico(Integer servicoId, Servicos servicoDetails){
        Servicos servico = servicosRepository.findById(servicoId).orElseThrow(() -> new IllegalStateException(" servico com id" + servicoId + " não existe!!."));

        if (servicoDetails.getTagServicos() != null && servicoDetails.getTagServicos().length() > 0 && !Objects.equals(servico.getTagServicos(), servicoDetails.getTagServicos())){
            servico.setTagServicos(servicoDetails.getTagServicos());
        }
    }
}
