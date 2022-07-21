package com.uema.poo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.uema.poo.dao.INoticiasRepository;
import com.uema.poo.dao.IUsuarioRepository;
import com.uema.poo.model.Noticias;
import com.uema.poo.model.Usuarios;


//Classe de Serviço que faz a injeção automática de dados no banco de dados.
@Service
public class DbInit implements CommandLineRunner {
	
	@Autowired
	IUsuarioRepository usuarioRepo;
	
	@Autowired
	INoticiasRepository noticiaRepo;
	@Override
	public void run(String... args) throws Exception {
		Usuarios user1 = new Usuarios(1L,"João","joaoc","joao@gmail.com","123","EDITOR",null);
		usuarioRepo.save(user1);
		
		Noticias noticia1 = new Noticias(1L, "UiPath cria conselho para debater o futuro da automação", 
				"A UiPath, provedora de software de automação empresarial, anunciou a criação de um Conselho de Automação, composto por CIOs pioneiros e inovadores de todas as indústrias. ",
				user1);
		Noticias noticia2 = new Noticias(2L, "Soluções tecnológicas auxiliam as altas demandas de hospitais",
				"Os avanços da Medicina andam lado a lado com o desenvolvimento tecnológico e científico da sociedade e, mais recentemente, a tecnologia tem feito diferença não apenas em tratamentos, mas também na gestão hospitalar.\r\n"
				+ "\r\n"
				+ "As soluções tecnológicas já apresentavam um aprimoramento significativo nas últimas décadas, mas a pandemia da Covid-19 e a demanda por isolamento social intensificaram as aplicações na área da saúde.",
				user1);
		Noticias noticia3 = new Noticias(3L, "ViewSonic apresenta telas comerciais 4K Ultra HD com tela colaborativa sem fio",
				"ViewSonic, fornecedora global de soluções visuais, apresenta a série CDE12 de seus displays comerciais de grande formato. Disponível em quatro tamanhos (43, 55, 65 e 75 polegadas), os monitores sem fio CDE12 vêm com resolução nativa 4K Ultra HD (3840×2160) e software integrado para streaming e compartilhamento de tela.",user1);
		
		noticiaRepo.save(noticia1);
		noticiaRepo.save(noticia2);
		noticiaRepo.save(noticia3);
		
	}
	
}
