package dataStruct;

public class Pair<T>
{

	public T p1;
	public T p2;
	
	public Pair(){}
	public Pair(T t1,T t2)
	{
		p1 = t1;
		p2 = t2;
	}


	public T getP1()
	{
		return p1;
	}


	public void setP1(T p1)
	{
		this.p1 = p1;
	}


	public T getP2()
	{
		return p2;
	}


	public void setP2(T p2)
	{
		this.p2 = p2;
	}
	
	
	

}
