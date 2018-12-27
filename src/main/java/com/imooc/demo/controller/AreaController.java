package com.imooc.demo.controller;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import com.imooc.demo.vo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: AreaController
 * @date 2018/12/23 16:54
 */
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
        return area==null ? Msg.success().add("data",area)
                :Msg.fail().setMsg("查询失败，请重试！");
    }

    @RequestMapping(value = "/insertArea",method = RequestMethod.POST)
    public Msg insertArea(@RequestParam(value = "area",required = true) Area area){
        boolean b = areaService.insertArea(area);
        return b==true?Msg.success().setMsg("插入成功"):Msg.fail().setMsg("插入失败");
    }

    @RequestMapping(value = "/updateArea",method = RequestMethod.POST)
    public Msg updateArea(@RequestParam(value = "area",required = true) Area area){
        boolean b = areaService.updateArea(area);
        return b==true?Msg.success().setMsg("更新成功"):Msg.fail().setMsg("更新失败");
    }

    @RequestMapping(value = "/deleteArea",method = RequestMethod.GET)
    public Msg deleteArea(@RequestParam(value = "areaId",required = true) Integer areaId){
        boolean b = areaService.deleteArea(areaId);
        return b==true?Msg.success().setMsg("删除成功"):Msg.fail().setMsg("删除失败");
    }

}
