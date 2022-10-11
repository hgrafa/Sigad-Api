package br.com.sigad.services.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ClasseNaoEncontradaException extends RuntimeException {

  private HttpStatus status = HttpStatus.NOT_FOUND;

  public ClasseNaoEncontradaException(String message) {
    super(message);
  }

}
