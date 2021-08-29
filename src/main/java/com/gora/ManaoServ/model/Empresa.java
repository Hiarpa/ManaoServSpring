package com.gora.ManaoServ.model;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;

    @Column(name = "nome_empresa", nullable = false,length = 200)
    private String nomeEmpresa;

    @Column(name = "senha_empresa", nullable = false, length = 255)
    private String senhaEmpresa;

    @Column(name = "cnpj_empresa", nullable = false)
    private Integer cnpj;

    @Column(name = "telefone_empresa", nullable = false, length = 200)
    private String telefoneEmpresa;

    @Column(name = "email_empresa", nullable = false, length = 200)
    private String emailEmpresa;

    @Column(name = "razao_social_empresa", nullable = false, length = 200)
    private String razaoSocialEmpresa;

    @Column(name = "descricao_empresa", nullable = true, length = 255)
    private String descricaoEmpresa;

    @OneToMany
    @JoinColumn(name = "fk_id_empresa")
    private List<Servicos> listaServicos;

    @OneToMany
    @JoinColumn(name = "fk_id_empresa")
    private List<Servicos> listaEnderecos;


    public Empresa() {
    }

    public Empresa(String nomeEmpresa, String senhaEmpresa, Integer cnpj, String telefoneEmpresa, String emailEmpresa, String razaoSocialEmpresa, String descricaoEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        this.cnpj = cnpj;
        this.telefoneEmpresa = telefoneEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.razaoSocialEmpresa = razaoSocialEmpresa;
        this.descricaoEmpresa = descricaoEmpresa;
    }

    public Empresa(Integer idEmpresa, String nomeEmpresa, String senhaEmpresa, Integer cnpj, String telefoneEmpresa, String emailEmpresa, String razaoSocialEmpresa, String descricaoEmpresa, List<Servicos> listaServicos, List<Servicos> listaEnderecos) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        this.cnpj = cnpj;
        this.telefoneEmpresa = telefoneEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.razaoSocialEmpresa = razaoSocialEmpresa;
        this.descricaoEmpresa = descricaoEmpresa;
        this.listaServicos = listaServicos;
        this.listaEnderecos = listaEnderecos;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getRazaoSocialEmpresa() {
        return razaoSocialEmpresa;
    }

    public void setRazaoSocialEmpresa(String razaoSocialEmpresa) {
        this.razaoSocialEmpresa = razaoSocialEmpresa;
    }

    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }

    public List<Servicos> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servicos> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public List<Servicos> getListaEnderecos() {
        return listaEnderecos;
    }

    public void setListaEnderecos(List<Servicos> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }
}
