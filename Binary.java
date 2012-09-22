/* Binary is used to print the binary representation of the decimal number typed as the command line argument
 *    --- Decompose the number into a sum of powers of two  
 *          107 = 64 + 32 + 8 + 2 + 1
 *          1101010 = 1000000 + 100000 + 1000 + 10 + 1
 *        the powers of 2 less than or equal to N in decreasing order to determine which belong in the binary decomposition
 * 
 *    --- Can not deal with negative integers
 */
public class Binary {
    public static void main(String[] args){
        // read in the argument
        int n = Integer.parseInt(args[0]);
        
        // set v to the largest power of two that is <= n
        int v = 1;
        while (v <= n/2) {
            v = v * 2;
        }
        
        // check for presence of powers of 2 in n, from largest to smallest
        //
        while (v > 0) {
            
            // v is not present in n
            if (n < v) {
                System.out.print(0); // because in binary, v is or is not present in n 
            }
            
            // v is present in n, so remove v from n
            else {
                System.out.print(1); // because v is even and therefore correspond to a 1 bit in the binary representation
                n = n - v;
            }
            
            // next smallest power of 2
            v = v / 2;
        }
        
        System.out.println();
    }
}