package com.keepcoding.web.mvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.keepcoding.web.mvc.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository <Alumno, Long>{

	
}
