package com.gora.ManaoServ.service;

import com.gora.ManaoServ.model.Empresa;
import com.gora.ManaoServ.model.Endereco;
import com.gora.ManaoServ.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getEnderecos(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> getEnderecoById(Integer enderecoId){
        return enderecoRepository.findById(enderecoId);
    }

    public void addNewEndereco(Endereco endereco){
        Optional<Empresa> enderecoOptional =  Optional.ofNullable(enderecoRepository.findEnderecoByCEP(endereco.getCep()));
        if(enderecoOptional.isPresent()){
            throw new IllegalStateException("Este CEP já esta sendo utilizado!!");
        }
        enderecoRepository.save(endereco);
    }

    @Transactional
    public void updateEndereco(Integer enderecoId, Endereco enderecoDetails){
        Endereco endereco = enderecoRepository.findById(enderecoId).orElseThrow(() -> new IllegalStateException(" endereco com id" + enderecoId + " não existe!!."));

        if (enderecoDetails.getNumero() != null && enderecoDetails.getNumero().length() > 0 && !Objects.equals(endereco.getNumero(), enderecoDetails.getNumero())){
            endereco.setNumero(enderecoDetails.getNumero());
        }
        if (enderecoDetails.getRua() != null && enderecoDetails.getRua().length() > 0 && !Objects.equals(endereco.getRua(), enderecoDetails.getRua())){
            endereco.setRua(enderecoDetails.getRua());
        }
        if (enderecoDetails.getBairro() != null && enderecoDetails.getBairro().length() > 0 && !Objects.equals(endereco.getBairro(), enderecoDetails.getBairro())){
            endereco.setBairro(enderecoDetails.getBairro());
        }
    }
}
