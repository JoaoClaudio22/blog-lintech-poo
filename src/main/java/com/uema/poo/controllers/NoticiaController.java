package com.uema.poo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uema.poo.dao.INoticiasRepository;
import com.uema.poo.dao.IUsuarioRepository;
import com.uema.poo.model.Noticias;
import com.uema.poo.model.Usuarios;


//Classe de controle de requisições da classe Noticias
@Controller
public class NoticiaController {
	
	@Autowired
	INoticiasRepository noticiaRepo;
	@Autowired
	IUsuarioRepository usuarioRepo;
	
	
	//Faz a requisição get para URI adicionar-noticias passando os dados da noticia/usuario que serão cadastrados
	// e retorna a view da página html
	@GetMapping("/adicionar-noticia")
	public ModelAndView newNoticia(Noticias noticia, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("noticia",noticia);
		mv.setViewName("noticias/add-noticia");
		return mv;
	}
	
	//Requisição POST para adicionar-noticia, salvando a noticia no bando de dados assim que o usuario fizer o cadastro
	@PostMapping("/adicionar-noticia")
	public ModelAndView addNewNoticia(Usuarios autor, Noticias noticia,Model model) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(autor);
		
		
		noticiaRepo.save(noticia);
		mv.setViewName("redirect:/blog-noticias");
		return mv;
	}
	
	
	//Requisição GET para a retornar a página que mostra todas as noticias ja cadastradas no banco
	@GetMapping("/blog-noticias")
	public ModelAndView blog(Noticias noticias) {
		ModelAndView mv = new ModelAndView();
		
		//Cria uma lista do tipo Noticias que recebe todas as noticias cadastradas no banco 
		List<Noticias>noticiasPublicadas = noticiaRepo.findAll();
		mv.addObject("noticia",noticiasPublicadas);
		mv.setViewName("noticias/blog-noticias");
		return mv;
	}
}
