package com.curiousby.repository;

import java.util.List;
 

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.curiousby.entity.User;

/**
 * @author baoyou E-mail:curiousby@163.com
 * @version 2016年1月28日 下午1:13:09
 *
 * desc: ...
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	@Query("FROM User u")
	List<User> getAll();
}
