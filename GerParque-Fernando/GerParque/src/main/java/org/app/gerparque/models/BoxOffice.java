package org.app.gerparque.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class BoxOffice {
    private Integer id;
    private LocalDate operation;
    private LocalTime fechamento;
    private LocalTime abertura;
    private int quantidade;
    private BigDecimal preco;

    public BoxOffice() {
    }

    public BoxOffice(LocalDate operation, LocalTime fechamento, int quantidade,
                     BigDecimal preco, LocalTime abertura) {
        this.operation = operation;
        this.fechamento = fechamento;
        this.quantidade = quantidade;
        this.preco = preco;
        this.abertura = abertura;
    }

    public LocalTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalTime abertura) {
        this.abertura = abertura;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOperation() {
        return operation;
    }

    public void setOperation(LocalDate operation) {
        this.operation = operation;
    }

    public LocalTime getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalTime fechamento) {
        this.fechamento = fechamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
