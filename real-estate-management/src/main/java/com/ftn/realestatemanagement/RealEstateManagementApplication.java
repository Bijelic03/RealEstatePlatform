package com.ftn.realestatemanagement;

import com.ftn.realestatemanagement.model.Admin;
import com.ftn.realestatemanagement.repository.AdminRepository;
import com.ftn.realestatemanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateManagementApplication  {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminService adminService;
	public static void  main(String[] args) {
		SpringApplication.run(RealEstateManagementApplication.class, args);



	}



}
