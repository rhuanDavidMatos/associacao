/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TesteListId {

    public static void main(String[] args) {
        List<Long> listaIds = new ArrayList<>();
        String valor = ",5,7,8";
        Long id;
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) != ',') {
                id = Long.parseLong(Character.toString(valor.charAt(i)));
                listaIds.add(id);
            }
        }
    }
}
