package march.three.three;

public class Ant {
	
	public void ant(String input) {
		int count = 1;
		String result = "";
		
		
		for(int i=0; i<input.length() -1; i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				count++;
			} else {
				result = result.concat(String.valueOf(count));
				result = result.concat(String.valueOf(input.charAt(i)));
				count = 1;
			}
		}
		
		result = result.concat(String.valueOf(count));
	    result = result.concat(String.valueOf(input.charAt(input.length()-1)));
	    
	    System.out.println(result);
		
	}

}
