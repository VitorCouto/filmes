package blog.fpu.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.fpu.example.entity.Filme;
import blog.fpu.example.repository.FilmeRepository;

@Controller
public class FilmeController {

	@Autowired
	FilmeRepository filmeRepository;
	
	@RequestMapping(value="/")
	public String lista(Filme filme, Model model){
		model.addAttribute("filmes", filmeRepository.findAll());		
		if(filme.getId() != null){
			model.addAttribute("filme", filmeRepository.findOne(filme.getId()));
		} else {
			model.addAttribute("filme", new Filme());
		}
		return "filmesLista";
	}
	
	@RequestMapping(value="/save")
	public String salvar (Filme filme){
		filmeRepository.save(filme);
		return "redirect:/";
	}
	
	@RequestMapping(value="/del")
	public String deletar (Filme filme){
		filmeRepository.delete(filme);
		return "redirect:/";		
	}
	
}
