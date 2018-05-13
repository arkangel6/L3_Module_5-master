package data_structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
		
		assertFalse(doBracketsMatch("{}{}}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> s = new Stack<Character>();
		
		char[] brackets = b.toCharArray();
		
		for(char c : brackets) {
			s.push(c);
		}
		/*int counter = 0;
		int counter2 = 0;
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i) == '{') {
				
				counter += 1;
				
			}
			if(s.get(i) == '}') {
				counter2 += 1;
			}
		}
		
		if(counter2 == counter ) {
			

			
			return true;
		}*/
		
		if(brackets.length % 2 == 1) {
			return false;
		}
	
		for(int i = 0; i < s.size(); i++) {
			
			for(int j = i; j < s.size()-1; j++) {
				if(s.get(i) == '{' && s.get(j) == '}') {
					s.remove(i);
					s.remove(j);
				}
				
				
				
			}
			
		}
		
		System.out.println(Arrays.toString(s.toArray()));
		
		return true;
		//return false;
	}

}