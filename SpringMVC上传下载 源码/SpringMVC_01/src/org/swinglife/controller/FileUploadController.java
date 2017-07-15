package org.swinglife.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/***
 * �ļ��ϴ�������
 * @author swinglife
 *
 */
@Controller
public class FileUploadController {

	//ͨ��Spring��autowiredע���ȡspringĬ�����õ�request
	@Autowired
	private HttpServletRequest request;

	@RequestMapping("filesUpload")
	public String filesUpload(@RequestParam("files") MultipartFile[] files) {
		//�ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0
		if(files!=null&&files.length>0){
			//ѭ����ȡfile�����е��ļ�
			for(int i = 0;i<files.length;i++){
				MultipartFile file = files[i];
				//�����ļ�
				saveFile(file);
			}
		}
		// �ض���
		return "redirect:/list.html";
	}

	/***
	 * �����ļ�
	 * @param file
	 * @return
	 */
	private boolean saveFile(MultipartFile file) {
		// �ж��ļ��Ƿ�Ϊ��
		if (!file.isEmpty()) {
			try {
				// �ļ�����·��
				String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
						+ file.getOriginalFilename();
				// ת���ļ�
				file.transferTo(new File(filePath));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/***
	 * �ϴ��ļ� ��@RequestParamע����ָ�����ϵ�fileΪMultipartFile
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		// �ж��ļ��Ƿ�Ϊ��
		if (!file.isEmpty()) {
			try {
				// �ļ�����·��
				String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
						+ file.getOriginalFilename();
				// ת���ļ�
				file.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �ض���
		return "redirect:/list.html";
	}

	/***
	 * ��ȡ�ϴ��ļ��е������ļ�������
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list() {
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		ModelAndView mav = new ModelAndView("list");
		File uploadDest = new File(filePath);
		String[] fileNames = uploadDest.list();
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i]);
		}
		return mav;
	}
}
