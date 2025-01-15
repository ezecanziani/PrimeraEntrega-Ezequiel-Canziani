package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Categoria;
import com.coderhouse.repositories.CategoriaRepository;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	
	@Autowired
    private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> getALLCategorias() {
		return  categoriaRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long Id){
		if(categoriaRepository.existsById(Id)) {
			Categoria categoria = categoriaRepository.findById(Id).get();
			return ResponseEntity.ok(categoria);
		} else { 
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public Categoria createCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}

