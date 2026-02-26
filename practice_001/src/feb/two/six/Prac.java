package feb.two.six;

public class Prac {
	public static void main(String args[]) {
		
		
		System.out.println("1번문제");
		for(int i=1; i<=4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("■ ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("2번문제");
		
		for(int i=1; i<=4; i++) {
			for(int j=4; j>=i; j--) {
				System.out.print("■ ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("3번문제");
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<i; j++) {
				System.out.print("□ ");
			}
			for(int j=4; j>=i; j--) {
				System.out.print("■ ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("4번문제");
		
		for(int i=1; i<=4; i++) {
			for(int j=4; j>i; j--) {
				System.out.print("□ ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("■ ");
			}
			System.out.println();
		}

		
		System.out.println();
		System.out.println("별문제");
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3-i; j++) {
				System.out.print(" ");
			}
			for(int j=2; j<=i*2; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(" ");
			}
			for(int j=2; j<= 6 - i*2; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}

}
