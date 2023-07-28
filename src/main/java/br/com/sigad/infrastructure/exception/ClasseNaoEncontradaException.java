package br.com.sigad.infrastructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClasseNaoEncontradaException extends RuntimeException {

  private HttpStatus status = HttpStatus.NOT_FOUND;

  public ClasseNaoEncontradaException(String message) {
    super(message);
  }

}
