package br.com.empresa.service;

import java.util.List;
import java.util.Map;

import br.com.empresa.bo.BibliaBO;
import br.com.empresa.bo.IBibliaBO;
import br.com.empresa.bo.ILivroBO;
import br.com.empresa.bo.LivroBO;
import br.com.empresa.dao.BibliaDAO;
import br.com.empresa.view.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivrosVO;


public class Service {
	
	public List<BibliaVO> consultarBiblia(LivrosVO livro, Integer capitulo, Integer versiculoInicial,
			Integer versiculoFinal, String texto, Map<String, Object> filters) throws BOException {
		
		IBibliaBO bibliaBO = new BibliaBO();
		
		return bibliaBO.consultarBiblia(livro, capitulo, versiculoInicial, versiculoFinal, texto);
		
	}


	
	public List<LivrosVO> buscarLivros() throws BOException {
		
		ILivroBO livroBO = new LivroBO();
		
		return livroBO.buscarLivros();
		
	}


}