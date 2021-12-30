package io.com.ppmtool.execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomProjectEntityExecptionHandling extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdExecption(ProjectIOExecption ex, WebRequest request){
        ProjectExecptionResponse projectExecptionResponse= new ProjectExecptionResponse(ex.getMessage());
                return new  ResponseEntity(projectExecptionResponse, HttpStatus.BAD_REQUEST);
    }

}
