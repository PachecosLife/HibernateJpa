package javahibernate.javahibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test 	// CRIANDO NOVO USUÁRIO 
	public void testeHibernateUtil(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(45);
		pessoa.setLogin("Exemplo");
		pessoa.setNome("Teste");
		pessoa.setSenha("123");
		pessoa.setEmail("teste@java.com");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	@Test  // BUSCAR USUÁRIO POR ID
	public void testeBuscar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	@Test 	// BUSCAR USUÁRIO POR ID2 
	public void testeBuscar2(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L , UsuarioPessoa.class);
		
		System.out.println(pessoa);
		
	}
	
	
	
	@Test	// ATUALIZANDO USUÁRIO 
	public void testeUpdate(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L , UsuarioPessoa.class);
		
		pessoa.setIdade(99);
		pessoa.setNome("Nome atualizado Hibernate");
		pessoa.setSenha("sd4s5d4s4d");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	
	@Test	// DELETANDO USUÁRIO POR ID 
	public void testeDelete(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L , UsuarioPessoa.class);
		
		daoGeneric.deletarPoId(pessoa);
		
		
	}
	
	 
	@Test 	// BUSCAR POR TODOS OS USUÁRIOS
	public void testeConsultar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("--------------------------------------------------");
		}
		
		
	}
	

}
