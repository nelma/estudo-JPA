package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		double inicio = System.currentTimeMillis();
				
		Conta conta= new Conta();
		conta.setTitular("Nelma");
		conta.setBanco("ITAU");
		conta.setAgencia("123");
		conta.setNumero("123456");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		
		manager.close();
				
		double fim = System.currentTimeMillis();
		System.out.println("Execucao em: " + (fim - inicio)/100 + "s");
	}

}
