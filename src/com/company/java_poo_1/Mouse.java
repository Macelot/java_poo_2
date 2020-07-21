package com.company.java_poo_1;

import java.io.Serializable;

public class Mouse extends Produto implements Serializable {
    String tipo;
    String cor;
    int quantidadeEstoque;

    public Mouse() {
    }

    public Mouse(String tipo, String cor) {
        this.tipo = tipo;
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString(){
        String resultado="";
        resultado += " tipo='" + getTipo()+ "'";
        resultado += " cor='" + getCor()+ "'";
        resultado += " quantidadeEstoque='" + getQuantidadeEstoque() + "'";
        return resultado;

    }


}
