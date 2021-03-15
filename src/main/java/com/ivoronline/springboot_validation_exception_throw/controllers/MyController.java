package com.ivoronline.springboot_validation_exception_throw.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@Validated
public class MyController {

  //==================================================================
  // HELLO
  //==================================================================
  @ResponseBody
  @RequestMapping("/Hello")
  public void hello() {
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There was some Exception");
  }

  //==================================================================
  // HANDLE EXCEPTIONS
  //==================================================================
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ResponseStatusException.class)
  public String handleExceptions(ResponseStatusException exception) {

    //GET EXCEPTION DETAILS
    String     message      = exception.getMessage();   //400 BAD_REQUEST "There was some Exception"
    HttpStatus status       = exception.getStatus();    //400 BAD_REQUEST
    String     reason       = exception.getReason();    //There was some Exception
    Integer    statusValue  = status.value();           //400
    String     statusPhrase = status.getReasonPhrase(); //Bad Request

    //RETURN MESSAGE
    return message;

  }

}
