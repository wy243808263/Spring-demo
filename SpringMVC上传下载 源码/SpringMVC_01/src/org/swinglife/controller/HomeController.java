package org.swinglife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 
 * @author swinglife
 *
 */
@Controller 
public class HomeController {
	
	/***
	 * ��ҳ ������/page/home.jspҳ��
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		//����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊhomeҳ��
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	/***
	 * ��ת���ϴ��ļ���ҳ��
	 * @return
	 */
	@RequestMapping("toFileUpload")
	public String toFileUpload(){
		return "fileUpload";
	}
	
	/***
	 * ��ת���ϴ�����ļ���ҳ��
	 * @return
	 */
	@RequestMapping("toFilesUpload")
	public String toFilesUpload(){
		return "filesUpload";
	}
	
	
}
