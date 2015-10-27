import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HelpEdifecs {

	public static void main(String[] args) throws Exception {
		/*
		 * String start = "<Error id='"; String end = "' category='Provider'/>";
		 */
		Set<String> removeDublicate = removeDublicate();
		Iterator<String> iterator = removeDublicate.iterator();
		System.out.println("\nlist\n");
		System.out.println("size = " + removeDublicate.size());
		while(iterator.hasNext()){
			String next = iterator.next();
			//System.out.println("<entry key='" + next + "' value='" + next + "' />");
			//System.out.println(next);
			System.out.println("<entry key='" + next + "' value='' />");
		}
	}
	
	private static Set<String> removeDublicate() throws Exception{
		Set<String> set = new HashSet<String>();
		FileReader fileReader = new FileReader("C:\\Users\\c-DMITMINZ\\Desktop\\temp.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if(!line.trim().isEmpty()){
				//System.out.println(line + " - " + set.add(line));
				set.add(line);
			}
		}
		return set;
	}
	
	private static void replace() throws Exception{
		String start = "<Error id='";
		String end = "' category='Encounter'/>";
		FileReader fileReader = new FileReader("C:\\Users\\c-DMITMINZ\\Desktop\\temp.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(start + line + end);
		}
	}

}