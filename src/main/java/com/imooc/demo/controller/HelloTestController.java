package com.imooc.demo.controller;

import com.imooc.demo.vo.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.resources.MsgAppletViewer;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: HelloTestController
 * @date 2018/12/22 20:56
 */
@RestController
public class HelloTestController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public Msg hello(){
        return Msg.success().setMsg("Hello Spring");
    }
}
