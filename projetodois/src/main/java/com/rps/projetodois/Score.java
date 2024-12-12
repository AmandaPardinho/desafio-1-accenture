package com.rps.projetodois;

import org.springframework.data.annotation.Id;

public class Score {

    @Id
    private Integer id;

    private int vitorias, derrotas, empates;

    public Score() {
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
    }

    //setters e getters
    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }
    
    public int getVitorias() {
        return vitorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getEmpates() {
        return empates;
    }

    //métodos de incremento
    public void incrementaVitorias() {
        this.vitorias++;
    }

    public void incrementaDerrotas() {
        this.derrotas++;
    }

    public void incrementaEmpates() {
        this.empates++;
    }
}
