package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInserirMovimentacaoDesafio {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = manager.find(Conta.class, 1);
		List<Movimentacao> movimentacoes = conta.getMovimentacao();
		
		manager.close();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimentacoes: " + movimentacao.getDescricao());
		}
	}
}
