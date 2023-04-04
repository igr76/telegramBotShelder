package main.java.com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * эксепш - класс
 * {@link }
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElemNotFound extends RuntimeException {
    public ElemNotFound() {

    }
}
