package org.springboot.sample.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.sample.dao.IScoreDao;
import org.springboot.sample.entity.Score;
import org.springboot.sample.entity.Student;
import org.springboot.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/stu")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private IScoreDao scoreService;
	
	@RequestMapping("/likeName")
	public List<Student> likeName(@RequestParam String name, HttpServletRequest request){
		logger.info(">>>>>>>>>>>>>" + request.getParameter("name2"));
		PageHelper.startPage(1, 1);// 只对第一个查询有效
		List<Student> list = new ArrayList<>();
		list.addAll(studentService.likeName(name));
		list.addAll(studentService.likeNameByDefaultDataSource(name));
		return list;
	}

	@RequestMapping("/list")
	public List<Student> getStus(){
		logger.info("从数据库读取Student集合");
		return studentService.getList();
	}
	
	@RequestMapping("/scoreList")
	public List<Score> getScoreList(){
		logger.info("从数据库读取Score集合");
		// 测试更新数据库
		logger.info("更新的行数：" + scoreService.updateScoreById(88.8f, 2));
		scoreService.delete(23);
		
		return scoreService.getList();
	}
}
