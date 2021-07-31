package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		System.out.println("Informe a data: ");
		Date y1 = sdf1.parse(sc.nextLine());
		Date y2 = sdf2.parse("07/08/2021 19:30:00");

		// Imprimindo a data sem formatação
		System.out.println("----------IMPRIMINDO DATA SEM FORMATO----------");
		System.out.println(y1);
		System.out.println(y2);

		// Imprimindo a data formatada
		System.out.println("----------IMPRIMINDO DATA FORMATADA----------");
		System.out.println(sdf1.format(y1));
		System.out.println(sdf2.format(y2));

		// Pegando data com horário atual
		System.out.println("----------DATA/HORA ATUAL----------");
		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		System.out.println(sdf2.format(x1));
		System.out.println(sdf2.format(x2));

		// Imprimindo datas através de milisegundos.
		System.out.println("----------DATAS EM MILISEGUNDOS----------");
		Date x3 = new Date(0L); // milisegundos L para se referir a Long. Padrão: data inicial é 00:00 de
								// 01/01/19970
		Date x4 = new Date(1000L * 60 * 60 * 5); // Imprimir 05:00 de 01/01/19970. 1s x 60 (1min) * 60 (1h) * 5 (5h).
		System.out.println(sdf2.format(x3));
		System.out.println(sdf2.format(x4));
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(sdf2.format(x3));
		System.out.println(sdf2.format(x4));

		// Imprindo datas recebidas no formato ISO 8601 = yyyy-mm-ddThh:mm:ssZ
		System.out.println("----------DATAS RECEBIDAS NO FORMATO ISO 8601----------");
		Date y3 = Date.from(Instant.parse("2021-08-07T19:29:59Z"));
		System.out.println(y3);
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(sdf3.format(y3));

		// MANIPULANDO DATAS COM CALENDAR

		// Somando uma unidade de tempo
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date d = Date.from(Instant.parse("2021-08-06T15:42:07Z"));

		System.out.println(sdf4.format(d));

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4); // Acrescentando 4 horas na minha data
		d = cal.getTime();

		System.out.println(sdf4.format(d));

		// Obtendo uma unidade de tempo
		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH); //Na classe Calendar o mês começa em 0, por isso somar 1
		
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);

		sc.close();
	}

}
