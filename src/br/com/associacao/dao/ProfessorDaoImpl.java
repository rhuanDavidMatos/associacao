/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Professor;
import br.com.associacao.entidade.Telefone;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rhuan.matos
 */
public class ProfessorDaoImpl implements Serializable {

    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvarProfessor(Professor professor) throws SQLException {
        String sql = "INSERT INTO professor(nome, cpf, numeroCracha)"
                + " VALUES(?, ?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparando.setString(1, professor.getNome());
            preparando.setString(2, professor.getCpf());
            preparando.setString(3, professor.getNumeroCracha());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            professor.setId(resultSet.getInt(1));
            TelefoneDaoImpl telefoneDaoImpl = new TelefoneDaoImpl();
            for (Telefone telefone : professor.getTelefones()) {
                telefoneDaoImpl.salvarTelefone(telefone, professor.getId(), conexao);

            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar um professor " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }

    }

}
