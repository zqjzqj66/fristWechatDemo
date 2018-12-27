package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaMapper;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: AreaServiceImpl
 * @date 2018/12/23 16:38
 */
@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> selectAllArea() {
        return areaMapper.selectAllArea();
    }

    @Override
    public Area selectAreaById(Integer areaId) {
        return areaMapper.selectAreaById(areaId);
    }

    @Override
    public boolean insertArea(Area area) {
        return areaMapper.insertArea(area);
    }

    @Override
    public boolean updateArea(Area area) {
        return areaMapper.updateArea(area);
    }

    @Override
    public boolean deleteArea(Integer areaId) {
        return areaMapper.deleteArea(areaId);
    }
}
