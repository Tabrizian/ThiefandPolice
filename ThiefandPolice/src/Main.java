import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = 0;
		int col = 0;
		try {
			System.out.print("Enter number of rows: ");
			row = scanner.nextInt();
			System.out.print("Enter number of columns: ");
			col = scanner.nextInt();
			System.out.print("Enter number of polices: ");
		} catch (InputMismatchException e) {
			System.out.println("Enter a number please.");
			System.exit(0);
		}
		int numberOfPolices = scanner.nextInt();
		Game game = new Game(row,col,numberOfPolices);
		scanner.close();
		game.run();
	}

}
