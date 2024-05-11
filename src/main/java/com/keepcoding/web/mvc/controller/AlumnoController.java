package com.keepcoding.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.keepcoding.web.mvc.entity.Alumno;
import com.keepcoding.web.mvc.service.AlumnoService;
import com.keepcoding.web.mvc.service.ProyectoService;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private ProyectoService proyectService;
	
	@GetMapping({"/proyecto"})
	public String listarProyectos(Model modelo) {
		modelo.addAttribute("proyecto", proyectService.listarProyectos());
		return "proyecto";
	}
	
	@GetMapping({"/alumno","/"})
	public String listarAlumnos(Model modelo) {
		modelo.addAttribute("alumno", alumnoService.listarAlumno());
		return "alumno";
	}
	 
	@GetMapping("/alumno/new")
	public String mostrarFormulario(Model model) {
		Alumno alumno = new Alumno();
	    model.addAttribute("alumno", alumno);
	    return "crear_alumno"; 
	}

	@PostMapping("alumno/new")
	public String guardarAlumno(@ModelAttribute("alumno")Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/alumno";
	}
	
	@GetMapping("/alumno/edit/{id}")
	public String formularioEditarAlumno(@PathVariable Long id, Model modelo ) {
	    modelo.addAttribute("alumno", alumnoService.obtenerAlumnoPorId(id));
	    return "editar_alumno"; 
	}
	
	@PostMapping("alumno/edit/{id}")
	public String actualizarAlumno(@PathVariable Long id, @ModelAttribute("alumno")Alumno alumno) {
		Alumno alumnoUpdate = alumnoService.obtenerAlumnoPorId(id);
		
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setApellido(alumno.getApellido());
		alumnoUpdate.setTelefono(alumno.getTelefono());
		alumnoUpdate.setEmail(alumno.getEmail());
		alumnoUpdate.setDni(alumno.getDni());
		alumnoUpdate.setFecha_nac(alumno.getFecha_nac());
		
		alumnoService.guardarAlumno(alumnoUpdate);
		
		return "redirect:/alumno";
	}
	
	@GetMapping("/alumno/eliminar/{id}")
	public String eliminarAlumno(@PathVariable Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/alumno";
	}
}
