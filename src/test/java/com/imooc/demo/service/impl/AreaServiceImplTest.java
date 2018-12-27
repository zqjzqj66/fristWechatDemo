package com.imooc.demo.service.impl;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: AreaServiceImplTest
 * @date 2018/12/23 16:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {

    @Autowired
    private AreaService areaService;

    public static final Logger logger = LoggerFactory.getLogger(AreaServiceImplTest.class);

    @Test
    public void tes(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("word");
        logger.error("error");
    }

    @Test
    @Transactional
    public void selectAllArea() {
        List<Area> areas = areaService.selectAllArea();
        System.out.println(areas);
        System.out.println(areas.size());
        //Assert.assertNotEquals(0,areas.size());
    }

    @Test
    @Transactional
    public void selectAreaById() {
        Area area = areaService.selectAreaById(1);
        Assert.assertEquals("dong",area.getAreaName());
    }

    @Test
    @Transactional
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("dsfa");
        area.setPriority(12);
        boolean b = areaService.insertArea(area);
        Assert.assertEquals(true,b);
    }

    @Test
    //@Transactional
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("adsf");
        area.setAreaId(1);

        boolean b = areaService.updateArea(area);
        Assert.assertEquals(true,b);
    }

    @Test
    @Transactional
    public void deleteArea() {
        boolean b = areaService.deleteArea(1);
        Assert.assertEquals(true,b);
    }
}