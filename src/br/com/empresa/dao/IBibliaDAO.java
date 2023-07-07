package br.com.empresa.dao;

import java.util.List;
import java.util.Map;

import br.com.empresa.view.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivrosVO;

public interface IBibliaDAO {
	
	public abstract List<BibliaVO> consultarBiblia(LivrosVO livro, Integer capitulo, Integer versiculoInicial, Integer versiculoFinal, String texto)
			throws BOException;
	
}
