package br.com.fiap.mercado.view;

import java.util.Date;

public class GastoModel {

    private String gastoName;
    private String gastoType;
    private String descricao;
    private double valor;
    private Date dataMovimentacao;
    private int quantidadeParcelas;

    public GastoModel() {
    }

    public GastoModel(String gastoName, String gastoType, String descricao, double valor, Date dataMovimentacao, int quantidadeParcelas) {
        this.gastoName = gastoName;
        this.gastoType = gastoType;
        this.descricao = descricao;
        this.valor = valor;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getGastoName() {
        return gastoName;
    }

    public void setGastoName(String gastoName) {
        this.gastoName = gastoName;
    }

    public String getGastoType() {
        return gastoType;
    }

    public void setGastoType(String gastoType) {
        this.gastoType = gastoType;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }
}