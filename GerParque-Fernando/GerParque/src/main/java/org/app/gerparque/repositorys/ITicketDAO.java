package org.app.gerparque.repositorys;

public interface ITicketDAO {
    boolean insertIngresso(String cpf, String frmPg, String nomeAtracao);

    public Integer getIngressoMaisAntigoPorCpfEAtracao(String cpfCliente, String nomeAtracao);
}
