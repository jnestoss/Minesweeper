
public class Blank implements Ipoint{
	protected int x;
	protected int y;
	protected int adjMine;
	
	public Blank()
	{
		x = 0;
		y = 0;
		adjMine = 0;
	}
	public Blank(int x,int y)
	{
		this.x = x;
		this.y = y;
		adjMine = 0;
	}
	public int getY()
	{
		return y;
	}
	public int getX()
	{
		return x;
	}
	public void incrementAjd()
	{
		adjMine++;
	}
}
