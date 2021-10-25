package com.lq.artifact.essay.vo;

import com.lq.artifact.essay.entity.Essay;
import lombok.Data;

@Data
public class EssayVO extends Essay {

    /**
     * 分类名称
     */
    private String className;

    /**
     * 文章内容
     */
    private String content;
}
