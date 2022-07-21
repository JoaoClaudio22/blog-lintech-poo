package com.uema.poo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uema.poo.dao.IUsuarioRepository;
import com.uema.poo.model.Cargos;
import com.uema.poo.model.Usuarios;

@Controller
public class UsuarioController {

	@Autowired
	IUsuarioRepository usuarioRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//Requisição GET para retornar a página home
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	//Requisição GET para retornar a página login ( usamos a URI /login que é padrão do Spring Secutiry)
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	//Requisição GET para retornar a página login-error,
	//que é chamada quando há algum erro durante o login( usamos a URI /login-error que é padrão do Spring Secutiry)
	@GetMapping("/login-error")
	public String loginError() {
		return "login-error";
	}
	
	@GetMapping("/error")
	public String error() {
		return "login";
	}

	//Requisição GET para retornar à página home, assim que user fizer o logout
	//	( usamos a URI /logout que é padrão do Spring Secutiry)
	@PostMapping("/logout")
	public String logout() {
		return "home";
	}
	
	//Requisição GET que leva a página de cadastro, enviando para o front os os valores dos cargos cadastrados no ENUM
	@GetMapping("/cadastro")
	public ModelAndView cadastro(Usuarios usuario, Model model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("role",Cargos.values());
		mv.addObject("usuario",usuario);
		mv.setViewName("/cadastro");
		return mv;
	}
	

	//Requisição POST para salvar o user a ser salvo no bando de dados
	@PostMapping("/cadastro")
	public ModelAndView fazerCadastro(Usuarios usuario,Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		//É feita a verificação se o username informado já está cadastrado no banco, pois não é possivel
		//cadastrar usuarios com o mesmo username
		if(usuarioRepo.findAll().contains(usuarioRepo.findByUsername(usuario.getUsername()))) {
			model.addAttribute("role",Cargos.values());
			mv.addObject("usuario",usuario);
			mv.setViewName("/cadastro-error");
		}else {
			
			usuarioRepo.save(usuario);	
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
}
