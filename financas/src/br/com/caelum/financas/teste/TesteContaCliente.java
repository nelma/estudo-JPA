package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {

		Cliente c1 = new Cliente();
		c1.setNome("Nelma");
		c1.setEndereco("Rua Fulano, 123");
		c1.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2); //Aqui ainda Detached
		
		c1.setConta(conta);
				
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(c1);
				
		manager.getTransaction().commit();
		manager.close();
	}

}
