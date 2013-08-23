/* Sqrt.java computes the square root of a nonnegative number c using Newton's method
 *   --- initialize t=c
 *   --- replace t with the average of c/t and t
 *   --- repeat until deaired accuarcy reached
 *  
 *   bugs: args requires to be postive
 */
public class Sqrt {
    public static void main(String[] args){
    
        // read in the command-line argument
        double c = Double.parseDouble(args[0]);
        double epsilon = 1e-15; // define relative error tolerance
        double t=c;             //estimate of the square root of c
        
        // repeatedly apply Newton update until it is met
        while (Math.abs(t-c/t)>epsilon*t){   
            t=(c/t + t) / 2.0;
        }
        
        // print out
        System.out.println(t);
    }
}