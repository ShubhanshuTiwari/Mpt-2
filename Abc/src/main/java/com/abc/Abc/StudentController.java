package com.abc.Abc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bean.Student;
import com.abc.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@RequestMapping(method=RequestMethod.GET,value="student")
	public List<Student> list() {
		// TODO Auto-generated method stub
		return service.list();
	}

	@RequestMapping(method=RequestMethod.POST,value="student")
	public Student create(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return service.create(student);
	}

	@RequestMapping(method=RequestMethod.GET,value="student/{id}")
	public Student findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return service.findById(id);
	}
	@RequestMapping(method=RequestMethod.PUT,value="studentUpdate/{id}")
	public Student update(@PathVariable int id ,@RequestBody Student student) {
		// TODO Auto-generated method stub
		return service.update(id, student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="studentDelete/{id}")
	public Student delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		return service.delete(id);
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="teeri jai ho............")
	@ExceptionHandler({Exception.class})
	public void handleException() {
		
	}
	

}
