package br.com.empresa.bo;

import java.util.List;

import br.com.empresa.view.BOException;
import br.com.empresa.vo.LivrosVO;

public interface ILivroBO {
	
	/**
	 * Lista todos os livros da Bíblia.
	 * @return
	 * @throws BOException
	 */
	public abstract List<LivrosVO> buscarLivros() throws BOException;

}
