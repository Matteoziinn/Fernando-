package org.app.gerparque.services;

import org.app.gerparque.DAO.TicketDAO;

public class TicketService {
    private TicketDAO tcDao = new TicketDAO();
    public boolean ticketCreate(String cpf, String frmPg, String nomeAtracao) {
        if (cpf == null || cpf.isEmpty() || frmPg == null || frmPg.isEmpty() || nomeAtracao == null
                || nomeAtracao.isEmpty()) {
            throw new RuntimeException("Algum campo nulo");
        }
        tcDao.insertIngresso(cpf,frmPg, nomeAtracao);
        return true;
    }
}
