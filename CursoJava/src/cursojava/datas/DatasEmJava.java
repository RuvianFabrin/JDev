package cursojava.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {
	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		//Prefira usar o calendar
		System.out.println("Calendar em milisegundos: "+calendar.getTimeInMillis());
		System.out.println("Dia do mês: "+calendar.get(calendar.DAY_OF_MONTH));
		System.out.println("Dia da semana: "+(calendar.get(calendar.DAY_OF_WEEK)-1));
		System.out.println("Hora do Dia: "+calendar.get(calendar.HOUR_OF_DAY));
		System.out.println("Minuto: "+calendar.get(calendar.MINUTE));
		System.out.println("Segundos: "+calendar.get(calendar.SECOND));
		System.out.println("Calendar Ano: "+calendar.get(calendar.YEAR));
		
		System.out.println("Calendar Data Atual: "+ calendar.getTime());//basta passar para o simple date format para formatar
		
		/*--------- Date ---------------------------------------------*/
		Date date = new Date();
		System.out.println("\nData em milisegundos: "+date.getTime());
		System.out.println("Dia do mês: "+date.getDate());
		System.out.println("Dia da semana: "+date.getDay());
		System.out.println("Hora: "+date.getHours());
		System.out.println("Minutos: "+date.getMinutes());
		System.out.println("Segundos: "+date.getSeconds());
		System.out.println("Ano mais 1900: "+(date.getYear()+1900)+"\n");
		
		/*--------------------- Simple Date Format -------------------*/
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//Salvar no banco de dados
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");//Mostrar para o Usuario
		System.out.println(simpleDateFormat.format(date));
		
		System.out.println(simpleDateFormat.parse("11/03/1988 17:32:21:457"));//tem que ser de acordo com o ultimo formato instanciado, converte para um objeto data
	}
}
