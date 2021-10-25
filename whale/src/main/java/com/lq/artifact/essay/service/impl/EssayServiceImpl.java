package com.lq.artifact.essay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.essay.dao.EssayDao;
import com.lq.artifact.essay.dto.EssayDTO;
import com.lq.artifact.essay.entity.Essay;
import com.lq.artifact.essay.entity.EssayClass;
import com.lq.artifact.essay.entity.EssayContent;
import com.lq.artifact.essay.service.EssayClassService;
import com.lq.artifact.essay.service.EssayContentService;
import com.lq.artifact.essay.service.EssayService;
import com.lq.artifact.essay.vo.EssayVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Essay)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:24:25
 */
@Service
public class EssayServiceImpl extends ServiceImpl<EssayDao, Essay> implements EssayService {

    @Resource
    private EssayClassService essayClassService;
    @Resource
    private EssayContentService essayContentService;


    public List<EssayVO> listAll() {
        final List<Essay> list = baseMapper.selectList(new QueryWrapper<>());
        List<EssayVO> essayVOList = new ArrayList<>();
        list.stream().forEach(data -> {
            final EssayClass byId = essayClassService.getById(data.getClassId());
            final EssayVO essayVO = new EssayVO();
            BeanUtils.copyProperties(data,essayVO);
            essayVO.setClassName(byId.getName());
            essayVOList.add(essayVO);
        });
        return essayVOList;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateContent(EssayDTO essayDTO) {
        Essay essay = new Essay();
        BeanUtils.copyProperties(essayDTO,essay);
        final int i = baseMapper.updateById(essay);
        EssayContent essayContent = new EssayContent();
        essayContent.setId(essayDTO.getId());
        essayContent.setContent(essayDTO.getContent());
        essayContentService.updateById(essayContent);
        return i;
    }

    @Override
    public int saveEssay(EssayDTO essayDTO) {
        Essay essay = new Essay();
        BeanUtils.copyProperties(essayDTO,essay);
        final int i = baseMapper.updateById(essay);
        EssayContent essayContent = new EssayContent();
        essayContent.setId(essayDTO.getId());
        essayContent.setContent(essayDTO.getContent());
        essayContentService.save(essayContent);
        return i;
    }
}

