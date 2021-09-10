package priv.zhenwen.bookcrossing.framework.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zhenwen
 * @date 2021/6/26
 */
@Aspect
@Component
public class AspectConfig {
    private final Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    /**
     * 定义切入点，切入点为com.example.demo 下的所有函数
     */
    @Pointcut("execution(public * priv.zhenwen.bookcrossing.project.controller.*.*(..))")
    public void webLog(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint 切点
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("=============我来源与Before========================");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
