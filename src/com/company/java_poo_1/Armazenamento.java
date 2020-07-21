package com.company.java_poo_1;

import java.io.Serializable;

public class Armazenamento extends Produto implements Serializable {
    private int capacidade;
    private String unidade;

    public Armazenamento() {
        this.capacidade = 1;
        this.unidade="Byte";
    }

    public Armazenamento(int capacidade, String unidade) {
        this.capacidade = capacidade;
        this.unidade = unidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString(){
        String resultado=super.toString();
        //exemplo super
        resultado += " capacidade='" + getCapacidade() + "'";
        resultado += " unidade='" + getUnidade() + "'";
        return resultado;
    }



}
