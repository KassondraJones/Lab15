import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 2;

		System.out.println("Welcome to the Countries Maintenance Application!");

		while (choice != 3) {

			System.out.println();
			choice = Validator.getInt(scan, " 1 - See list of countries\n 2 - Add a country\n 3 - Exit \n", 1, 3);


			if (choice == 1) {
				CountriesTextFile.readFromFile();
			} else if (choice == 2) {
				String country = Validator.getString(scan, "Enter the name country: ");
				System.out.println("This country has been saved!");
				System.out.println();
				CountriesTextFile.writeToFile(country);
			} else {
				System.out.println();
				System.out.println("Thanks for using the Countries Maintenance Application!\nGoodbye!");
			}

		}


	}
}
