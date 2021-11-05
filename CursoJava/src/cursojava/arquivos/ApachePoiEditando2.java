package cursojava.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando2 {

	public static void main(String[] args) throws Exception {
		//Verifique se o arquivo existe antes de rodar esse código
		//O usuario não pode editar o arquivo, o java não consegue ler depois
		File file = new File("C:\\Users\\ruvia\\git\\repository\\CursoJava\\src\\cursojava\\arquivos\\arquivo_teste.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfW = new HSSFWorkbook(entrada);//Prepara a entrada do arquivo xls excel
		HSSFSheet planilha = hssfW.getSheetAt(0);//Pegando a primeira aba
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {//Enquanto tiver linha
			Row linha = linhaIterator.next();//Dados da pessoas na linha
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();//Quantidade de celulas
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			linha.getCell(0).setCellValue(valorCelula+" * Valor gravado na aula");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfW.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");

	}

}
