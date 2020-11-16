/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Endereco;
import br.com.associacao.entidade.Fornecedor;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rhuan.matos
 */
public class FornecedorDaoImpl implements Serializable {

    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO fornecedor(nome, cnpj, inscricaoEstadual, email, telefone) VALUES(?, ?, ?, ?, ?)";

        try {

            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setString(1, fornecedor.getNome());
            preparando.setString(2, fornecedor.getCnpj());
            preparando.setString(3, fornecedor.getInscricaoEstadual());
            preparando.setString(4, fornecedor.getEmail());
            preparando.setString(5, fornecedor.getTelefone());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            fornecedor.setId(resultSet.getInt(1));
            EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();
            for (Endereco endereco : fornecedor.getEnderecos()) {
                enderecoDaoImpl.salvarFornecedor(endereco, fornecedor.getId(), conexao);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar fornecedor " + e.getMessage());

        } finally {

            FabricaConexao.fecharConexao(conexao, preparando, resultSet);

        }

    }

    public void alterar(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?,"
                + " inscricaoEstadual = ?, email = ?, telefone = ? WHERE id = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, fornecedor.getNome());
            preparando.setString(2, fornecedor.getCnpj());
            preparando.setString(3, fornecedor.getInscricaoEstadual());
            preparando.setString(4, fornecedor.getEmail());
            preparando.setString(5, fornecedor.getTelefone());
            preparando.setInt(6, fornecedor.getId());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar cliente " + e.getMessage());
        } finally {
            
            FabricaConexao.fecharConexao(conexao, preparando);

        }

    }
    public void excluir(Integer id)throws SQLException{
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM fornecedor WHERE ID = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
             
        } catch (SQLException e) {
            System.err.println("Erro ao excluir fornecedor " + e.getMessage());
            
        }finally{
            FabricaConexao.fecharConexao(conexao, preparando);
            
        }
 
    }
}
