package br.com.sigad.domain.exceptions;

public class DestinacaoInvalidaException extends RuntimeException {

  public DestinacaoInvalidaException(String destinacao) {
    super("A destinacao " + destinacao + "não é válida!");
  }

}
