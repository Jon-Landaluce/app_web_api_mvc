package com.keepcoding.web.mvc.service;

import java.util.List;

import com.keepcoding.web.mvc.entity.Alumno;

public interface AlumnoService {

	public List<Alumno> listarAlumno();
	
	public Alumno guardarAlumno(Alumno alumno);
	
	public Alumno obtenerAlumnoPorId(Long id);
	
	public void eliminarAlumno(Long id);
}
