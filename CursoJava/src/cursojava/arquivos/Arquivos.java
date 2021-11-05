package cursojava.arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("t@t.com");
		pessoa1.setNome("Teste");
		pessoa1.setIdade(12);
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("t2@t.com");
		pessoa2.setNome("Teste2");
		pessoa2.setIdade(122);
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("t3@t.com");
		pessoa3.setNome("Teste3");
		pessoa3.setIdade(123);
		
		//Essa lista pode vir de qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\Users\\ruvia\\git\\repository\\CursoJava\\src\\cursojava\\arquivos\\arquivo.csv");
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter escrever = new FileWriter(arquivo);
		for (Pessoa p : pessoas) {
			escrever.write(p.getNome()+";"+p.getEmail()+";"+p.getIdade()+"\n");
		}
		
		escrever.flush();
		escrever.close();
	}

}
