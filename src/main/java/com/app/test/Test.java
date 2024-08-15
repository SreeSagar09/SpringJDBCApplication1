package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Config.xml");
		System.out.println("Number of Beans: "+applicationContext.getBeanDefinitionCount());
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		System.out.println("Beans Names:");
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		
		JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
		
		String sql = "insert into employee (employee_code, employee_name, age, designation) values ('A003', 'Aravind', 28, 'QA Engineer')";
		
		int row = jdbcTemplate.update(sql);
		
		if(row>0) {
			System.out.println("Record inserted successfully.");
		}
	}
}
