package com.sparrow.common.aop.check;

import com.sparrow.common.annotation.check.CheckData;
import com.sparrow.common.annotation.check.NotNull;
import com.sparrow.common.constant.SystemExceptionConstant;
import com.sparrow.common.exception.SystemException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统一校验数据格式
 * 111111111111111111111111▄11
 * 111111111▐█11111111111▄▀0▌1
 * 11111111▐▀0█11111111▄▀000▐
 * 1111111▐▄▀00▀▀▀▀▄▄▄▀00000▐
 * 11111▄▄▀01000000000█00▄█0▐
 * 111▄▀000111000111000▀██▀0▌
 * 11▐000▄▄00001110000000▀▄00
 * 11▌11▌█▀00000▄▀█▄0000000█0▐
 * 1▐11100000000▌██▀00111000▀▄
 * 1▌10▄██▄0000000001111110000
 * ▀0▀▐▄█▄█▌▄1▀001111111111000
 *
 * @author 赵宏宇
 * https://segmentfault.com/q/1010000008424451/a-1020000008429785
 *
 * https://blog.csdn.net/laoxilaoxi_/article/details/97178494
 *
 * https://blog.csdn.net/Zereao/article/details/83546973
 */
@Aspect
@Component
public class CheckDataAop {

    @Pointcut("execution(* com.sparrow..*.*(@com.sparrow.common.annotation.check.CheckData (*), ..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void begin(JoinPoint joinPoint) throws SystemException, IllegalAccessException {
        Object[] params = joinPoint.getArgs();
        //没有参数直接跳过
        if(params.length == 0){
            return;
        }
        //获取方法，此处可将signature强转为MethodSignature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Object param = params[i];
            Annotation[] paramAnn = annotations[i];
            //没有注解，直接下一个参数
            if(paramAnn.length == 0){
                continue;
            }
            for (Annotation annotation : paramAnn) {
                if(annotation.annotationType().equals(CheckData.class)){
                    if(param == null){
                        throw new SystemException(SystemExceptionConstant.V400,"提交信息有误","[" + method.getName() + "]方法参数为空");
                    }
                    List<Field> fields = getAllField(param);
                    for (Field field : fields) {
                        boolean annotationPresent = field.isAnnotationPresent(NotNull.class);
                        if(annotationPresent) {
                            field.setAccessible(true);
                            NotNull notNull = field.getAnnotation(NotNull.class);
                            if (StringUtils.isEmpty(field.get(param))){
                                throw new SystemException(SystemExceptionConstant.V400,notNull.message(),"[" + field.getName()  + "]字段为空");
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<Field> getAllField(Object model){
        Class clazz = model.getClass();
        List<Field> fields = new ArrayList<>();
        while (clazz!=null){
            fields.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    @After("pointCut()")
    public void close(JoinPoint joinPoint) throws Exception{
    }


}
