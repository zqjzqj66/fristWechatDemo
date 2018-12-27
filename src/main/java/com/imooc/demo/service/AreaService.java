package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: AreaService
 * @date 2018/12/23 16:37
 */
public interface AreaService {
    public List<Area> selectAllArea();

    public Area selectAreaById(Integer areaId);

    public boolean insertArea(Area area);

    public boolean updateArea(Area area);

    public boolean deleteArea(Integer areaId);

}
