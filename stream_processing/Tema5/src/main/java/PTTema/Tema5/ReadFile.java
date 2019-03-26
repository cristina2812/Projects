package PTTema.Tema5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

	public static List<MonitoredData> readFile(){
		
	
	
	List<MonitoredData> list=new ArrayList<>();
	String fileName = "C:\\Users\\Cristina\\Desktop\\PTTema\\pt2018_30224_adam_cristina_assignment_5\\Tema5\\src\\main\\java\\PTTema\\Tema5\\Activity.txt";

	//read file into stream, try-with-resources
	try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

		stream.forEach((x ->{
			
			String[] s=x.split("		");
			MonitoredData date = new MonitoredData();
			date.setStartTime(s[0]);
			date.setEndTime(s[1]);
			date.setActivity(s[2]);
			list.add(date);
		}));

	} catch (IOException e) {
		e.printStackTrace();
	}
	return list;
	}
}
