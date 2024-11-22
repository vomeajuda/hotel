package com.hotel.models;

import java.util.Vector;

public class Quarto { //criação do modelo de quarto
    private int quarto; //declaração de todos os atributos
    private int acomoda;
    private int varanda;
    private boolean varandac;
    private int microondas;
    private boolean microondasc;
    private int frigobar;
    private boolean frigobarc;
    private int tv;
    private boolean tvc;
    private String cpf;
    private int ocupado;
    private boolean ocupadoc;
    private String quartoc;

    private Vector<Object> linha = new Vector<>();

    public Quarto(){ //construtor vazio

    }

    public Quarto(int quarto){ //construtor para passar apenas o numero do quarto
        this.quarto = quarto;
    }

    public Quarto(int quarto, int acomoda, String cpf, boolean varandac, boolean microondasc, boolean frigobarc, boolean tvc, boolean ocupadoc){ //construtor com todas as informações do quarto em bool
        this.quarto = quarto;
        this.acomoda = acomoda;
        this.cpf = cpf;
        this.varandac = varandac;
        this.microondasc = microondasc;
        this.frigobarc = frigobarc;
        this.tvc = tvc;
        this.ocupadoc = ocupadoc;
    }

    public Quarto(int quarto, int acomoda, String cpf, int varanda, int microondas, int frigobar, int tv, int ocupado){ //construtor com todas as informações do quarto em int
        this.quarto = quarto;
        this.acomoda = acomoda;
        this.cpf = cpf;
        this.varanda = varanda;
        this.microondas = microondas;
        this.frigobar = frigobar;
        this.tv = tv;
        this.ocupado = ocupado;
    }

    //daqui pra baixo getters e setters de todos os atributos

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

    public boolean getVarandac() {
        return varandac;
    }

    public void setVarandac(boolean varandac) {
        this.varandac = varandac;
    }

    public int getMicroondas() {
        return microondas;
    }

    public void setMicroondas(int microondas) {
        this.microondas = microondas;
    }

    public boolean getMicroondasc() {
        return microondasc;
    }

    public void setMicroondasc(boolean microondasc) {
        this.microondasc = microondasc;
    }

    public int getFrigobar() {
        return frigobar;
    }

    public void setFrigobar(int frigobar) {
        this.frigobar = frigobar;
    }

    public boolean getFrigobarc() {
        return frigobarc;
    }

    public void setFrigobarc(boolean frigobarc) {
        this.frigobarc = frigobarc;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public boolean getTvc() {
        return tvc;
    }

    public void setTvc(boolean tvc) {
        this.tvc = tvc;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    public boolean getOcupadoc() {
        return ocupadoc;
    }

    public void setOcupadoc(boolean ocupadoc) {
        this.ocupadoc = ocupadoc;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public Vector<Object> getLinha(){
        return linha;
    }

    public void setLinha(Vector<Object> linha){
        this.linha = linha;
    }

    public String getQuartoc() {
        return quartoc;
    }

    public void setQuartoc(String quartoc) {
        this.quartoc = quartoc;
    }
}