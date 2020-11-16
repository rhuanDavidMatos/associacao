/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Cliente;
import br.com.associacao.entidade.Endereco;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author silvio.junior
 */
public class EnderecoDaoImpl implements Serializable {

    private PreparedStatement preparando;

    public void salvarCliente(Endereco endereco, int idEstrangeiro,
            Connection conexao) throws SQLException {
        String sql = "INSERT INTO endereco(logradouro, bairro, cidade,"
                + "estado, cep, numero, idCliente)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        salvar(conexao, sql, endereco, idEstrangeiro);

    }

    public void salvarFornecedor(Endereco endereco, int idEstrangeiro, Connection conexao) throws SQLException {
        String sql = "INSERT INTO endereco(logradouro, bairro, cidade,"
                + "estado, cep, numero, idFornecedor)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        salvar(conexao, sql, endereco, idEstrangeiro);
    }

    private void salvar(Connection conexao, String sql, Endereco endereco, int idEstrangeiro) throws SQLException {
        try {
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, endereco.getLogradouro());
            preparando.setString(2, endereco.getBairro());
            preparando.setString(3, endereco.getCidade());
            preparando.setString(4, endereco.getEstado());
            preparando.setString(5, endereco.getCep());
            preparando.setString(6, endereco.getNumero());
            preparando.setInt(7, idEstrangeiro);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar endereço " + e.getMessage());
            conexao.rollback();
        }
    }

    public void alterarEndereco(Endereco endereco, Connection conexao) throws SQLException {
        String sql = "UPDATE endereco SET logradouro = ?, numero = ?, "
                + "bairro = ?, cidade = ?, estado = ?, cep = ? "
                + "WHERE id = ?";
        try {
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, endereco.getLogradouro());
            preparando.setString(2, endereco.getNumero());
            preparando.setString(3, endereco.getBairro());
            preparando.setString(4, endereco.getCidade());
            preparando.setString(5, endereco.getEstado());
            preparando.setString(6, endereco.getCep());
            preparando.setInt(7, endereco.getId());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar endereço " + e.getMessage());
        }
    }

}
