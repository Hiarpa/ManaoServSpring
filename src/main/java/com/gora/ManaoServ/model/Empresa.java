package com.gora.ManaoServ.model;

import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table("empresa")
public class Empresa {

    @Id
    private Integer idEmpresa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    private Integer idServico;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String nome, String senha, Integer idServico) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.senha = senha;
        this.idServico = idServico;
    }

    public Empresa(String nome, String senha, Integer idServico) {
        this.nome = nome;
        this.senha = senha;
        this.idServico = idServico;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }
}
