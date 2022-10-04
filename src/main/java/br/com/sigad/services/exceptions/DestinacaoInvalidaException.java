package br.com.sigad.services.exceptions;

public class DestinacaoInvalidaException extends RuntimeException {

  public DestinacaoInvalidaException(String destinacao) {
    super("A destinacao " + destinacao + "não é válida!");
  }

}
