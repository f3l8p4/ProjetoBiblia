package br.com.empresa.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.empresa.vo.LivrosVO;

public class LivrosDAO implements ILivrosDAO{

	@Override
	public List<LivrosVO> listarLivros(BigInteger livro, String escritor, String sigla, Integer qtd_capitulo) {

		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LivrosVO> criteria = cb.createQuery(LivrosVO.class);

		// Cláusula FROM
		Root<LivrosVO> livroFrom = criteria.from(LivrosVO.class);

		// Cláusula WHERE
		Predicate livroWhere = cb.equal(livroFrom.get("livros"), new BigDecimal("1"));

		Order livroOrderBy = cb.asc(livroFrom.get("escritor"));

		// Atribuindo as cláusulas à consulta
		criteria.select(livroFrom);
		criteria.where(livroWhere);
		criteria.orderBy(livroOrderBy);

		TypedQuery<LivrosVO> query = em.createQuery(criteria);

		List<LivrosVO> listaProdutos = query.getResultList();


		em.close();
		return listaProdutos;
	}

}
