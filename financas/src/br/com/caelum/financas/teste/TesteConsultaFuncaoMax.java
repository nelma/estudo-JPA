package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		Conta conta = manager.find(Conta.class, 2);
		
		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal max = (BigDecimal) query.getSingleResult();
		System.out.println("Max: " + max);
		
		manager.getTransaction().commit();
		manager.close();

	}

}
