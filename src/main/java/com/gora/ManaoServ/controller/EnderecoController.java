package com.gora.ManaoServ.controller;

import com.gora.ManaoServ.model.Autonomo;
import com.gora.ManaoServ.model.Endereco;
import com.gora.ManaoServ.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/endereco")
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping(path = "/list")
    public List<Endereco> getEnderecos(){
        return enderecoService.getEnderecos();
    }

    @GetMapping(path = "/list/search/{enderecoId}")
    public Optional<Endereco> getEnderecoById(@PathVariable Integer enderecoId){
        return enderecoService.getEnderecoById(enderecoId);
    }

    @PostMapping(path = "/record")
    public void registerNewEndereco(@RequestBody Endereco endereco){
        enderecoService.addNewEndereco(endereco);
    }

    @PatchMapping(path = "/list/patch/{enderecoId}")
    public void updateEndereco(@PathVariable("enderecoId") Integer enderecoId, @RequestBody Endereco endereco){
        enderecoService.updateEndereco(enderecoId,endereco);
    }
}
