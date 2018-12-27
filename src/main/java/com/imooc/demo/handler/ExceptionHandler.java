package com.imooc.demo.handler;

import com.imooc.demo.vo.Msg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: ExceptionHandler
 * @date 2018/12/23 18:18
 */
@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Msg handler(HttpServletRequest req ,Exception e){
        return Msg.fail().setMsg(e.getMessage());
    }

}
