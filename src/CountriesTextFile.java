import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CountriesTextFile {

	public CountriesTextFile(String countryName) {
		super();
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String countryName;

	public static void readFromFile() {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There were no countries!");
		}

	}
	
	public static String fileAsString () {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
		
			BufferedReader reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			while(line!=null) {
				System.out.println(line);
				line += reader.readLine() + ",";
				
			}
			reader.close();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR";
		}
		
	}
	
	public static void writeToFile(String name) {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			out.println( name);
			out.close();
		} catch (FileNotFoundException e) {
			createFile("countries.txt");
			try {
				PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
				out.println( name);
				out.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void createFile(String fileString) {
		Path filePath = Paths.get(fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was cerated successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with file creation ");
				e.printStackTrace();
			}
		}
	}
}