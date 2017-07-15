package cn.itcast.spring0909.scan;

import org.junit.Test;
import org.springframework.stereotype.Component;

import cn.itcast.spring0909.utils.SpringHelper;


/**
 * 原理
 *   *  启动spring容器，加载配置文件
 *   *  spring容器解析到
 *         <context:component-scan base-package="cn.itcast.spring0909.scan"></context:component-scan>
 *   *  spring容器会在指定的包及子包中查找类上是否有@Component
 *   *  如果@Component注解没有写任何属性
 *        @Component
 *        public class Person{
 *        
 *        }
 *        ==
 *        <bean id="person" class="..Person">
 *      如果@Component("aa")
 *        @Component
 *        public class Person{
 *        
 *        }
 *        ==
 *        <bean id="aa" class="..Person">
 *    *  在纳入spring管理的bean的范围内查找@Resource注解
 *    *  执行@Resource注解的过程
 *  说明：
 *     xml效率比较高，但是书写比较麻烦
 *     注解效率比较低，书写比较简单
 * @author Administrator
 *
 */
public class PersonTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/scan/applicationContext.xml";
	}
	@Test
	public void test(){
		Person person = (Person)context.getBean("perso");
		person.say();
	}
}
