package PTTema.Tema5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.x500.X500Principal;
import javax.swing.Spring;

import org.omg.CORBA.NO_RESOURCES;
import org.omg.CORBA.Request;

/**
 * Hello world!
 *
 */
public class App {

	private static final String FILENAME = "Problema1.txt";

	private static final String FILENAME1 = "Problema2.txt";

	private static final String FILENAME2 = "Problema3.txt";
	
	private static final String FILENAME3 = "Problema4.txt";
	
	private static final String FILENAME4 = "Problema5.txt";

	public static void main(String[] args) {

		List<MonitoredData> data = ReadFile.readFile();

		Long l = dayDistincts();
		//System.out.println(l);

		BufferedWriter problema1 = null;
		FileWriter fw = null;
		Integer i = (int) (long) l;

		try {
			String content = "Count the distinct days that appear in the monitoring data is ";
			fw = new FileWriter(FILENAME);
			problema1 = new BufferedWriter(fw);

			problema1.write(content);
			problema1.write(String.valueOf(i));

		} catch (IOException e) {
			System.out.println("Exceptie");
		} finally {

			try {

				if (problema1 != null)
					problema1.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

		Map<String, Long> m = distinctAction();
		//System.out.println(m);

		problema1 = null;
		fw = null;

		try {
			String content1 = "";
			for (String s : m.keySet()) {
				content1 += s + " " + m.get(s) + System.lineSeparator();
			}
			fw = new FileWriter(FILENAME1);
			problema1 = new BufferedWriter(fw);

			problema1.write(content1);

		} catch (IOException e) {
			System.out.println("Exceptie");
		} finally {

			try {

				if (problema1 != null)
					problema1.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

		Map<String, Map<String, Long>> m1 = activityCount();
		//System.out.println(m1);

		problema1 = null;
		fw = null;

		try {
			String content2 = "";
			for (String s : m1.keySet())
				for (String s1 : m1.get(s).keySet()) {
					content2 += s + " " + s1 + " " + m1.get(s).get(s1) + System.lineSeparator();
				}
			fw = new FileWriter(FILENAME2);
			problema1 = new BufferedWriter(fw);

			problema1.write(content2);

		} catch (IOException e) {
			System.out.println("Exceptie");
		} finally {

			try {

				if (problema1 != null)
					problema1.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

		Map<String, Long> m2 = TotalDuration();
		//System.out.println(m2);
		
		problema1 = null;
		fw = null;

		try {
			String content1 = "";
			for (String s : m2.keySet()) {
				content1 += s + " " + m2.get(s) + System.lineSeparator();
			}
			fw = new FileWriter(FILENAME3);
			problema1 = new BufferedWriter(fw);

			problema1.write(content1);

		} catch (IOException e) {
			System.out.println("Exceptie");
		} finally {

			try {

				if (problema1 != null)
					problema1.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
		
		
		List<String> lista =  distinctActivity();
		//System.out.println(lista);
		
		problema1 = null;
		fw = null;

		try {
			String content1 = "";
			for (String s : lista) {
				content1 += s + System.lineSeparator();
			}
			fw = new FileWriter(FILENAME4);
			problema1 = new BufferedWriter(fw);

			problema1.write(content1);

		} catch (IOException e) {
			System.out.println("Exceptie");
		} finally {

			try {

				if (problema1 != null)
					problema1.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}




	}

	// Count the distinct days that appear in the monitoring data
	public static long dayDistincts() {

		List<MonitoredData> data = ReadFile.readFile();

		return data.stream().map(x -> x.getDateStart()).distinct().count();

	}

	// Determine a map of type <String, Integer> that maps to each distinct
	// action type
	// the number of occurrences in the log. Write the resulting map into a text
	// file

	public static Map<String, Long> distinctAction() {

		List<MonitoredData> data = ReadFile.readFile();
		Map<String, Long> m = data.stream().collect(Collectors.groupingBy(x -> x.getActivity(), Collectors.counting()));

		return m;

	}

	/**
	 * Generates a data structure of type Map<Integer, Map<String, Integer>>
	 * that contains the activity count for each day of the log (task number 2
	 * applied for each day of the log)and writes the result in a text file
	 **/

	public static Map<String, Map<String, Long>> activityCount() {

		List<MonitoredData> data = ReadFile.readFile();

		Map<String, Map<String, Long>> m1 = data.stream()
				.collect(Collectors.groupingBy(x -> x.getStartTime().split(" ")[0],
						Collectors.groupingBy(x -> x.getActivity(), Collectors.counting())));

		return m1;

	}

	/*
	 * Determine a data structure of the form Map<String, DateTime> that maps
	 * for each activity the total duration computed over the monitoring period.
	 * Filter the activities with total duration larger than 10 hours. Write the
	 * result in a text file.
	 */

	public static Map<String, Long> TotalDuration() {

		List<MonitoredData> data = ReadFile.readFile();
		Map <String, Long> mp = data.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.summingLong((p)-> {
					return Math.abs(p.getTimeSecondEnd().getTime() - p.getTimeSecondStart().getTime())/(1000);
					})));
		Map <String, Long> mp1 = new HashMap<String, Long>();
		mp1.put("",(long) 10 * 1000);
		boolean bol = false;
		if(mp.keySet().equals(mp1.keySet()) == true){
			bol = true;
		}
		

		Map <String, Long> mp2 = new HashMap<String, Long>();
		if(bol == true){
			mp2 = data.stream()
					.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.summingLong((p)-> {
						return Math.abs(p.getTimeSecondEnd().getTime() - p.getTimeSecondStart().getTime())/(1000);
						})));
			
		}
		return mp2;
		
	} 

	/*
	 * Filter the activities that have 90% of the monitoring samples with
	 * duration less than 5 minutes, collect the results in a List<String>
	 * containing only the distinct activity names and write the result in a
	 * text file.
	 */
	
	public static List<String> distinctActivity(){
		
		List<MonitoredData> data = ReadFile.readFile();
		Map<Object, Map<Object, Long>> mp = data.stream()
				.collect(Collectors.groupingBy(p-> p.getActivity(), Collectors.groupingBy(p->{
					return Math.abs(p.getTimeSecondEnd().getTime() - p.getTimeSecondEnd().getTime())/(1000);
				}, Collectors.counting())));
		
		List<String>lista = new ArrayList<>();
		
		mp.forEach((cheie, valoare)->{
			Set<Object> minim = valoare.keySet();
			
			long total = (long) 0;
			long sub = (long) 0;
			
			for(Object result : minim){
				Long numar = valoare.get(result);
				
				if(numar < 5){
					total = total+numar;
					sub = sub + numar;
				}
				else
					total = total +numar;
			}
			if(sub >=total *90/100)
				
				lista.add((String) cheie);
		});
		return lista;
		
		
	}
	
	

}
