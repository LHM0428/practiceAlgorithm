package algorithm0829;

public class HanoiTower {
	
	public static void HanoiTowerMove(int num, String from, String by, String to){
		
		if(num==1){
			System.out.printf("���� 1�� %s���� %s�� �̵� \n", from ,to);
		}else{
			HanoiTowerMove(num-1, from, to, by);
			System.out.printf("���� %d��(��) %s���� %s�� �̵� \n", num, from, to);
			HanoiTowerMove(num-1, by, from,to);
		}
	}

	public static void main(String[] args){
		HanoiTowerMove(3, "A","B","C");
	}
}
