import java.util.Scanner;

public class FieldFactory {
	private static int fieldCounter;
	public static void MineSweeperExe(Scanner input)
	{
		Field field = null;
		fieldCounter++;
		if(input.hasNextLine())
		{
			do
			{
				field = FieldBuilder(input);
				printField(field);
				fieldCounter++;
			}while(input.hasNextLine());
		}
	}
	private static Field FieldBuilder(Scanner in)
	{
		int x,y;
		x = in.nextInt()+2;
		y = in.nextInt()+2;
		in.nextLine();
		Field ret = new Field(x,y);
		if(x != 0)
		{
			for(int m = 0;m < x;m++)
			{
				String temp = null;
				if(m != 0 && m != (x-1))
				{
					temp = in.nextLine();
				}
				for(int n = 0; n< y; n++)
				{
					if(m == 0 || n == 0)
					{
						ret.field[m][n] = new EdgeBuffer(m,n);
					}
					else if(m == (x-1) || n == (y-1))
					{
						ret.field[m][n] = new EdgeBuffer(m,n);
					}
					else
					{
						if(temp.charAt(n-1) == '*')
						{
							ret.field[m][n] = new Mine(m,n);
						}
						else if(temp.charAt(n-1) == '.')
						{
							ret.field[m][n] = new Blank(m,n);
						}
					}
				}
			}
			for(int m = 0; m < ret.field.length; m++)
			{
				for(int n = 0;n < ret.field[m].length; n++)
				{
					if(ret.field[m][n] instanceof Mine)
					{
						mineIncrementer(ret,(Mine)ret.field[m][n]);
					}
				}
			}
		}
		return ret;
	}
	private static void mineIncrementer(Field field,Mine mine)
	{
		Blank temp;
		if(field.field[mine.getX()-1][mine.getY()-1] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()-1][mine.getY()-1];
			temp.adjMine++;
		}
		if(field.field[mine.getX()][mine.getY()-1] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()][mine.getY()-1];
			temp.adjMine++;
		}
		if(field.field[mine.getX()+1][mine.getY()-1] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()+1][mine.getY()-1];
			temp.adjMine++;
		}
		if(field.field[mine.getX()-1][mine.getY()] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()-1][mine.getY()];
			temp.adjMine++;
		}
		if(field.field[mine.getX()+1][mine.getY()] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()+1][mine.getY()];
			temp.adjMine++;
		}
		if(field.field[mine.getX()-1][mine.getY()+1] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()-1][mine.getY()+1];
			temp.adjMine++;
		}
		if(field.field[mine.getX()][mine.getY()+1] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()][mine.getY()+1];
			temp.adjMine++;
		}
		if(field.field[mine.getX()+1][mine.getY()+1] instanceof Blank)
		{
			temp = (Blank) field.field[mine.getX()+1][mine.getY()+1];
			temp.adjMine++;
		}
	}
	private static void printField(Field toPrint)
	{
		Blank temp;
		if(toPrint.field.length != 2)
		{
			System.out.println("Field #" + fieldCounter + ":");
		}
		for(int x = 0; x < toPrint.field.length;x++)
		{
			for(int y = 0; y < toPrint.field[x].length;y++)
			{
				if(toPrint.field[x][y] instanceof EdgeBuffer)
				{
					//no print out
				}
				else if(toPrint.field[x][y] instanceof Mine)
				{
					System.out.print("*");
				}
				else if(toPrint.field[x][y] instanceof Blank)
				{
					temp = (Blank) toPrint.field[x][y];
					System.out.print(temp.adjMine);
				}
			}
			if(x != 0)
			{
				System.out.println();
			}
		}
	}
}
