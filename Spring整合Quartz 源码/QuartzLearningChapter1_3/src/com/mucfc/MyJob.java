package com.mucfc;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**  
*事件类，基于Spring注解方式
*作者 林炳文（ling20081005@126.com 博客：http://blog.csdn.net/evankaka）  
*时间 2015.4.29
*/
@Component
public class MyJob {
	public MyJob(){
		System.out.println("MyJob创建成功");
	}
	 @Scheduled(cron = "0/1 * *  * * ? ")//每隔1秒隔行一次
	    public void run(){
		 System.out.println("Hello MyJob  "+
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
	    }

}
