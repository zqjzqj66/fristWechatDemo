package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import com.sun.xml.internal.ws.api.server.AbstractServerAsyncTransport;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
 * @ClassName: AreaMapperTest
 * @date 2018/12/22 21:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {

    @Autowired
    private AreaMapper areaMapper;

    @Test
    @Ignore
    public void selectAllArea() {
        List<Area> areas = areaMapper.selectAllArea();
        Assert.assertNotEquals(0,areas.size());

    }

    @Test
    //@Ignore
    public void selectAreaById() {
        Area area = areaMapper.selectAreaById(1);
        Assert.assertNotEquals(null,area);
    }

    @Test
    //@Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("nan");
        area.setPriority(2);
        boolean b = areaMapper.insertArea(area);
        Assert.assertEquals(true,b);
        Assert.assertEquals(2,area.getAreaId().intValue());
    }

    @Test
    //@Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(2);
        area.setAreaName("nan");
        area.setPriority(3);
        boolean b = areaMapper.updateArea(area);

        Assert.assertEquals(true,b);
    }

    @Test
    @Transactional
    public void deleteArea() {
        boolean b = areaMapper.deleteArea(2);
        Assert.assertEquals(true,b);
    }
}