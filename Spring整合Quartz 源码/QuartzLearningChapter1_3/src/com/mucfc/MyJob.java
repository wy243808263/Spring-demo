package com.mucfc;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**  
*�¼��࣬����Springע�ⷽʽ
*���� �ֱ��ģ�ling20081005@126.com ���ͣ�http://blog.csdn.net/evankaka��  
*ʱ�� 2015.4.29
*/
@Component
public class MyJob {
	public MyJob(){
		System.out.println("MyJob�����ɹ�");
	}
	 @Scheduled(cron = "0/1 * *  * * ? ")//ÿ��1�����һ��
	    public void run(){
		 System.out.println("Hello MyJob  "+
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
	    }

}
