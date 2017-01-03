package fjtrans;

import java.io.Serializable;

/**
 * ���ļ����ַ��������ַ� ӳ�����
 * @author saiya wyd1011@126.com
 * @lastEdit 2008-10-28
 * 
 */
public final class Char implements Serializable{
	

	public Char(char jChar , char fChar){
		this.jId=(int)jChar;
		this.jChar=jChar;
		this.fId=(int)fChar;
		this.fChar=fChar;
	}
	
	
	public int jId=0;
	

	public char jChar=0;
	
	
	public int fId=0;
	
	
	public char fChar=0;

	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj instanceof Char){
			if(((Char)obj).jId == this.jId && ((Char)obj).fId==this.fId){
				return true;
			}
		}
		return false;
	}
	
	

	public int hashCode() {
		return this.jId + this.fId;
	}


	public String toString() {
		return this.jChar+":"+this.fChar;
	} 
	
	
	
	
	
	

}
