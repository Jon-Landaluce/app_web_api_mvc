package com.keepcoding.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.web.mvc.dao.ProyectoRepository;
import com.keepcoding.web.mvc.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService{

	
	@Autowired 
	private ProyectoRepository proyectoRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> listarProyectos() {
		return (List<Proyecto>) proyectoRepo.findAll();
	}

	@Override
	@Transactional
	public Proyecto obtenerProyecto(Long id) {
		return proyectoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return proyectoRepo.save(proyecto);
	}

	@Override
	@Transactional
	public Proyecto borrarProyecto(Long id) {
		Proyecto proyectoBorrado = proyectoRepo.findById(id).orElse(null);
		proyectoRepo.deleteById(id);
		
		return proyectoBorrado;
		
	}

}
