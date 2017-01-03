package fjtrans;

import fjtrans.Char;


public class CharFilter {
	

	public static final char jan2Fan(char jan , Char[] charMapList_Jan2Fan){
		int janId = (int)jan;
		int staIndex = 0;
		int endIndex = charMapList_Jan2Fan.length-1;
		int midIndex = (staIndex+endIndex)/2;
		
		while(staIndex<midIndex && midIndex<endIndex){
			if(charMapList_Jan2Fan[midIndex].jId==janId){
				return charMapList_Jan2Fan[midIndex].fChar;
			}
			if(charMapList_Jan2Fan[midIndex].jId>janId){
				endIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}else{
				staIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}
		}
		if(charMapList_Jan2Fan[staIndex].jId==janId){
			return charMapList_Jan2Fan[staIndex].fChar;
		}
		if(charMapList_Jan2Fan[endIndex].jId==janId){
			return charMapList_Jan2Fan[endIndex].fChar;
		}
		return jan;
	}
	
	
	

	public static final char fan2Jan(char fan , Char[] charMapList_Fan2Jan){
		int fanId = (int)fan;
		int staIndex = 0 ;
		int endIndex = charMapList_Fan2Jan.length-1;
		int midIndex = (staIndex+endIndex)/2;
		
		while(staIndex<midIndex && midIndex<endIndex){
			if(charMapList_Fan2Jan[midIndex].fId==fanId){
				return charMapList_Fan2Jan[midIndex].jChar;
			}
			if(charMapList_Fan2Jan[midIndex].fId>fanId){
				endIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}else{
				staIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}
		}
		if(charMapList_Fan2Jan[staIndex].fId==fanId){
			return charMapList_Fan2Jan[staIndex].jChar;
		}
		if(charMapList_Fan2Jan[endIndex].fId==fanId){
			return charMapList_Fan2Jan[endIndex].jChar;
		}
		return fan;
	}

}
