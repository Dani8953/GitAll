package it.finish.demo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import it.finish.demo1.components.ReportExec;

@SpringBootApplication
public class Demo1Application implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	  ReportExec reportExec; 
	

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args); 
		
		
	}
	
	
	@Bean
	List<String> studentList(){
	  List<String> students = new ArrayList<>();
	  students.add("Daniele");
	  students.add("Luca");
	  
	  return students;
	}
	
	@Override
	 public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		 reportExec.execute();
	  }

}
