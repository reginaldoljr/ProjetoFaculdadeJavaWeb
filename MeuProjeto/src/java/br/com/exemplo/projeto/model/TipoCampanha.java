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
public class TipoCampanha {

    private int idTipoCampanha;
    private String nomeTipoCampanha;
    private String descricaoTipoCampanha;

    public TipoCampanha() {
        this.idTipoCampanha = 0;
        this.nomeTipoCampanha = "";
        this.descricaoTipoCampanha = "";
    }

    public int getIdTipoCampanha() {
        return idTipoCampanha;
    }

    public void setIdTipoCampanha(int idTipoCampanha) {
        this.idTipoCampanha = idTipoCampanha;
    }

    public String getNomeTipoCampanha() {
        return nomeTipoCampanha;
    }

    public void setNomeTipoCampanha(String nomeTipoCampanha) {
        this.nomeTipoCampanha = nomeTipoCampanha;
    }

    public String getDescricaoTipoCampanha() {
        return descricaoTipoCampanha;
    }

    public void setDescricaoTipoCampanha(String descricaoTipoCampanha) {
        this.descricaoTipoCampanha = descricaoTipoCampanha;
    }

}
