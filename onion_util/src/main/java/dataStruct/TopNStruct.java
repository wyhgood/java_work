package dataStruct;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TopNStruct<T>
{
	private Class<T> _type;  
	T tArray[];
	Heap<T> heap;
	int iMaxNum = -1;
	int iCurSize = 0;
	Comparator<? super T> _compareFuc;
	@SuppressWarnings("unchecked")
	public TopNStruct(int iNum,Comparator<? super T> compareFunc,Class<T> type)
	{
		iMaxNum		=	iNum;
		_type 		=	type;
		tArray		=	(T[])Array.newInstance(_type, iNum);  		
		_compareFuc	=	compareFunc;
		
		
		
		// 创建最大堆
		
		
	}
	public T Get(int iNum)
	{
		return tArray[iMaxNum-iNum-1];
	}
	public int Size()
	{
		return iMaxNum;
	}
	
	public void  Add(T t)
	{
		//still space left just put it in
		if(iCurSize<iMaxNum)
		{
			tArray[iCurSize]=t;
			iCurSize++;
			
			if(iCurSize==iMaxNum)
			{	
				heap = new Heap<T>(tArray, _compareFuc);
				heap.sort();
			}
		}		
		else {
			//没有剩余空间，挤走最小的
			if(_compareFuc.compare(t,tArray[0])>0)
			{
				tArray[0] = t;
				heap.sort();
			}
		}
	}
	
	public void End()
	{
		if (iMaxNum > iCurSize)
		{

			tArray = Arrays.copyOfRange(tArray, 0, iCurSize);
			iMaxNum = iCurSize;
			
			heap = new Heap<T>(tArray, _compareFuc);
			heap.sort();
			
			
		}
		
		
	}
	
	public static void main(String[] args)
	{
		Comparator<Integer> comp = new Comparator<Integer>()
		{
			public int compare(Integer o1, Integer o2)
			{
				return o1- o2;
			}
		};
		TopNStruct<Integer> topNStruct = new TopNStruct<Integer>(5,comp,Integer.class);
		
		topNStruct.Add(100);
		topNStruct.Add(231);
		topNStruct.Add(1232);
		topNStruct.Add(3);
		topNStruct.Add(2133);
		topNStruct.Add(21332);
		topNStruct.Add(122133);
		topNStruct.Add(0);
		
		topNStruct.End();
		
		for (Integer integer: topNStruct.tArray)
		{
			System.out.println(integer+" ");
		}
	}
}
