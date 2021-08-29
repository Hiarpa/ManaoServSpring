package com.gora.ManaoServ.controller;

import com.gora.ManaoServ.model.Empresa;
import com.gora.ManaoServ.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/empresas")
public class EmpresaController {

    @Autowired
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/list")
    public List<Empresa> getEmpresas(){
        return empresaService.getEmpresas();
    }

    @GetMapping("/list/search/{empresaId}")
    public Optional<Empresa> getEmpresaById(@PathVariable Integer empresaId){
        return empresaService.getEmpresaById(empresaId);
    }

    @PostMapping("/record")
    public void registerNewEmpresa(@RequestBody Empresa empresa){
        empresaService.addNewEmpresa(empresa);
    }

    @PatchMapping("/list/patch/{empresaId}")
    public void updateEmpresa(@PathVariable("empresaId") Integer empresaId, @RequestBody Empresa empresa){
        empresaService.updateEmpresa(empresaId, empresa);
    }
}
