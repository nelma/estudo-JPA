package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class MovimentacaoDAO {
		
	private EntityManager manager;

	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {

		//Utilizando named parameter, por convencao coloca o p
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
				" and m.tipo = :pTipo" +
				" group by m.data";
		
		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		return query.getResultList();
	}

}
