/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.associacao.dao.ClienteDaoImpl;
import br.com.associacao.entidade.Cliente;
import br.com.utilitario.UtilGerador;
import java.sql.SQLException;

/**
 *
 * @author silvio.junior
 */
public class TestaConexao {
    
    private static Cliente cliente;
    private static ClienteDaoImpl clienteDaoImpl;

    public TestaConexao() {
        clienteDaoImpl = new ClienteDaoImpl();
    }

    public static void main(String[] args) throws SQLException {
  
    }
   
    
}
