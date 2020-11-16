/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Telefone;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rhuan.matos
 */
class TelefoneDaoImpl implements Serializable {

    private PreparedStatement preparando;

    public void salvarTelefone(Telefone telefone, int idEstrangeiro,
            Connection conexao) throws SQLException {
        String sql = "INSERT INTO telefone(tipo, numero, operadora, idProfessor)"
                + " VALUES(?, ?, ?, ?)";

        salvar(conexao, sql, telefone, idEstrangeiro);

    }

    private void salvar(Connection conexao, String sql, Telefone telefone, int idEstrangeiro) throws SQLException {
        try {
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, telefone.getTipo());
            preparando.setString(2, telefone.getNumero());
            preparando.setString(3, telefone.getOperadora());
            preparando.setInt(4, idEstrangeiro);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar telefone " + e.getMessage());
        }

    }

}
