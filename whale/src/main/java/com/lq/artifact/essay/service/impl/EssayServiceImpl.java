package com.lq.artifact.essay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.essay.dao.EssayDao;
import com.lq.artifact.essay.entity.Essay;
import com.lq.artifact.essay.entity.EssayClass;
import com.lq.artifact.essay.service.EssayClassService;
import com.lq.artifact.essay.service.EssayService;
import com.lq.artifact.essay.vo.EssayVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Essay)表服务实现类
 *
 * @author makejava
 * @since 2021-10-17 14:11:07
 */
@Service
public class EssayServiceImpl extends ServiceImpl<EssayDao, Essay> implements EssayService {

    @Resource
    private EssayClassService essayClassService;


    public List<EssayVO> listAll() {
        final List<Essay> list = baseMapper.selectList(new QueryWrapper<>());
        List<EssayVO> essayVOList = new ArrayList<>();
        list.stream().forEach(data -> {
            final EssayClass classDo = essayClassService.getById(data.getClassId());
            final EssayVO essayVO = new EssayVO();
            BeanUtils.copyProperties(data,essayVO);
            essayVO.setClassName(classDo.getName());
            essayVOList.add(essayVO);
        });
        return essayVOList;
    }
}

