package com.keepcoding.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.web.mvc.dao.AlumnoRepository;
import com.keepcoding.web.mvc.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepo;

	@Override
	public List<Alumno> listarAlumno() {
		return (List<Alumno>) alumnoRepo.findAll();
	}

	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepo.save(alumno);
	}

	@Override
	public Alumno obtenerAlumnoPorId(Long id) {
		return alumnoRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminarAlumno(Long id) {
		alumnoRepo.deleteById(id);
		
	}

	
}
