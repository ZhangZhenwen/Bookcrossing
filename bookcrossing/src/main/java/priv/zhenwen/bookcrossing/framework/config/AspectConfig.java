package priv.zhenwen.bookcrossing.framework.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import priv.zhenwen.bookcrossing.common.util.SqlUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhenwen
 * @date 2021/6/26
 */
@Aspect
@Component
public class AspectConfig {
    private final Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 定义切入点，切入点为com.example.demo 下的所有函数
     */
    @Pointcut("execution(public * priv.zhenwen.bookcrossing.project.controller.*.*(..))")
    public void webLog(){}

    @Pointcut("execution(public * priv.zhenwen.bookcrossing.project.mapper.*.*(..))")
    public void mysql(){}

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

    @Around("mysql()")
    public Object doAfter(ProceedingJoinPoint point) throws Throwable {
        // 1.从redis中获取主数据库，若获取不到直接退出，否则判断当前数据源是会否为主，若不为主，则切换到主数据源
        // 2.调用目标方法
        Object proceed = point.proceed();
        // 3.获取SQL
        String sql = SqlUtils.getMybatisSql(point, sqlSessionFactory);
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String namespace = method.getDeclaringClass().getName();
        String methodName = method.getName();
        // 4.打印SQL语句
        logger.info("【SQL语句打印 {}.{}】： {}}", namespace, methodName, sql);
        // 5.通知同步程序
        return proceed;
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
