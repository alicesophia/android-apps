package com.example.cadastropedidos;

public class Produto {

    private String id;
    private String codigo;
    private String descricao;
    private String valor;
    private String qtdEstoque;

    public Produto(){
    }

    public Produto(String id, String codigo, String descricao, String valor, String qtdEstoque){
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(String qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
