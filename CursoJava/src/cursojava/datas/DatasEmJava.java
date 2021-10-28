package cursojava.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {
	public static void main(String[] args) throws ParseException, InterruptedException {
		
		//After e before
		SimpleDateFormat simpleDateFormatAB = new SimpleDateFormat("dd/MM/yyyy");
		Date dataVencimentoBoleto =simpleDateFormatAB.parse("26/10/2021");
		
		Date dataAtualHoje = simpleDateFormatAB.parse("26/10/2021");
		
		//Passou da data Atual
		if(dataVencimentoBoleto.after(dataAtualHoje)) {
			System.out.println("After: Boleto dentro do prazo!!!\n\n");
		}else {
			System.out.println("After: Boleto Vencido!!!\n\n");
		}
		
		//É anterior a data Atual
		if(dataVencimentoBoleto.before(dataAtualHoje)) {
			System.out.println("Before: Boleto Vencido!!!\n\n");
		}else {
			System.out.println("Before: Boleto dentro do prazo!!!\n\n");
			
		}
		//-----------------------------------------------
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
		
		
		//--------------------------------------------------------------------------------
		System.out.println("\n\n.................Calculo de dia, ano, mês com Calendar ...............");
		Calendar cal = Calendar.getInstance();//Pega a data Atual
		//Simular que a data vem do banco de dados		
		cal.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2021"));
		cal.add(Calendar.DAY_OF_MONTH, 5);//data de hoje mais 5 dias, negativo diminui
		System.out.println("Somando o dia: "+new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime()));
		
		cal.add(Calendar.MONTH, 1);//data de hoje mais 1 mês
		System.out.println("Somando o mês: "+new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime()));
		
		cal.add(Calendar.YEAR, 1);//data de hoje mais 1 ano
		System.out.println("Somando o ano: "+new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime()));
		
		//--------------------------------------------------------------------------------
		System.out.println("\n\n................. ChronoUnit Quantos dias existe em um periodo de data ...............");
		
		long dias = ChronoUnit.DAYS.between(LocalDate.parse("2021-02-01"), LocalDate.now());//total de dias de uma data até hoje
		
		System.out.println("Possui "+dias+" dias entre a fiaxa de data");
		
		//--------------------------------------------------------------------------------
		System.out.println("\n\n................. Nova Api de data do Java8 pra frente ...............");
		
		LocalDate dataAtual = LocalDate.now();
		System.out.println("Data Atual: "+dataAtual);
		
		LocalTime horaAtual = LocalTime.now();
		System.out.println("Hora Atual: "+horaAtual);
		
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		System.out.println("Data e hora Atual: "+dataHoraAtual);
		
		System.out.println("\n\n................. Formatando com a nova Api de data do Java8 pra frente ...............");
		System.out.println("Data e hora Atual: "+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		System.out.println("\n\n................. dia, mês, Ano com a nova Api de data do Java8 pra frente ...............");
		LocalDate localDate = LocalDate.now();
		System.out.println("Data Atual: "+localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Dia da Semana: "+localDate.getDayOfWeek().ordinal());
		System.out.println("Dia do mês: "+localDate.getDayOfMonth());
		System.out.println("Dia do ano: "+localDate.getDayOfYear());
		System.out.println("Mês: "+localDate.getMonth());
		System.out.println("Ano: "+localDate.getYear());
		
		System.out.println("\n\n................. Tempo de processo com Instant (Trabalhar com precisão de tempo) ...............");
		Instant inicio = Instant.now();
		Thread.sleep(1);/* Pode ser um processo com um tempo que não conhecemos */
		
		Instant ifinal = Instant.now();
		Duration duracao = Duration.between(inicio, ifinal);
		//dá pra fazer horas, minutos, dias
		System.out.println("Duração em nano segundos: "+duracao.toNanos());
		System.out.println("Duração em milisegundos: "+duracao.toMillis());
		
		System.out.println("\n\n................. Faixa de tempo com o objeto period ...............");
		LocalDate dataAntiga = LocalDate.parse("1988-03-21");
		LocalDate dataNova = LocalDate.of(2021, 10, 27);
		
		System.out.println("Antiga maior que a nova: "+dataAntiga.isAfter(dataNova));
		System.out.println("Antiga menor que a nova: "+dataAntiga.isBefore(dataNova));
		System.out.println("Antiga igual a nova: "+dataAntiga.isEqual(dataNova));
		
		Period periodo = Period.between(dataAntiga, dataNova);
		System.out.println("Dias: "+periodo.getDays());
		System.out.println("Mês: "+periodo.getMonths());
		System.out.println("Ano: "+periodo.getYears());
		System.out.println("Total Mês: "+periodo.toTotalMonths());
		System.out.println("O periodo é de "+periodo.getYears()+" ano(s), "+periodo.getMonths()+" mes(es) e "+periodo.getDays()+" dia(s).");
		
		System.out.println("\n\n................. Adicionando  e retirando dia, mês, ano localDate ...............");
		LocalDate dataBase = LocalDate.parse("2019-10-05");
		System.out.println("Data: 2019-10-05 ");
		System.out.println("+5 Dias: "+(dataBase = dataBase.plusDays(5)));
		System.out.println("+5 Semanas: "+(dataBase = dataBase.plusWeeks(5)));
		System.out.println("+5 Meses: "+(dataBase = dataBase.plusMonths(5)));
		System.out.println("+5 Anos: "+(dataBase = dataBase.plusYears(5)));
		System.out.println("-1 Ano: "+(dataBase = dataBase.minusYears(1)));
		System.out.println("-1 Mês: "+(dataBase = dataBase.minusMonths(1)));
	}
}
