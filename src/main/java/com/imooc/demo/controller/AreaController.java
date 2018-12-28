package com.imooc.demo.controller;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import com.imooc.demo.vo.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: AreaController
 * @date 2018/12/23 16:54
 */
@Slf4j
@RestController
@RequestMapping(value = "/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/selectAllArea",method = RequestMethod.GET)
    public Msg selectAllArea(){
        List<Area> areas = areaService.selectAllArea();
        return areas!=null ? Msg.success().add("data",areas)
                :Msg.fail().setMsg("查询失败，请重试！");
    }

    @RequestMapping(value = "/selectAreaById",method = RequestMethod.GET)
    public Msg selectAreaById(@RequestParam(value = "areaId",required = true) Integer areaId){
        Area area = areaService.selectAreaById(areaId);
        //原来这里的slf4j是不可以直接的打印对象的 所有使用slf4j的占位符来打印对象
        log.info("{}",area);
        System.out.println(area);
        return  Msg.success().add("data",area);
    }

    @RequestMapping(value = "/insertArea",method = RequestMethod.POST)
    public Msg insertArea(@RequestBody  Area area){
        boolean b = areaService.insertArea(area);
        return b==true?Msg.success().setMsg("插入成功"):Msg.fail().setMsg("插入失败");
    }

    @RequestMapping(value = "/updateArea",method = RequestMethod.POST)
    public Msg updateArea(@RequestBody Area area){
        System.out.println(area);
        boolean b = areaService.updateArea(area);
        System.out.println(b);
        return b==true?Msg.success().setMsg("更新成功"):Msg.fail().setMsg("更新失败");
    }

    @RequestMapping(value = "/deleteArea",method = RequestMethod.GET)
    public Msg deleteArea(@RequestParam(value = "areaId",required = true) Integer areaId){
        boolean b = areaService.deleteArea(areaId);
        return b==true?Msg.success().setMsg("删除成功"):Msg.fail().setMsg("删除失败");
    }

}
