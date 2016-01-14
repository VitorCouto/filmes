package blog.fpu.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.fpu.example.entity.Comentario;
import blog.fpu.example.entity.Filme;
import blog.fpu.example.repository.ComentarioRepository;
import blog.fpu.example.repository.FilmeRepository;

@Controller
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private FilmeRepository  filmeRepository;
	
	@RequestMapping(value="/comentario")
	public String listarComentario(Filme filme,Model model){
		//model.addAttribute("comentarios", comentarioRepository.findOne(post.getId()));
//		model.addAttribute("comentarios", comentarioRepository.findAll());
		Filme p = filmeRepository.findOne(filme.getId());
		model.addAttribute("filme", p);
		model.addAttribute("comentarios", p.getComentario());

		return "Comentario";
	}
	
	@RequestMapping(value = "/comentario/save")
	public String salvar(Comentario com){
		comentarioRepository.save(com);
		return "redirect:/comentario?id="+com.getFilme().getId();
	}
	
	@RequestMapping(value = "/comentario/del")
	public String deletar(Comentario com) {
		comentarioRepository.delete(com);
		return "redirect:/comentario?id="+com.getFilme().getId();
	}
	
	

}
