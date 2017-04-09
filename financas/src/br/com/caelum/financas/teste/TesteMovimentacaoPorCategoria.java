package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(2);
		
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria " +
				"and m.valor > 100 " +
				" and m.tipo = :pTipoMovimentacao";
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList();
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
		manager.getTransaction().commit();
		manager.close();
		

	}

}
