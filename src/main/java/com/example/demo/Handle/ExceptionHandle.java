package com.example.demo.Handle;


import com.example.demo.Exception.ClientException;
import com.example.demo.Exception.LoginException;
import com.example.demo.Result.Result;
import com.example.demo.Util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {


    private final static Logger logger = LoggerFactory.getLogger(Exception.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Exceptionhand(Exception e){

        if(e instanceof LoginException){
            LoginException loginException =(LoginException) e;
            return Util.failure(loginException.getCode(), loginException.getMessage());
        }
        else {
            logger.info("系统异常{}",e);
            return Util.failure(-1,"未知错误");
        }


    }


}
