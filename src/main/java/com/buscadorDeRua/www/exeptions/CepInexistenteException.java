package com.buscadorDeRua.www.exeptions;

public class CepInexistenteException extends RuntimeException {
  private String mensage;

  public CepInexistenteException(String newException){
    this.mensage = newException;
  }

  @Override
  public String getMessage() {
    return this.mensage;
  }
}
