/* Deck shows the code shuffles our deck of cards and avoids magic constants
 *
 *     Hardwired constants: hardwire magic values like 4,13,52 tends to get sprinkled throughout your program, making 
 * the program significantly harder to maintain.
 *     Instead,create a variable for each constant,give it a meaningful name,and use it consistently.
 */
package challenge;

public class Deck {
    public static void main(String[] args){
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"};
        
        // avoid hardwired constants
        int SUITS = suit.length;
        int RANKS = rank.length;
        int N = SUITS * RANKS;
        
        // initialize deck
        String[] deck = new String[N];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
            }
        }
        
        // shuffle
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N-i)); // random generate the double value between 0 and 1
            String t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
        }
        
        // print shuffled deck
        for (int i = 0; i < N; i++) {
            System.out.println(deck[i]);
        }
    }
}