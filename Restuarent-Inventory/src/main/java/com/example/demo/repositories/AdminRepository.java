package com.example.demo.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>
{
	@Query("from Admin where adminEmail=:email")
	public Admin findAdminEmail(String email);
}