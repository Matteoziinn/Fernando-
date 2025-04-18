package org.app.gerparque.repositorys;

public interface IAtracao_clienteDAO {
    void insertAtracaoCliente (Integer idIngresso, Integer idAtracao);
    boolean verificarIngressoPorAtracao(String cpfCliente, String nomeAtracao);
}
