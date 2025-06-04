package com.buscadorDeRua.www.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cep {
    private final String cep;

    public Cep(String newCep){
        this.cep = newCep.trim();
    }

    public boolean validacao(){

//        Pattern regexComTraco = Pattern.compile("/^\\d{2}\\d{3}[-]\\d{3}$/gm");
//        Matcher matcherComTraco = regexComTraco.matcher(this.cep);
//        boolean padraoComTraco = matcherComTraco.find();
//
//        Pattern regexSemTraco = Pattern.compile("/^\\d{2}\\d{3}\\d{3}$/gm");
//        Matcher matcherSemTraco = regexSemTraco.matcher(this.cep);
//        boolean padraoSemTraco = matcherSemTraco.find();

        if(this.cep.matches("\\d{5}-\\d{3}") || this.cep.matches("\\d{5}\\d{3}")){
            return true;
        }
        return false;
    }

    public String getCep(){
        return this.cep;
    }
}
