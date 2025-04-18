package org.app.gerparque.models;

import java.time.LocalTime;

public class Atracao {

    private int id;
    private String nome;
    private LocalTime abertura;
    private LocalTime fechamento;
    private int capacidade;

    // Construtores, getters e setters
    public Atracao(String nome, LocalTime abertura, LocalTime fechamento, int capacidade) {
        this.nome = nome;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.capacidade = capacidade;
    }

    public Atracao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalTime abertura) {
        this.abertura = abertura;
    }

    public LocalTime getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalTime fechamento) {
        this.fechamento = fechamento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
