package com.gora.ManaoServ.model;

import javax.persistence.*;

@Entity
@Table(name = "servicos")
public class Servicos {

    @Id
    @Column(name = "id_servico")
    public Integer idServicos;

    @Column(name = "tag_servicos")
    public String tagServicos;

    @ManyToOne
    @JoinColumn(name = "fk_id_autonomo")
    private Autonomo autonomo;

    @ManyToOne
    @JoinColumn(name = "fk_id_empresa")
    private Empresa empresa;

    public Servicos() {
    }

    public Servicos(String tagServicos, Autonomo autonomo) {
        this.tagServicos = tagServicos;
        this.autonomo = autonomo;
    }

    public Servicos(Integer idServicos, String tagServicos, Autonomo autonomo, Empresa empresa) {
        this.idServicos = idServicos;
        this.tagServicos = tagServicos;
        this.autonomo = autonomo;
        this.empresa = empresa;
    }

    public Integer getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(Integer idServicos) {
        this.idServicos = idServicos;
    }

    public String getTagServicos() {
        return tagServicos;
    }

    public void setTagServicos(String tagServicos) {
        this.tagServicos = tagServicos;
    }

    public Autonomo getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(Autonomo autonomo) {
        this.autonomo = autonomo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
