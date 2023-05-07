package cursojava.executavel;

import javax.swing.*;

public class ArrayVetor {
    /*Usado para executar código*/
    public static void main(String[] args) {
        /*Array pode ser de todos os tipos de dados e objetos*/

        /*Um array sempre deve ter a quantidade de posições definidas*/
        //double[] notas = new double[5];

        /*notas[0] = 9.8;
        notas[1] = 8.7;
        notas[2] = 9.7;
        notas[3] = 9.9;*/

        //As posições sempre é inteiro
        //System.out.println("Nota 1: "+notas[0]);
        //System.out.println("Nota 2: "+notas[2]);
        //System.out.println("Nota 3: "+notas[3]);
        //System.out.println("Nota 4: "+notas[4]);

        //Melhorando o código
        /*for (int pos = 0; pos < 5; pos++){
            System.out.println("Nota "+pos+" é ="+notas[pos]);
        }*/

        //Pegando o tamanho do array (notas.length)
        /*for (int pos = 0; pos < notas.length; pos++){
            System.out.println("Nota "+pos+" é ="+notas[pos]);
        }*/

        //===================================================
        //Fazendo o tamanho do array de forma dinamica

        String posicoes = JOptionPane.showInputDialog("Quantas posições o array deve ter?"); //Aula 3:15

        double[] notas = new double[Integer.parseInt(posicoes)];

        for (int pos =0; pos < notas.length; pos++){
            String valor = JOptionPane.showInputDialog("Qual o valor da posição = " + pos);
            notas[pos] = Double.valueOf(valor);
        }

        for (int pos = 0; pos < notas.length; pos++){
            System.out.println("Nota "+pos+" é = "+notas[pos]);
        }
    }
}
