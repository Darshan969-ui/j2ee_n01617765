package com.n01617765.activity_6.Repository;

import com.n01617765.activity_6.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface userRepository extends JpaRepository<User,Integer>{
	
	public List<User> findByUserName(String userName);

}
