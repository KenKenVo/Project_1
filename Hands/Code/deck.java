import java.util.ArrayList;
import java.util.Collections;

public class deck {

    private int deckSize = 52;
    ArrayList<Card> deck;
    public deck(){
        deck = new ArrayList<Card>();
    }
    public void populateDeck(){
        for (int suite = 1; suite<=4; suite++){
            for (int value = 1; value<=13; value++){
                deck.add(new Card(suite,value));
            }
        }
    }
    public void printDeck(){
        for (Card c : deck ){
            System.out.println(c.toString());
        }
    }
    public ArrayList<Card> Draw(int cardDrawn){
        shuffle();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i=0; i<cardDrawn; i++){
            hand.add(deck.get(i));
        }
        return hand;
    }
    public ArrayList<Card> draw(){
        ArrayList<Card> hand = new ArrayList<>();
        Card C1 = new Card(1, 1);
        Card C2 = new Card(1, 7);
        Card C3 = new Card(2, 9);
        Card C4 = new Card(1, 10);
        Card C5 = new Card(1, 11);
        Card C6 = new Card(1, 12);
        Card C7 = new Card(1, 13);
        hand.add(C1);
        hand.add(C2);
        hand.add(C3);
        hand.add(C4);
        hand.add(C5);
        hand.add(C6);
        hand.add(C7);
        return hand;
    }
    public void shuffle(){
        for (int i=0; i<10; i++){
            Collections.shuffle(deck);
        }
    }

}
