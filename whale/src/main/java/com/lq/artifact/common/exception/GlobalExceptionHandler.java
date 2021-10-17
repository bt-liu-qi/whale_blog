package com.lq.artifact.common.exception;

import cn.hutool.core.lang.Snowflake;
import com.lq.artifact.common.response.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private Snowflake snowflake;

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
        logger.error("发生业务异常！原因是：{}",e);
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResultBody httpClientErrorException(HttpServletRequest request, HttpServletResponse response, HttpClientErrorException ex){
        logger.error("请求Id:{}  服务器URL匹配异常:{}",getRequestId(request),ex);
        return ResultBody.error(CommonEnum.NOT_FOUND);
    }

    /**
     * http请求方式异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultBody HttpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException ex){
        logger.error("请求Id:{}  请求方式异常:{}",getRequestId(request),ex);
        return ResultBody.error(CommonEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED);
    }



    private String getRequestId(HttpServletRequest request){
        final String parameter = request.getParameter("");
        return snowflake.nextIdStr();
    }
    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }




}
