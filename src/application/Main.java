package application;

import entities.Aluno;
import entities.Controle;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Controle.criarDiretorio();


        int op = 0;

        do{
            Menu.menu();
            System.out.print("Opção -> ");
            op = sc.nextInt();
            switch (op) {

                case 1:
                    criarDisciplina();
                    break;
                case 2:
                    criarGabaritoOficial();
                    break;
                case 3:
                    verDisciplinas();
                    break;
                case 4:
                    verGabaritos();
                    break;
                case 5:
                    gerarResultado();
                    break;

                default:
                    System.out.println("Opção Invalida!");
                    break;


            }

        } while (op != 0);

    }

    /** Criar disciplina
     *
     */
    public static void criarDisciplina(){
        Scanner sc = new Scanner(System.in);
        String a = "";
        String nomeDisc;

        System.out.println("Qual o nome da disciplina?");
        nomeDisc = sc.nextLine();
        File fileDisc = new File(Controle.DOC_DISCIPLINAS + nomeDisc + ".txt");

        boolean i = true;

        while (i){
            String alunoGabarito;
            String nomeAluno;

            System.out.println("Qual o gabarito do aluno ? (Apenas 10 caracteres V e F)");
            alunoGabarito = sc.nextLine().toUpperCase();
            System.out.println("Qual o nome do aluno ?");
            nomeAluno = sc.nextLine().toUpperCase();

            if(alunoGabarito.length() == 10){

                a = a + (alunoGabarito + "\t" + nomeAluno + "\n");

                /** "\n" utilizado para o proximo aluno ir para outra linha.
                 */

            } else {

                System.out.println("Erro! \n");
            }

            System.out.println("Quer adicionar mais alunos 'sim' para continuar 'nao' para sair.");

            if(sc.nextLine().equals("nao")){

                i = false;

            }

            Controle.criarArquivo(fileDisc, a);

        }

    }

    /** Criar gabarito
     *
     */
    public static void criarGabaritoOficial() {

        Scanner sc = new Scanner(System.in);
        String gabOfc;
        char[] gabarito;
        System.out.println("Qual o nome do Gabarito Oficial ?");
        gabOfc = sc.nextLine();

        File fileGabarito = new File(Controle.DOC_GABARITOS + gabOfc + ".txt");

        gabarito = gabaritoErr("Qual as respostas validas do gabarito ? (Apenas 10 caracteres V e F)");

        try {
            FileWriter fw = new FileWriter(fileGabarito);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(gabarito);
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** Imprime as diciplinas
     *
     */
    public static void verDisciplinas(){
        File disc = new File(Controle.DOC_DISCIPLINAS);
        for (File fdisc: disc.listFiles()){
            System.out.println("Disciplina: " + fdisc.getName());
            System.out.println(Controle.lerArquivo(fdisc));


        }

    }

    /** Imprime os gabaritos
     *
     */
    public static void verGabaritos(){
        File gab = new File(Controle.DOC_GABARITOS);
        for (File fgab: gab.listFiles()){
            System.out.println("Gabarito: " + fgab.getName());
            System.out.println(Controle.lerArquivo(fgab));

        }


    }



    public static void gerarResultado(){

        }

    public static char[] gabaritoErr(String b) {
        Scanner scanner = new Scanner(System.in);
        char[] gabarito;
        System.out.println(b);
        try {
            gabarito = scanner.nextLine().toUpperCase().toCharArray();
            if (gabarito.length != 10) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro! As respostas devem ter apenas 10 caracteres V e F.");
            gabarito = gabaritoErr(b);
        }
        return gabarito;
    }







}
