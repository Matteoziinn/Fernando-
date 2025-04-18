package org.app.gerparque.models;

import java.time.LocalDateTime;

public class AtracaoCliente {
    private int id;
    private int idAtracao;
    private int idIngresso;
    private LocalDateTime horarioUso;

    public AtracaoCliente() {
    }

    public AtracaoCliente(int idAtracao, int idIngresso, LocalDateTime horarioUso) {
        this.idAtracao = idAtracao;
        this.idIngresso = idIngresso;
        this.horarioUso = horarioUso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
    }

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public LocalDateTime getHorarioUso() {
        return horarioUso;
    }

    public void setHorarioUso(LocalDateTime horarioUso) {
        this.horarioUso = horarioUso;
    }
}
