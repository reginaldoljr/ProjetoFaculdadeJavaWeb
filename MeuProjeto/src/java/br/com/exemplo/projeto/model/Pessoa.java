/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.projeto.model;

/**
 *
 * @author reginaldo
 */
public class Pessoa {
    private int idPessoa;
    private String nomePessoa;
    private String cpf_cnpj;
    private String tipoPessoa;
    private String email;
    private String senha;

    
    public Pessoa(int idPessoa, String nomePessoa, String cpf_cnpj, String tipoPessoa, String  email, String senha) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpf_cnpj = cpf_cnpj;
        this.tipoPessoa = tipoPessoa;
        this.email = email;
        this.senha = senha;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
