package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: AreaMapper
 * @date 2018/12/22 21:26
 */
@Mapper
public interface AreaMapper {

    public List<Area> selectAllArea();

    public Area selectAreaById(Integer areaId);

    public boolean insertArea(Area area);

    public boolean updateArea(Area area);

    public boolean deleteArea(Integer areaId);

}
