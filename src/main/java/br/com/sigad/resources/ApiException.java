package br.com.sigad.resources;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor
public class ApiException extends Exception {
  
  private LocalDateTime moment;
  private HttpStatus status;
  private String reason;

  public ApiException(HttpStatus status, String reason) {
    this.moment = LocalDateTime.now();
    this.status = status;
    this.reason = reason;
  }

}
