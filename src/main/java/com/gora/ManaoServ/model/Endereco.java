package com.gora.ManaoServ.model;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @Column(name = "id_endereco", nullable = false, length = 200)
    public Integer idEndereco;

    @Column(nullable = false, length = 200)
    public String rua;

    @Column(nullable = false, length = 200)
    public String numero;

    @Column(nullable = false, length = 200)
    public String bairro;

    @Column(nullable = false, length = 200)
    public String cep;

    @ManyToOne
    @JoinColumn(name = "fk_id_autonomo")
    private Autonomo autonomo;

    @ManyToOne
    @JoinColumn(name = "fk_id_empresa")
    private Empresa empresa;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Endereco(Integer idEndereco, String rua, String numero, String bairro, String cep, Autonomo autonomo, Empresa empresa) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.autonomo = autonomo;
        this.empresa = empresa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
