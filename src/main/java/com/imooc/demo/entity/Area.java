package com.imooc.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.security.PrivateKey;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Area
 * @date 2018/12/22 21:18
 */
@Data
public class Area {

    private Integer areaId;

    private String areaName;

    private Integer priority;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDateTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDateTime;

}
