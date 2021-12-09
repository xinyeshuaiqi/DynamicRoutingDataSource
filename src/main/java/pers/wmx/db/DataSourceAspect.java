package pers.wmx.db;

import static pers.wmx.db.AppCustomContext.setDataSource;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-08
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect {
    //切面
    @Pointcut("@annotation(pers.wmx.db.AppContextAspect)")
    public void access() {

    }

    @Before("access()")
    public void doBefore() {
        log.info("do before...");

        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //获取 Header 流量标记
        String header = request.getHeader("trace-context");
        if (Strings.isNotEmpty(header) && header.equals("test")) {
            // 请求header携带的trace-context是test,表明是测试流量走影子库
            setDataSource("shadow");
        } else {
            setDataSource("master");
        }
    }
}
