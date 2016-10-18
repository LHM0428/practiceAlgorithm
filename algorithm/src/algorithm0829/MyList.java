package algorithm0829;

public class MyList {
	public static int curPosition;
	int arr[];
	int numOfData;
	final static int LIST_LENGTH = 100;
	public MyList(){
		arr = new int[LIST_LENGTH];
		numOfData=0;
		curPosition=0;
	}
	
	void listInit(MyList list){
		list = new MyList();
	}
	
	void listInsert(LData data){
		if(numOfData==curPosition){
			System.out.println("저장이 불가능합니다.");
			return;
		}
		arr[numOfData]=data.getSu();
		numOfData++;
	}
	
	boolean listFirst(int a, LData pdata){
		if(numOfData==0){
			return false;
		}
		curPosition=0;
		pdata.setSu(a);
		return true;
	}
	
	boolean listNext(LData pdata){
		if(curPosition>=numOfData-1){
			return false;
		}
		pdata.setSu(arr[++curPosition]);
		return true;
	}
	
	LData listRemove(){
		int rpos = curPosition;
		int num = numOfData;
		LData rdata = new LData(arr[curPosition]);
		
		for(int i=rpos; i<num-1; i++)
			arr[i] = arr[i+1];
		numOfData--;
		curPosition--;
		return rdata;
	}
	
	int listCount(){
		return numOfData;
	}
	
	
	
}
