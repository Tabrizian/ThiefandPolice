import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		int row = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int col = scanner.nextInt();
		System.out.print("Enter number of polices: ");
		int numberOfPolices = scanner.nextInt();
		Game game = new Game(row,col,numberOfPolices);
		game.run();
	}

}
