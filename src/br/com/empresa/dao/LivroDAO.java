package br.com.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.empresa.view.BOException;
import br.com.empresa.vo.LivrosVO;

public class LivroDAO implements ILivroDAO {

	@Override
	public List<LivrosVO> buscarLivros() throws BOException {


		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LivrosVO> criteria = cb.createQuery(LivrosVO.class);

		//Cláusula From
		Root<LivrosVO> livroFrom = criteria.from(LivrosVO.class);

		//Cláusula orderBy
		Order livroOrderBy = cb.asc(livroFrom.get("id"));

		//Atribuindo as cláusulas à consulta
		criteria.select(livroFrom);
		criteria.orderBy(livroOrderBy);

		TypedQuery<LivrosVO> query = em.createQuery(criteria);

		List<LivrosVO> listaLivros = query.getResultList();


		em.close();
		
		return listaLivros;
		
	}

}
