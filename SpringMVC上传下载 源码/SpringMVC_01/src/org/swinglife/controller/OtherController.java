package org.swinglife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * ����ҳ����ת�÷�
 * @author swinglife
 *
 */
@Controller
public class OtherController {

	/***
	 * ��������ת������ͨ��String�ķ���ֵ����תҳ��
	 * @return
	 */
	@RequestMapping("other")
	public String other(){
		return "other";
	}
	
}
