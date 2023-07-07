package br.com.empresa.bo;

import java.util.List;

import br.com.empresa.dao.BibliaDAO;
import br.com.empresa.dao.IBibliaDAO;
import br.com.empresa.view.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivrosVO;

public class BibliaBO implements IBibliaBO {

	@Override
	public List<BibliaVO> consultarBiblia(LivrosVO livro, Integer capitulo, Integer versiculoInicial,
			Integer versiculoFinal, String texto) throws BOException {
		
		IBibliaDAO bibliaDAO = new BibliaDAO();
		
		return bibliaDAO.consultarBiblia(livro, capitulo, versiculoInicial, versiculoFinal, texto);
	}

}
