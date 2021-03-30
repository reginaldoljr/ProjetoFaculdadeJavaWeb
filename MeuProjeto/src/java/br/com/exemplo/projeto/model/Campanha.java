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
public class Campanha { //campanha(dataentrega,horaentrega, detalhes,enderecoentrega,encerrado,idtipocampanha)
    private int idCampanha;
    private String dataEntrega;
    private String horaEntrega;
    private String detalhes;
    private String enderecoEntrega;
    private String encerrado;
    private TipoCampanha tipoCampanha;

    public Campanha() {
    this.idCampanha = 0;
    this.dataEntrega = "";
    this.horaEntrega = "";
    this.detalhes = "";
    this.enderecoEntrega = "";
    this.encerrado = "Não";
    TipoCampanha oTipoCampanha = new TipoCampanha();
    this.tipoCampanha = oTipoCampanha;
    }

    public Campanha(int idCampanha, String dataEntrega, String horaEntrega, String detalhes, String enderecoEntrega, String encerrado, TipoCampanha tipoCampanha) {
        this.idCampanha = idCampanha;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
        this.detalhes = detalhes;
        this.enderecoEntrega = enderecoEntrega;
        this.encerrado = encerrado;
        this.tipoCampanha = tipoCampanha;
    }

    public int getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(int idCampanha) {
        this.idCampanha = idCampanha;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getEncerrado() {
        return encerrado;
    }

    public void setEncerrado(String encerrado) {
        this.encerrado = encerrado;
    }

    public TipoCampanha getTipoCampanha() {
        return tipoCampanha;
    }

    public void setTipoCampanha(TipoCampanha tipoCampanha) {
        this.tipoCampanha = tipoCampanha;
    }
    
    
}
