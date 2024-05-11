package com.keepcoding.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.web.mvc.service.ProyectoService;
import com.keepcoding.web.mvc.entity.Proyecto;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://localhost:9001")
@Controller
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectService;
	
	@GetMapping("/proyectos")
	public List<Proyecto> index() {
	return proyectService.listarProyectos();
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto show(@PathVariable long id) {
		return proyectService.obtenerProyecto(id);
	}
	
	@PostMapping("/proyectos")
	public Proyecto crear(@RequestBody Proyecto proyecto) {
		return proyectService.guardarProyecto(proyecto);
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizar (@PathVariable long id, @RequestBody Proyecto proyecto) {
		Proyecto actualizarProyecto = proyectService.obtenerProyecto(id);
		
		actualizarProyecto.setNombre(proyecto.getNombre());
		actualizarProyecto.setDescripcion(proyecto.getDescripcion());
		actualizarProyecto.setFecha_inicio(proyecto.getFecha_inicio());
		actualizarProyecto.setFecha_fin(proyecto.getFecha_fin());
		actualizarProyecto.setActivo(proyecto.getActivo());
		
		return proyectService.guardarProyecto(actualizarProyecto);
		
	}
	
	@DeleteMapping("/proyectos/{id}")
	public Proyecto delete (@PathVariable long id) {
		return proyectService.borrarProyecto(id);
	}
}


//package com.keepcoding.web.mvc.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.keepcoding.web.mvc.service.ProyectoService;
//import com.keepcoding.web.mvc.entity.Proyecto;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "hhtps://localhost:9001")
//@Controller
//public class ProyectoController {
//	
//	@Autowired
//	private ProyectoService proyectService;
//	
//	@GetMapping("/proyectos")
//	public List<Proyecto> index() {
//		return proyectService.listarProyectos();
//	}
//	
//	@GetMapping("/proyectos/{id}")
//	public Proyecto show(@PathVariable long id) {
//		return proyectService.obtenerProyecto(id);
//	}
//	
//	@PostMapping("/proyectos")
//	public Proyecto crear(@RequestBody Proyecto proyecto) {
//		return proyectService.guardarProyecto(proyecto);
//	}
//	
//	@PutMapping("/proyectos/{id}")
//	public Proyecto actualizar (@PathVariable long id, @RequestBody Proyecto proyecto) {
//		Proyecto actualizarProyecto = proyectService.obtenerProyecto(id);
//		
//		actualizarProyecto.setNombre(proyecto.getNombre());
//		actualizarProyecto.setDescripcion(proyecto.getDescripcion());
//		actualizarProyecto.setFecha_inicio(proyecto.getFecha_inicio());
//		actualizarProyecto.setFecha_fin(proyecto.getFecha_fin());
//		actualizarProyecto.setActivo(proyecto.getActivo());
//		
//		return proyectService.guardarProyecto(actualizarProyecto);
//		
//	}
//	
//	@DeleteMapping("/proyectos/{id}")
//	public Proyecto delete (@PathVariable long id) {
//		return proyectService.borrarProyecto(id);
//	}
//}



