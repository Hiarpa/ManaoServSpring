package com.gora.ManaoServ.controller;

import com.gora.ManaoServ.model.Autonomo;
import com.gora.ManaoServ.service.AutonomoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/autonomos")
public class AutonomoController {

    @Autowired
    private final AutonomoService autonomoService;

    public AutonomoController(AutonomoService autonomoService) {
        this.autonomoService = autonomoService;
    }

    @GetMapping("/list")
    public List<Autonomo> getAutonomos(){
        return autonomoService.getAutonomos();
    }

    @GetMapping("/list/search/{autonomoId}")
    public Optional<Autonomo> getAutonomoById(@PathVariable Integer autonomoId) {
        return autonomoService.getAutonomoById(autonomoId);
    }

    @PostMapping("/record")
    public void registerNewAutonomo(@RequestBody Autonomo autonomo){
        autonomoService.addNewAutonomo(autonomo);
    }

    @PatchMapping(path = "/list/patch/{autonomoId}")
    public void updateAutonomo(@PathVariable("autonomoId") Integer autonomoId, @RequestBody Autonomo autonomo){
        autonomoService.updateAutonomo(autonomoId,autonomo);
    }
}
