package com.lq.artifact.essay.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.lq.artifact.essay.entity.EssayClass;

/**
 * 文章分类(EssayClass)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-17 15:02:48
 */
public interface EssayClassDao extends BaseMapper<EssayClass> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EssayClass> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EssayClass> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EssayClass> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EssayClass> entities);

}

