package com.gora.ManaoServ.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "autonomo")
public class Autonomo {

    @Id
    @Column(name = "id_autonomo")
    public Integer idAutonomo;

    @Column(name = "nome_autonomo")
    private String nomeAutonomo;

    @Column(name = "senha_autonomo")
    private String senhaAutonomo;

    @Column(name = "cpf_autonomo")
    private Integer cpfAutonomo;

    @Column(name = "telefone_autonomo")
    private String telefoneAutonomo;

    @Column(name = "email_autonomo")
    private String emailAutonomo;

    @Column(name = "razao_social_autonomo")
    private String razaoSocialAutonomo;

    @Column(name = "descricao_autonomo")
    private String descricaoAutonomo;

    @OneToMany
    @JoinColumn(name = "fk_id_autonomo")
    private List<Servicos> listaServicos;

    @OneToMany
    @JoinColumn(name = "fk_id_autonomo")
    private List<Endereco> listaEnderecos;

    public Autonomo() {
    }

    public Autonomo(String nomeAutonomo, String senhaAutonomo, Integer cpfAutonomo, String telefoneAutonomo, String emailAutonomo, String razaoSocialAutonomo, String descricaoAutonomo) {
        this.nomeAutonomo = nomeAutonomo;
        this.senhaAutonomo = senhaAutonomo;
        this.cpfAutonomo = cpfAutonomo;
        this.telefoneAutonomo = telefoneAutonomo;
        this.emailAutonomo = emailAutonomo;
        this.razaoSocialAutonomo = razaoSocialAutonomo;
        this.descricaoAutonomo = descricaoAutonomo;
    }

    public Autonomo(Integer idAutonomo, String nomeAutonomo, String senhaAutonomo, Integer cpfAutonomo, String telefoneAutonomo, String emailAutonomo, String razaoSocialAutonomo, String descricaoAutonomo, List<Servicos> listaServicos, List<Endereco> listaEnderecos) {
        this.idAutonomo = idAutonomo;
        this.nomeAutonomo = nomeAutonomo;
        this.senhaAutonomo = senhaAutonomo;
        this.cpfAutonomo = cpfAutonomo;
        this.telefoneAutonomo = telefoneAutonomo;
        this.emailAutonomo = emailAutonomo;
        this.razaoSocialAutonomo = razaoSocialAutonomo;
        this.descricaoAutonomo = descricaoAutonomo;
        this.listaServicos = listaServicos;
        this.listaEnderecos = listaEnderecos;
    }

    public Integer getIdAutonomo() {
        return idAutonomo;
    }

    public void setIdAutonomo(Integer idAutonomo) {
        this.idAutonomo = idAutonomo;
    }

    public String getNomeAutonomo() {
        return nomeAutonomo;
    }

    public void setNomeAutonomo(String nomeAutonomo) {
        this.nomeAutonomo = nomeAutonomo;
    }

    public String getSenhaAutonomo() {
        return senhaAutonomo;
    }

    public void setSenhaAutonomo(String senhaAutonomo) {
        this.senhaAutonomo = senhaAutonomo;
    }

    public Integer getCpfAutonomo() {
        return cpfAutonomo;
    }

    public void setCpfAutonomo(Integer cpfAutonomo) {
        this.cpfAutonomo = cpfAutonomo;
    }

    public String getTelefoneAutonomo() {
        return telefoneAutonomo;
    }

    public void setTelefoneAutonomo(String telefoneAutonomo) {
        this.telefoneAutonomo = telefoneAutonomo;
    }

    public String getEmailAutonomo() {
        return emailAutonomo;
    }

    public void setEmailAutonomo(String emailAutonomo) {
        this.emailAutonomo = emailAutonomo;
    }

    public String getRazaoSocialAutonomo() {
        return razaoSocialAutonomo;
    }

    public void setRazaoSocialAutonomo(String razaoSocialAutonomo) {
        this.razaoSocialAutonomo = razaoSocialAutonomo;
    }

    public String getDescricaoAutonomo() {
        return descricaoAutonomo;
    }

    public void setDescricaoAutonomo(String descricaoAutonomo) {
        this.descricaoAutonomo = descricaoAutonomo;
    }

    public List<Servicos> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servicos> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public void setListaEnderecos(List<Endereco> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }
}
