package io.com.ppmtool.execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIOExecption extends RuntimeException {
    public ProjectIOExecption(String message){
        super(message);
    }

}
