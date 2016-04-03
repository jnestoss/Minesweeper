
public class Field {
	protected Ipoint field[][];
	protected int mineCount;
	
	public Field(int numC,int numR)
	{
		field = new Ipoint[numC][numR];
		mineCount = 0;
	}
	public int getCount()
	{
		return mineCount;
	}
}
