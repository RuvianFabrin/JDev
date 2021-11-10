package cursojava.arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws IOException {
		File arquivo = new File("C:\\Users\\ruvia\\git\\repository\\CursoJava\\src\\cursojava\\arquivos\\arquivo_teste.xls");
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("t@t.com");
		pessoa1.setNome("Teste");
		pessoa1.setIdade(12);
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("t2@t.com");
		pessoa2.setNome("Teste2");
		pessoa2.setIdade(14);
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("t3@t.com");
		pessoa3.setNome("Teste3");
		pessoa3.setIdade(13);
		
		//Essa lista pode vir de qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		HSSFWorkbook hssworkbook = new HSSFWorkbook();/* Vai ser usado para escrever a planilha */
		HSSFSheet linhasPessoa = hssworkbook.createSheet("Planilha de pessoas");//Cria a planilha
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha ++);//Cria a linha na planilha
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++ );
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++ );
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++ );
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		hssworkbook.write(saida);//Escreve a planilha em arquivo
		saida.flush();
		saida.close();
		//teste
	}
}
