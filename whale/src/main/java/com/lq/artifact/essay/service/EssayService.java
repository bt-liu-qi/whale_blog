package com.lq.artifact.essay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.artifact.essay.entity.Essay;
import com.lq.artifact.essay.vo.EssayVO;

import java.util.List;

/**
 * (Essay)表服务接口
 *
 * @author makejava
 * @since 2021-10-17 14:11:07
 */
public interface EssayService extends IService<Essay> {

    List<EssayVO> listAll();

}

