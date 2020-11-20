/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Endereco;
import br.com.associacao.entidade.Fornecedor;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author rhuan.matos
 */
public class FornecedorDaoImplTest {

    private Fornecedor fornecedor;
    private final FornecedorDaoImpl fornecedorDaoImpl;

    public FornecedorDaoImplTest() {
        fornecedorDaoImpl = new FornecedorDaoImpl();

    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        List<Endereco> enderecos = new ArrayList<>();
//        Integer id, String nome, String email, String telefone, String cnpj, String inscricaoEstadual
        fornecedor = new Fornecedor(
                null,
                "Nome " + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo(),
                UtilGerador.gerarNumero(10),
                UtilGerador.gerarNumero(6)
        );

        for (int i = 0; i < 2; i++) {
            enderecos.add(gerarEndereco());
        }
        fornecedor.setEnderecos(enderecos);
        fornecedorDaoImpl.salvar(fornecedor);
    }

    private Endereco gerarEndereco() {
        Endereco endereco = new Endereco(
                null,
                "Rua " + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarNumero(3),
                "Bairro " + UtilGerador.gerarCaracter(10),
                "Cidade " + UtilGerador.gerarCaracter(10),
                "Estado " + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarNumero(5) + "-" + UtilGerador.gerarNumero(3)
        );

        return endereco;
    }

    //@Test
    public void testAlterar() throws Exception {

        System.out.println("Alterar");
        fornecedor = new Fornecedor(1,
                UtilGerador.gerarNome(),
                UtilGerador.gerarCaracter(14),
                UtilGerador.gerarCaracter(8),
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo());

        fornecedorDaoImpl.alterar(fornecedor);
    }

    public void testExcluir() throws Exception {
        System.out.println("Excluir");
        fornecedorDaoImpl.excluir(6);
    }
}
