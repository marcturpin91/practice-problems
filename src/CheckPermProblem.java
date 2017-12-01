import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Marc on 2017-11-14.
 */
public class CheckPermProblem {
    // Given two strings, check if one is a permutation of the other
    public static void main(String[] args){

    }

    public static boolean isPerm(String a, String b){
        if(a == null || b == null) return false;
        if(a.length() != b.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            int count = map.containsKey(a.charAt(i)) ? map.get(a.charAt(i)) : 0;
            map.put(a.charAt(i), ++count);
        }

        for(int j = 0; j < b.length(); j++){
            int count = map.containsKey(b.charAt(j)) ? map.get(b.charAt(j)) : 0;
            map.put(b.charAt(j), --count);

            if(map.get(b.charAt(j)) < 0) return false;
        }

        return true;
    }

    @Test
    public void testIsPerm() throws Exception {
        assertTrue(isPerm("abc", "bac"));
        assertTrue(isPerm("marc", "cram"));
        assertTrue(isPerm("123456789", "987654321"));
        assertTrue(isPerm("aa", "aa"));
        assertTrue(isPerm("a b", "b a"));

        assertFalse(isPerm("", "a"));
        assertFalse(isPerm("abc", "def"));
        assertFalse(isPerm("test", "rest"));
        assertFalse(isPerm("ok", "ok123"));
        assertFalse(isPerm("abc", "ab c"));
    }
}
