package br.com.empresa.bo;

import java.util.List;

import br.com.empresa.dao.ILivroDAO;
import br.com.empresa.dao.LivroDAO;
import br.com.empresa.view.BOException;
import br.com.empresa.vo.LivrosVO;

public class LivroBO implements ILivroBO {

	@Override
	public List<LivrosVO> buscarLivros() throws BOException {
		
		ILivroDAO livroDAO = new LivroDAO();
		
		return livroDAO.buscarLivros();
	}

}
