package org.app.gerparque.repositorys;

import javafx.collections.ObservableList;
import org.app.gerparque.models.Atracao;

public interface IAtracaoDAO {
    ObservableList<Atracao> carregarAtracoes();
    Integer buscarIdPorNome(String nomeAtracao);

}
