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
    public String nomePessoa;
    public String cpf_cnpj;
    public String tipoPessoa;
    public String emailusuario;
    public String senhausuario;

    
    public Pessoa(String nomePessoa, String cpf_cnpj, String tipoPessoa, String  emailusuario, String senhausuario) {
        this.nomePessoa = nomePessoa;
        this.cpf_cnpj = cpf_cnpj;
        this.tipoPessoa = tipoPessoa;
        this.emailusuario = emailusuario;
        this.senhausuario = senhausuario;
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

    public String getEmailUsuario() {
        return emailusuario;
    }

    public void setEmailUsuario(String email) {
        this.emailusuario = emailusuario;
    }

    public String getSenhaUsuario() {
        return senhausuario;
    }

    public void setSenhaUsuario(String senha) {
        this.senhausuario = senhausuario;
    }
    
}
