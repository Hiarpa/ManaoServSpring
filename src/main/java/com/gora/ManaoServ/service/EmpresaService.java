package com.gora.ManaoServ.service;

import com.gora.ManaoServ.model.Autonomo;
import com.gora.ManaoServ.model.Empresa;
import com.gora.ManaoServ.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getEmpresaById(Integer empresaId){
        return empresaRepository.findById(empresaId);
    }

    public void addNewEmpresa(Empresa empresa){
        Optional<Empresa> empresaOptional =  Optional.ofNullable(empresaRepository.findEmpresaByCNPJ(empresa.getCnpj()));
        if(empresaOptional.isPresent()){
            throw new IllegalStateException("Este CNPJ já esta sendo utilizado!!");
        }
        empresaRepository.save(empresa);
    }

    @Transactional
    public void updateEmpresa(Integer empresaId, Empresa empresaDetails){
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(() -> new IllegalStateException(" Empresa com id " + empresaId + "não existe!!."));

        if (empresaDetails.getNomeEmpresa() != null && empresaDetails.getNomeEmpresa().length() > 0 && !Objects.equals(empresa.getNomeEmpresa(), empresaDetails.getNomeEmpresa())){
            empresa.setNomeEmpresa(empresaDetails.getNomeEmpresa());
        }
        if (empresaDetails.getTelefoneEmpresa() != null && empresaDetails.getTelefoneEmpresa().length() > 0 && !Objects.equals(empresa.getTelefoneEmpresa(), empresaDetails.getTelefoneEmpresa())){
            empresa.setTelefoneEmpresa(empresaDetails.getTelefoneEmpresa());
        }
        if (empresaDetails.getEmailEmpresa() != null && empresaDetails.getEmailEmpresa().length() > 0 && !Objects.equals(empresa.getEmailEmpresa(), empresaDetails.getEmailEmpresa())){
            empresa.setEmailEmpresa(empresaDetails.getEmailEmpresa());
        }
        if (empresaDetails.getDescricaoEmpresa() != null && empresaDetails.getDescricaoEmpresa().length() > 0 && !Objects.equals(empresa.getDescricaoEmpresa(), empresaDetails.getDescricaoEmpresa())){
            empresa.setDescricaoEmpresa(empresaDetails.getDescricaoEmpresa());
        }
    }
}
