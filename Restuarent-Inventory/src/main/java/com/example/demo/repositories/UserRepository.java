package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>
{
	@Query("from User where uemail=:email")
public User findUserByUemail(String email);
}