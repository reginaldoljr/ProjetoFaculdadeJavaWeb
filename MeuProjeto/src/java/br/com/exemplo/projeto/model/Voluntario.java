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
public class Voluntario extends Pessoa {

    private int idVoluntario;
   


    public Voluntario(int idPessoa, String nomePessoa, String cpf_cnpj, String tipoPessoa, String email, String senha) {
        super(idPessoa, nomePessoa, cpf_cnpj, tipoPessoa, email, senha);
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }


    
    
    
}
