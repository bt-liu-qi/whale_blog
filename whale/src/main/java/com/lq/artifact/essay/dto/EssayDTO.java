package com.lq.artifact.essay.dto;

import com.lq.artifact.essay.entity.Essay;
import lombok.Data;

@Data
public class EssayDTO extends Essay {
    /**
     * 文章内容
     */
    private String content;
}
