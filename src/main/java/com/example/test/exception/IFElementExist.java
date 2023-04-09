package main.java.com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * эксепш - класс
 * {@link }
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IFElementExist extends RuntimeException {
    public IFElementExist() {

    }
}
