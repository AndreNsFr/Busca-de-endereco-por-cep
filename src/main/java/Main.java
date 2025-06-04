import com.buscadorDeRua.www.exeptions.CepInexistenteException;
import com.buscadorDeRua.www.models.Cep;
import com.buscadorDeRua.www.models.RequisicaoViaCep;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                =======================================================
                |                                                     |
                |          BEM VINDO AO BUSCADOR DE ENDEREÇOS!        |
                |                                                     |
                =======================================================
                
                """);


        while (true){
            System.out.println("Digite o seu cep para a pesquisa: ");
            String cepString = scanner.nextLine();

            Cep cep = new Cep(cepString);
            boolean oCepEValido = cep.validacao();
            if(oCepEValido){

                RequisicaoViaCep requisicao = new RequisicaoViaCep();
                try{
                    requisicao.buscar(cep.getCep());
                    requisicao.exbirInfo();
                } catch (CepInexistenteException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Deseja fazer mais uma pesquisa?(sim|nao)");
                String escolha = scanner.nextLine();

                if(escolha.equalsIgnoreCase("nao")){
                    break;
                }
            }else{
                System.out.println("Por favor, digite um cep válido.");
            }

        }

        System.out.println("Obrigado por utilizar o programa!");
        System.out.println("Feito por : André do Nascimento");
    }
}
