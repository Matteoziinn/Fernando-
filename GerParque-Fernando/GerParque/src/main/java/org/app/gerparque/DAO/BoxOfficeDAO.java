package org.app.gerparque.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.app.gerparque.models.BoxOffice;
import org.app.gerparque.repositorys.IBoxOfficeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoxOfficeDAO extends GerencDAO implements IBoxOfficeDAO {
    @Override
    public ObservableList<BoxOffice> carregarBilheteria() {
        ObservableList<BoxOffice> bilheterias = FXCollections.observableArrayList();

        String sql = "SELECT * FROM bilheteria";

        try (Connection conn = getConnectionGerc();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BoxOffice b = new BoxOffice();
                b.setId(rs.getInt("id"));
                b.setPreco(rs.getBigDecimal("preco"));
                b.setFechamento(rs.getTime("horario_fechamento").toLocalTime());
                b.setOperation(rs.getDate("funcionamento").toLocalDate());
                b.setQuantidade(rs.getInt("quantidade_disponivel"));
                b.setAbertura(rs.getTime("abertura").toLocalTime());

                bilheterias.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bilheterias;
    }

}
