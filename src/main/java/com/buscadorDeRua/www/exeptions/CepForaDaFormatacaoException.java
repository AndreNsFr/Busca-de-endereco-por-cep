package com.buscadorDeRua.www.exeptions;

public class CepForaDaFormatacaoException extends RuntimeException{
    private String mensage;

    public void CepForaDaFormatacaoException(String newMensage){
        this.mensage = newMensage;
    }

    @Override
    public String getMessage() {
        return this.mensage;
    }
}
