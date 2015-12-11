/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin12;

import javax.swing.JOptionPane;

/**
 *
 * @author joterodelrio
 */
public class Garaxe {

    private int numeroCoches;
    private final String[] matriculas = new String[5];

    public void aparcar() {
        if (numeroCoches == 5) {
            JOptionPane.showMessageDialog(null, "O garaxe está cheo");
        } else {
            JOptionPane.showMessageDialog(null, "Plazas dispoñibles");
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] == null) {
                    matriculas[i] = JOptionPane.showInputDialog("Matricula do coche que quere aparacar:");
                    JOptionPane.showMessageDialog(null, "Coche aparcado");
                    numeroCoches++;
                    break;
                }
            }
        }

    }

    public void calcularFactura() {
        float precioHoras = 0;
        float diñeiroPagado;
        boolean cocheNotFound = true;
        do {
            String matricula = JOptionPane.showInputDialog("introduzca la matricula de su coche para retirarlo:");
            for (int i = 0; i < matriculas.length; i++) {
                if (matricula.equals(matriculas[i])) {
                    JOptionPane.showMessageDialog(null, "Coche encontrado");
                    cocheNotFound = false;
                    break;
                }
            }
        } while (cocheNotFound);

        if (!cocheNotFound) {
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Cantas horas estivo aparcado o coche?"));

            if (horas <= 3) {
                precioHoras += 1.5f;
            } else {
                precioHoras += 1.5f + ((horas - 3) * 0.2f);
            }

            JOptionPane.showMessageDialog(null, "O prezo a pagar é " + precioHoras + "€");

            do {
                diñeiroPagado = Float.parseFloat(JOptionPane.showInputDialog("Introduzca diñeiro:"));
            } while (diñeiroPagado < precioHoras);

            JOptionPane.showMessageDialog(null, "A súa volta é " + (diñeiroPagado - precioHoras) + "€");
        }
    }
}
