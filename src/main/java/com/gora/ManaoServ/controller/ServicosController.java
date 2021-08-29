package com.gora.ManaoServ.controller;

import com.gora.ManaoServ.model.Autonomo;
import com.gora.ManaoServ.model.Servicos;
import com.gora.ManaoServ.service.ServicoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/servicos")
public class ServicosController {

    @Autowired
    private final ServicoAppService servicoAppService;

    public ServicosController(ServicoAppService servicoAppService) {
        this.servicoAppService = servicoAppService;
    }

    @GetMapping(path = "/list")
    public List<Servicos> getServicos(){
        return servicoAppService.getServico();
    }

    @GetMapping(path = "/list/search/{servicoId}")
    public Optional<Servicos> getServicosById(@PathVariable Integer servicoId){
        return servicoAppService.getServicoById(servicoId);
    }

    @PostMapping("/record")
    public void registerNewServico(Servicos servicos){
        servicoAppService.addNewServico(servicos);
    }

    @PatchMapping("/list/patch/{servicoId}")
    public void updateServico(@PathVariable("servicoId") Integer servicoId, @RequestBody Servicos servicos){
        servicoAppService.updateServico(servicoId,servicos);
    }
}
