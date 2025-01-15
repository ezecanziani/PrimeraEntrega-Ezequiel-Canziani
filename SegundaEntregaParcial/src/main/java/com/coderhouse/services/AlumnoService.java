package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Alumno;
import com.coderhouse.repositories.AlumnoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoService {
	
	@Autowired
    private AlumnoRepository alumnoRepository;
	
	public List<Alumno> getALLAlumnos(){
		return alumnoRepository.findAll();
	}
	
	public Alumno findById(Long id) {
	   return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
    }
	
   @Transactional
   public Alumno saveAlumno(Alumno alumno) {
	   return alumnoRepository.save(alumno);
	   
   }
}