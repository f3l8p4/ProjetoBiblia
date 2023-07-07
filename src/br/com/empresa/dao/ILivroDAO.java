package br.com.empresa.dao;

import java.util.List;

import br.com.empresa.view.BOException;
import br.com.empresa.vo.LivrosVO;

public interface ILivroDAO {
	
	/**
	 * Lista todos os livros da Bíblia.
	 * @return
	 * @throws BOException
	 */
	public abstract List<LivrosVO> buscarLivros() throws BOException;

}
