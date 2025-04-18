package org.app.gerparque.services;

import org.app.gerparque.DAO.AtracaoClienteDAO;

public class AtrcaoClienteService {
    AtracaoClienteDAO atrcl = new AtracaoClienteDAO();
    public void createAtracaoCli (Integer idIngresso, Integer idAtracao) {
        if (idAtracao == null || idIngresso == null ){
            throw new RuntimeException("Algo na atracao cliente está nulo");
        }
        atrcl.insertAtracaoCliente(idIngresso,idAtracao);
    }
}
