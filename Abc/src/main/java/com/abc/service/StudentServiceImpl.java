package com.abc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bean.Student;
import com.abc.dao.StudentDAO;

@Service()
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO daoref;
	
	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return daoref.list();
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		return daoref.create(student);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return daoref.findById(id);
	}

	@Override
	public Student update(int id, Student student) {
		// TODO Auto-generated method stub
		return daoref.update(id, student);
	}

	@Override
	public Student delete(int id) {
		// TODO Auto-generated method stub
		return daoref.delete(id);
	}


	

}
