package com.lq.artifact;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.oas.annotations.EnableOpenApi;

@MapperScan("com.lq.artifact.user.dao")
@EnableOpenApi
@SpringBootApplication
public class ArtifactApplication {




    @Bean
    public Snowflake snowflake(){
        Snowflake snowflake = IdUtil.getSnowflake();
        return snowflake;
    }


    public static void main(String[] args) {
        SpringApplication.run(ArtifactApplication.class, args);
    }

}
