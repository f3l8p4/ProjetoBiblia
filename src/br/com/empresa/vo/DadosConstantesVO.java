package br.com.empresa.vo;
import br.com.empresa.vo.LivrosVO;
import br.com.empresa.vo.BibliaVO;

public class DadosConstantesVO {
	public static BibliaVO bibliaVO;
	public static LivrosVO livrosVO;
	public static BibliaVO getBibliaVO() {
		return bibliaVO;
	}
	public static LivrosVO getLivrosVO() {
		return livrosVO;
	}
}
