package br.com.sigad.resources;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

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
