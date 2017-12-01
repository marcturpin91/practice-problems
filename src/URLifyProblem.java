/**
 * Created by Marc on 2017-11-14.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class URLifyProblem {
    /*
    Write a method that replaces spaces with '%20'
    The given string has enough space at the end to perform this action in place
    Use char array


     */
    public static void main(String[] args){

    }

    public static String URLify(String s, int actualSize){
        char[] result = s.toCharArray();
        // using two pointers, one for new position, one for old position
        int j = s.length() - 1;

        for(int i = actualSize - 1; i >= 0; i--){
            if(result[i] == ' '){
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            }
            else {
                result[j--] = result[i];
            }
        }


        return new String(result);
    }

    @Test
    public void testURLify() throws Exception {
        assertEquals("Mr%20John%20Smith",URLify("Mr John Smith    ", 13)); // total size 17, gap of 4. St
        assertEquals("%20Test", URLify(" Test  ", 5));

    }
}
