/**
 * 
 */

/**
 *
 */
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class PalindromeNumberSolution {
    public boolean isPalindrome(int x) {
		String st = (new Integer(x).toString());
		String[] num_str =   st.split("");
		boolean bl = false;
		String st_outputString = "";
		int check_zero = 0;
		if(num_str[0].equals(num_str[(num_str.length - 1)])) {
			for(int i=(num_str.length-1);i>=0;i--) {
				st_outputString = st_outputString + num_str[i];
			}
			if( (Integer.parseInt(st_outputString) - x)  == 0 ) {
				bl = true;
			}
		} 
        
        return bl;
    }
}