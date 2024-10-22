package com.hotel.models;

public class Quarto {
    private int quarto;
    private int acomoda;
    private int varanda;
    private int microondas;
    private int frigobar;
    private int tv;
    private String cpf;
    private int ocupado;

    public Quarto(){

    }

    public Quarto(int quarto, int acomoda, String cpf, int varanda, int microondas, int frigobar, int tv, int ocupado){
        this.quarto = quarto;
        this.acomoda = acomoda;
        this.cpf = cpf;
        this.varanda = varanda;
        this.microondas = microondas;
        this.frigobar = frigobar;
        this.tv = tv;
        this.ocupado = ocupado;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public int getAcomoda() {
        return acomoda;
    }

    public void setAcomoda(int acomoda) {
        this.acomoda = acomoda;
    }

    public int getVaranda() {
        return varanda;
    }

    public void setVaranda(int varanda) {
        this.varanda = varanda;
    }

    public int getMicroondas() {
        return microondas;
    }

    public void setMicroondas(int microondas) {
        this.microondas = microondas;
    }

    public int getFrigobar() {
        return frigobar;
    }

    public void setFrigobar(int frigobar) {
        this.frigobar = frigobar;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
}
