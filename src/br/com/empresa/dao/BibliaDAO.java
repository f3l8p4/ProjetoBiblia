package br.com.empresa.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import br.com.empresa.view.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivrosVO;




public class BibliaDAO implements IBibliaDAO {

	@Override
	public List<BibliaVO> consultarBiblia(LivrosVO livro, Integer capitulo, Integer versiculoInicial,
			Integer versiculoFinal, String texto) throws BOException {

		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BibliaVO> criteria = cb.createQuery(BibliaVO.class);

		//Cláusula From
		Root<BibliaVO> livroFrom = criteria.from(BibliaVO.class);

		//Cláusula orderBy
		Order livroOrderBy = cb.asc(livroFrom.get("livro"));
		

		//Atribuindo as cláusulas à consulta
		criteria.select(livroFrom);
		criteria.orderBy(livroOrderBy);

		TypedQuery<BibliaVO> query = em.createQuery(criteria);

		List<BibliaVO> listaBiblia = query.getResultList();


		em.close();
		
		return listaBiblia;
	}
	
	
	/*
	private void consultarBiblia(BigDecimal id, String texto,int capitulo,int vesiculo) {

		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Tuple> criteria = cb.createQuery(Tuple.class);

		// Cláusula FROM
		Root<BibliaVO> bibliaFrom = criteria.from(BibliaVO.class);
		Join<BibliaVO, LivrosVO> livroFrom = bibliaFrom.join("livrosVO");

		Path<BigInteger> bibliaFrom_Id = bibliaFrom.get("id");
		Path<String> bibliaFrom_texto = bibliaFrom.get("texto");
		Path<Integer> bibliaFrom_capitulo= bibliaFrom.get("capitulo");
		Path<Integer> bibliaFrom_vesiculo= bibliaFrom.get("vesiculo");

		criteria.multiselect(bibliaFrom_Id, bibliaFrom_texto, bibliaFrom_capitulo, bibliaFrom_vesiculo,livroFrom);

		// Cláusula WHERE
		//Predicate produtoWhere = cb.equal(produtoFrom.get("client"), new BigDecimal("1"));
		Predicate produtoWhere = cb.equal(livroFrom, new BigDecimal("1"));

		// Cláusula ORDER BY
		Order produtoOrderBy = cb.asc(bibliaFrom.get("texto"));

		criteria.where(produtoWhere);
		criteria.orderBy(produtoOrderBy);

		TypedQuery<Tuple> query = em.createQuery(criteria);

		List<Tuple> tuples = query.getResultList();

		// Monta o retorno da função
		List<BibliaVO> ret = new ArrayList<BibliaVO>();
		if (tuples != null) {

			for (Tuple tuple : tuples) {

				LivrosVO livro = tuple.get(livroFrom);

				BibliaVO bibliaVO = new BibliaVO();
				bibliaVO.setTexto(tuple.get(bibliaFrom_texto));
				bibliaVO.setCapitulo(tuple.get(bibliaFrom_capitulo));
				bibliaVO.setLivrosVO(livro);

				ret.add(bibliaVO);
			}
		}
		em.close();
	}*/

	/*
	@Override
	public Integer consultarBibliaCount(Map<String, Object> filters, BibliaVO biblia, LivrosVO livro) {
		EntityManager em = HibernateUtil.getEntityManager();

		// ************* JPA CRITERIAQUERY - COUNT *************
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = cb.createQuery(Long.class);

		// Cláusula FROM
		Root<BibliaVO> bibliaFrom = criteria.from(BibliaVO.class);
		Join<BibliaVO, LivrosVO> livrosFroms = bibliaFrom.join("livrosVO");

		// Cláusula SELECT
		Selection<Long> bibliaSelect = cb.count(livrosFroms);

		// Cláusula WHERE
		Predicate bibliaWhere = cb.and(cb.equal(livrosFroms.get("id"), livro.getId()));

		if (filters != null) {

			for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

				String filterProperty = it.next();
				String filterValue = filters.get(filterProperty).toString();

				if (filterProperty.equals("id")) {

					bibliaWhere = cb.and(bibliaWhere, cb.equal(livrosFroms.get(filterProperty), filterValue));

				} else if (filterProperty.equals("livro")) {

					bibliaWhere = cb.and(bibliaWhere, cb.like(cb.lower(livrosFroms.get("livro")), "%" + filterValue.toLowerCase() + "%"));

				} else {
					bibliaWhere = cb.and(bibliaWhere, cb.like(cb.lower(livrosFroms.get(filterProperty)), "%" + filterValue.toLowerCase() + "%"));
				}
			}
		}

		// Atribuindo as cláusulas à consulta
		criteria.select(bibliaSelect);
		criteria.where(bibliaWhere);

		TypedQuery<Long> query = em.createQuery(criteria);

		return Integer.valueOf(String.valueOf((Long) query.getSingleResult()));
	}*/


}
