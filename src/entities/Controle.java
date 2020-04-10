package entities;

import java.io.*;
import java.util.ArrayList;

public class Controle {

    public static final String DOC_DISCIPLINAS = "doc/disciplinas/";
    public static final String DOC_GABARITOS = "doc/gabaritos/";


    /** Cria o local aonde o arquivo sera armazenado
     *
     */

    public static void criarDiretorio(){

        ArrayList<File> diretorios = new ArrayList<>();
        diretorios.add(new File(DOC_DISCIPLINAS));
        diretorios.add(new File(DOC_GABARITOS));

        for(File diretorio: diretorios){

            if(!diretorio.exists()){
                diretorio.mkdirs();
            }
        }
    }

    /** Criar arquivo
     *
     * @param arquivo
     * @param a
     */

    public static void criarArquivo(File arquivo, String a){

        try{
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a);
            bw.close();
            fw.close();

        } catch (IOException e){
            e.printStackTrace();

        }
    }

    /** Ler arquivo
     *
     * @param arquivo
     * @return
     */

    public static String lerArquivo(File arquivo){
        String b = "";
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()){

                b += br.readLine()
                        + "\n";

            }
            br.close();
            fr.close();
        } catch (IOException e){
            e.printStackTrace();

        }

        return b;

    }

}
