
public class Mine implements Ipoint{
	protected int x;
	protected int y;
	
	public Mine()
	{
		x = 0;
		y = 0;
	}
	public Mine(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	public int getX()
	{
		return x;
	}
}
