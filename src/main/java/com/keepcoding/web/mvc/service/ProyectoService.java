package com.keepcoding.web.mvc.service;

import java.util.List;

import com.keepcoding.web.mvc.entity.Proyecto;

public interface ProyectoService {

		public abstract List<Proyecto> listarProyectos();
		
		public Proyecto obtenerProyecto(Long id);
		
		public Proyecto guardarProyecto(Proyecto proyecto);
		
		public Proyecto borrarProyecto(Long id);
	
}
