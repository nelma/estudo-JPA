package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
				
		TypedQuery<Double> typedQuery = manager.createNamedQuery("MediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		
		System.out.println("Media do dia 09: " + medias.get(0));
		System.out.println("Media do dia 11: " + medias.get(1));
		System.out.println("Media do dia 12: " + medias.get(2));
		
		manager.getTransaction().commit();
		manager.close();

	}

}
