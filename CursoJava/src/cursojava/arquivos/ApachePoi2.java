package cursojava.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	public static void main(String[] args) throws IOException {
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\ruvia\\git\\repository\\CursoJava\\src\\cursojava\\arquivos\\arquivo_teste.xls"));
		HSSFWorkbook hssfW = new HSSFWorkbook(entrada);//Prepara a entrada do arquivo excel para ler
		HSSFSheet planilha = hssfW.getSheetAt(0);//Pega a primeira aba do arquivo excel
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> Pessoas = new ArrayList<Pessoa>();
		
		//Enquanto tiver linha no arquivo excel
		while(linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();//Dados da pessoa na linha
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			//Percorre as celulas
			while(celulas.hasNext()) {
				Cell cell = celulas.next();
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;

				
				}
				
				
			}//Fim das celulas linhas
			Pessoas.add(pessoa);
		}
		entrada.close();//Terminou de ler o arquivo excel
		
		for (Pessoa pessoa : Pessoas) {
			System.out.println(pessoa);
		}
	}
}
