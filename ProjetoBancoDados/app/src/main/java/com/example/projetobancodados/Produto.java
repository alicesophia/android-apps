package com.example.projetobancodados;

public class Produto {

    private int id;
    private String descricao;
    private double valor;
    private int qtdEstoque;

    public Produto(){

    }

    public Produto(int id, String descricao, double valor, int qtdEstoque){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
