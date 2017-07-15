package cn.itcast.spring0909.aop.annotation;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.itcast.salary.aop.xml.Person;

/**
 *	@Aspect
 *    说明该类是一个切面类 
 *  ==
 *  <aop:config>
 *   	<aop:pointcut expression="execution(* cn.itcast.spring0909.aop.annotation.PersonDaoImpl.*(..))" 
 *           id="aa()"/>
 *  </aop:config>
 * @author Administrator
 *
 */
@Component("transaction")
@Aspect
public class Transaction {
	@Pointcut("execution(* cn.itcast.spring0909.aop.annotation.PersonDaoImpl.*(..))")
	private void aa(){}//方法签名  返回值必须是void 方法的修饰符最好是private
	
	@Before("aa()")
	public void beginTransaction(){
		System.out.println("begin transaction");
	}
}
