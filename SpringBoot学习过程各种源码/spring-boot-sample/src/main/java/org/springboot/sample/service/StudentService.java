package org.springboot.sample.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springboot.sample.datasource.TargetDataSource;
import org.springboot.sample.entity.Student;
import org.springboot.sample.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Student Service
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月12日
 */
@Service
public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@TargetDataSource(name="ds2")
	public List<Student> likeName(String name){
		return studentMapper.likeName(name);
	}
	
	@Transactional(value = "")
	public List<Student> likeNameByDefaultDataSource(String name){
		Student stu = new Student();
		stu.setAge(20);
		stu.setSumScore("288.5");
		stu.setAvgScore("88.5");
		stu.setName("莉莉");
		studentMapper.add(stu);
		if(name.equals("ERROR"))
			throw new RuntimeException("测试事务异常回滚");
		return studentMapper.likeName(name);
	}
	
	/**
	 * 不指定数据源使用默认数据源
	 *
	 * @return
	 * @author SHANHY
	 * @create  2016年1月24日
	 */
	public List<Student> getList(){
		String sql = "SELECT ID,NAME,SCORE_SUM,SCORE_AVG, AGE   FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("ID"));
				stu.setAge(rs.getInt("AGE"));
				stu.setName(rs.getString("NAME"));
				stu.setSumScore(rs.getString("SCORE_SUM"));
				stu.setAvgScore(rs.getString("SCORE_AVG"));
				return stu;
			}
			
		});
	}
	
	/**
	 * 指定数据源
	 *
	 * @return
	 * @author SHANHY
	 * @create  2016年1月24日
	 */
	@TargetDataSource(name="ds1")
	public List<Student> getListByDs1(){
		String sql = "SELECT ID,NAME,SCORE_SUM,SCORE_AVG, AGE   FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>(){
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("ID"));
				stu.setAge(rs.getInt("AGE"));
				stu.setName(rs.getString("NAME"));
				stu.setSumScore(rs.getString("SCORE_SUM"));
				stu.setAvgScore(rs.getString("SCORE_AVG"));
				return stu;
			}
			
		});
	}
	
	/**
	 * 指定数据源
	 *
	 * @return
	 * @author SHANHY
	 * @create  2016年1月24日
	 */
	@TargetDataSource(name="ds2")
	public List<Student> getListByDs2(){
		String sql = "SELECT ID,NAME,SCORE_SUM,SCORE_AVG, AGE   FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>(){
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("ID"));
				stu.setAge(rs.getInt("AGE"));
				stu.setName(rs.getString("NAME"));
				stu.setSumScore(rs.getString("SCORE_SUM"));
				stu.setAvgScore(rs.getString("SCORE_AVG"));
				return stu;
			}
			
		});
	}
}
