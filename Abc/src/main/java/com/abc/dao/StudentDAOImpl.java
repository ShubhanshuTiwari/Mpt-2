package com.abc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.abc.bean.Student;
import com.abc.exception.userException;
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext
	EntityManager entity;

	@Override
	@Transactional
	public List<Student> list() {
		// TODO Auto-generated method stub
		TypedQuery<Student> query= entity.createQuery("select stud from Student stud ",Student.class);
		List<Student> list= query.getResultList();
		return list;
		
		
	}

	@Override
	@Transactional
	public Student create(Student student) {
		// TODO Auto-generated method stub
		entity.persist(student);     //insert
		return student;
	}

	@Override
	@Transactional
	public Student findById(int id) throws userException{
		// TODO Auto-generated method stub
			Student student=entity.find(Student.class, id);
			
		return student;
	}

	@Override
	@Transactional
	public Student update(int id, Student student) throws userException{
		// TODO Auto-generated method stub
		entity.merge(student);
		return student;
	}

	@Override
	@Transactional
	public Student delete(int id)throws userException {
		// TODO Auto-generated method stub
		Student student= entity.find(Student.class, id);
		entity.remove(student);
		return student;
		
	}


}
