package org.login;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utilization {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		//File - Class - Object
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenTestng\\src\\test\\resources\\testData\\data.json");
		//ObjectMapper - Class- object
		ObjectMapper obj = new ObjectMapper();
		//JSONReadPOJO json = new JSONReadPOJO();
		Root readValue = obj.readValue(f, Root.class);
		
		System.out.println(readValue.getName());
		System.out.println(readValue.getId());
		
		List<String> courses = readValue.getCourses();
		for(int i=0; i<courses.size(); i++) {
			System.out.println(courses.get(i));
		}
		
		
		System.out.println(readValue.getAddress().getCity());
		System.out.println(readValue.getAddress().getState());
		System.out.println(readValue.getAddress().getCountry());
		
		
		List<Employees> employees = readValue.getEmployees();
		for(int i=0; i<employees.size(); i++) {
			System.out.println(employees.get(i).getName());
			System.out.println(employees.get(i).getId());
		}
		
	}

}
