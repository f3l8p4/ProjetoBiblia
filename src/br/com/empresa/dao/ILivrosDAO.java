package br.com.empresa.dao;
import java.util.List;
import java.math.*;
import br.com.empresa.vo.LivrosVO;

public interface ILivrosDAO {
	public abstract List<LivrosVO> listarLivros(BigInteger livro,String escritor,String sigla,Integer qtd_capitulo);
}
