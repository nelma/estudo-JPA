package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		
		manager.getTransaction().commit();
		
		/**
		 * Nao foi feito update, pq este estava após o commit (fechamento).
		 * tornando assim o estado para Detached
		 */
		conta.setTitular("Caelum ensino e inivação");
		
		
		
		/**
		 * Para fazer o update
		 */
		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();
		
		
		manager.close();
	}

}
