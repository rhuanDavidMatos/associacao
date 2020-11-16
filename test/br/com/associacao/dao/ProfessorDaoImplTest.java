/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Professor;
import br.com.associacao.entidade.Telefone;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author rhuan.matos
 */
public class ProfessorDaoImplTest {

    private Professor professor;
    private final ProfessorDaoImpl professorDaoImpl;

    public ProfessorDaoImplTest() {
        professorDaoImpl = new ProfessorDaoImpl();

    }

    @Test
    public void testSalvarProfessor() throws Exception {
        System.out.println("salvarProfessor");
        List<Telefone> telefones = new ArrayList<>();
        professor = new Professor(null,
                UtilGerador.gerarNome(),
                UtilGerador.gerarNumero(11),
                UtilGerador.gerarNumero(8));
        for (int i = 0; i < 10; i++) {
            telefones.add(gerarTelefone());
        }
        professor.setTelefones(telefones);
        professorDaoImpl.salvarProfessor(professor);

    }

    private Telefone gerarTelefone() throws Exception {
        Telefone telefone = new Telefone(null,
                UtilGerador.gerarCaracter(10),
                UtilGerador.gerarNumero(10),
                UtilGerador.gerarCaracter(10));

        return telefone;
    }

}


