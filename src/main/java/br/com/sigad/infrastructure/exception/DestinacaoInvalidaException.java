package br.com.sigad.infrastructure.exception;

public class DestinacaoInvalidaException extends RuntimeException {

  public DestinacaoInvalidaException(String destinacao) {
    super("A destinacao " + destinacao + "não é válida!");
  }

}
