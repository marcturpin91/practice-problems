/**
 * Created by Marc on 2017-11-14.
 */
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
public class IsUniqueString {

    public static void main(String[] args){
        // implement algorithm to determine if string has all unique characters

    }

    public static boolean isUnique(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        // goes through string, if character already in map, it's not unique
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))) return false;

            map.put(s.charAt(i), 1);
        }
        return true;
    }

    @Test
    public void testIsUnique() throws Exception{
        assertTrue(isUnique("abcd"));
        assertTrue(isUnique("12aCVk0 w_"));
        assertTrue(isUnique(" !"));
        assertTrue(isUnique(" "));
        assertTrue(isUnique(""));

        assertFalse(isUnique("  "));
        assertFalse(isUnique("jgkeljt23"));
        assertFalse(isUnique("aaaaaaa"));
        assertFalse(isUnique("ababc"));
        assertFalse(isUnique("1234 abcd !"));
    }

}
