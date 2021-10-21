package cursojava.datas;

import java.util.Date;

public class DatasEmJava {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Data em milisegundos: "+date.getTime());
		System.out.println("Dia do mês: "+date.getDate());
		System.out.println("Dia da semana: "+date.getDay());
		System.out.println("Hora: "+date.getHours());
		System.out.println("Minutos: "+date.getMinutes());
		System.out.println("Segundos: "+date.getSeconds());
		System.out.println("Ano mais 1900: "+(date.getYear()+1900));
	}
}
