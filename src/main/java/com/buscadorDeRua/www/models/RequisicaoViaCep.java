package com.buscadorDeRua.www.models;

import com.buscadorDeRua.www.exeptions.CepInexistenteException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class RequisicaoViaCep {
    private ViaCep endereco;

    public void buscar(String newCep) throws IOException, InterruptedException {

        String cep = newCep.replaceAll("-","");

        String URL = "https://viacep.com.br/ws/"+ cep +"/json/";

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(URL)).build();

        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();

        this.endereco = gson.fromJson(response.body(),ViaCep.class);

        if(Objects.equals(this.endereco.erro(), "true")){
            throw new CepInexistenteException("""
                    -----------------------------------------------------------------------
                    Este cep não existe
                    -----------------------------------------------------------------------
                    """);
        }


    }

    public void exbirInfo(){

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("O endereço é : " + endereco.logradouro() + ", " + endereco.bairro());
        System.out.println("O município é : " + endereco.localidade() + " " + endereco.uf() + "\n");

        System.out.println("Resultado final: " + endereco.logradouro() + " " + endereco.bairro() + ", " + endereco.localidade() + " " + endereco.uf());
        System.out.println("-----------------------------------------------------------------------");
    }

}
