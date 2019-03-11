package com.abc.dao;

import java.util.List;

import com.abc.bean.Student;

public interface StudentDAO 
{
	public  List<Student> list() ;
	public  Student create(Student student);
	public  Student findById(int id);
	public  Student update(int id, Student student);
	public  Student delete(int id) ;

}
