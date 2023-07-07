package br.com.empresa.view;

import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivrosVO;

public class DadosConstantesVO {
	
	public static BibliaVO bibliaVO;
	public static LivrosVO livrosVO;

	public static BibliaVO getBibliaVO() {
		return bibliaVO;
	}

	public static void setBibliaVO(BibliaVO bibliaVO) {
		DadosConstantesVO.bibliaVO = bibliaVO;
	}

	public static LivrosVO getLivrosVO() {
		return livrosVO;
	}



}
