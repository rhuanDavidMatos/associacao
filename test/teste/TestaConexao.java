/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.associacao.dao.FabricaConexao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.abrirConexao();
        System.out.println(conexao.isClosed());
    }
}
