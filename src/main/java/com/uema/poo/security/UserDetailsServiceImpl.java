package com.uema.poo.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uema.poo.dao.IUsuarioRepository;
import com.uema.poo.model.Usuarios;


//Classe que implementa métodos de UserDetailsService

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	IUsuarioRepository usuarioRepo;

	//Método que carrega o usuário a partir do username recebido no momento que é feito o login
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuario = usuarioRepo.findByUsername(username);
		
		//Define quais os campos a serem preenchidos no spring security
		if(usuario != null) {
			return User
					.builder()
					.username(usuario.getUsername())
					.password(usuario.getPassword())
					.roles(usuario.getRole())
					.build();	
		}else {
			System.out.println("UserDetailsServiceImpl - USUÁRIO NÃO ENCONTRADO!");
			return null;
		}
		
	}

}
