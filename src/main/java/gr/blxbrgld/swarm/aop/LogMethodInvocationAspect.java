package gr.blxbrgld.swarm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Cross-cutting Concern Of Method Invocation Logging
 * @author blxbrgld
 */
@Aspect
@Component
@Slf4j
public class LogMethodInvocationAspect {

    @Around("@annotation(gr.blxbrgld.swarm.aop.LogMethodInvocation)")
    public Object logMethodInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        log.debug("Method {}() Invoked.", name);
        //Just call the annotated method (Join point)
        Object proceed = joinPoint.proceed();
        log.debug("Method {}() Exiting.", name);
        return proceed;
    }
}