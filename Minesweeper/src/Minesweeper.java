import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Minesweeper {

	public static void main(String[] args) 
	{
		Scanner input = null;
		try
		{
			input = new Scanner(new File("test.txt"));
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File Was Not Found");
		}
		FieldFactory.MineSweeperExe(input);
	}

}
