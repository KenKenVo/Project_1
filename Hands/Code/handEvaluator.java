import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;


public class handEvaluator {
    private ArrayList<Card> hand;
    private deck deck;
    private int single;
    private int pair;
    private int triple;
    private int four;
    private int straight;
    private int flush;
    private int straightFlush;
    private int fullHouse;
    private int royalFlush;


    public handEvaluator(){
        deck = new deck();
        deck.populateDeck();
        deck.shuffle();
        hand = new ArrayList<>();
        single=0;
        pair=0;
        triple=0;
        four=0;
        straight=0;
        flush=0;
        straightFlush=0;
        fullHouse=0;
        royalFlush=0;
    }
    public void getStats(int dealAmount,int handTotal, String title) throws Exception {

        for(int i =0; i< dealAmount; i++) {
            getHand(handTotal);
            sortHand();
            //printHand();
            evaluate();
        }
        writeToCSV(dealAmount, title);
        File file = new File(title+".csv");
        Desktop desktop = Desktop.getDesktop();
        if(file.exists())         //checks file exists or not
            desktop.open(file);
    }
    public void printHand(){
        for (Card c : hand){
            System.out.println(c.toString());
        }
    }
    public void getHand(int handAmount){

        hand = deck.Draw(handAmount);
        }
    public void evaluate(){
        if (royalFlush()){
            System.out.println("Royal flush found");
            royalFlush++;
        }
        else if (straightFlush()){
            System.out.println("Straight flush found");
            straightFlush++;
        }
        else if (fullHouse()){
            System.out.println("Full House is found");
            fullHouse++;
        }
        else if (flush()){
            System.out.println("Flush is found");
            flush++;
        }
        else if (straight()){
            System.out.println("Straight is found");
            straight++;
        }
        else if (four()){
            System.out.println("Four of a kind is found");
            four++;
        }
        else if (triple()){
            System.out.println("Three of a kind is found");
            triple++;
        }
        else if (pair()){
            System.out.println("A Pair is found");
            pair++;
        }
        else{
            single++;
            System.out.println("You're highest card is" + highCard().toString());
        }
    }
    public boolean pair(){
        int isPair = 0;
        for(int i = 1; i < hand.size(); i++)
        {
            if (hand.get(i-1).getValue() == hand.get(i).getValue())
            {
                isPair++;
                break;
            }
        }
        if(isPair==1)
            return true;
            else
                return false;
    }
    public boolean triple() {
        int isTriple = 0;
        boolean flag = false;
        for (int i = 1; i < hand.size() - 1; i++) {
            if (hand.get(i - 1).getValue() == hand.get(i + 1).getValue()) {
                flag = true;
            }
        }
        return flag;
    }
    public boolean four() {
        int Four = 0;
        boolean flag = false;
        for (int i = 1; i < hand.size() - 2; i++) {
            if (hand.get(i - 1).getValue() == hand.get(i + 2).getValue())
                flag = true;
        }
        return flag;
    }
    public boolean straight(){
        int isStraight= 0;
        for (int i = 0; i < hand.size()-1; i++)
        {
            if((hand.get(i).getValue() == hand.get(i+1).getValue()))
                continue;
            if (hand.get(i).getValue()+1 == (hand.get(i+1).getValue() ))
            {
               isStraight++;
            }
            else
                isStraight=0;
        }
        if(isStraight>=4)
        {
            return true;
        }
        else
            return false;
    }

    public boolean flush() {
        int s=0,h=0,d=0,c=0;
        int num = 5;

        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getSuite()==4)
                s++;
            else if (hand.get(i).getSuite()==3)
                h++;
            else if (hand.get(i).getSuite()==2)
                d++;
            else if (hand.get(i).getSuite()==1)
                c++;
        }
        if (s == num || h == num || d == num || c == num ) {
            return true;
        }
        else
            return false;
    }
    public boolean fullHouse(){
        int pair= 0;
        int triple = 0;
        boolean flag = false;
        for(int i = 0;i < hand.size(); i++)
        {
            if(triple == 1 && pair == 1 )
                flag=true;
            else if(pair == 2) {
                triple++;
                pair= 0;
            }
            else if(i+1<hand.size() && hand.get(i).getValue() == hand.get(i+1).getValue()){
                pair++;
            }
        }
        return flag;
    }
    public Card highCard() {
        Card highCard;
        if (hand.get(0).getValue() == 1) {
            highCard = hand.get(0);
        } else
            highCard = hand.get(hand.size() - 1);
        return highCard;
    }
        public void sortHand(){
        Collections.sort(hand, new cardComparator());
    }

    public boolean straightFlush(){
        int isStraight= 0;
        int isSuite=0;
        for (int i = 0; i < hand.size()-1; i++)
        {
            if((hand.get(i).getValue() == hand.get(i+1).getValue()))
                continue;
            if (hand.get(i).getValue()+1 == (hand.get(i+1).getValue()) &&
                    hand.get(i).getSuite() == hand.get(i+1).getSuite())
            {
                isSuite++;
                isStraight++;
            }
            else {
                isStraight = 0;
                isSuite=0;
            }
        }
        if(isStraight>=4 && isSuite>=4)
        {
            return true;
        }
        else
            return false;
    }

    public boolean royalFlush() {
        ArrayList<Card> s,h,d,c;
        s= new ArrayList<>();
        h= new ArrayList<>();
        d= new ArrayList<>();
        c= new ArrayList<>();
        boolean flag = false;


        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getSuite() == 4)
                s.add(hand.get(i));
            else if (hand.get(i).getSuite() == 3)
                h.add(hand.get(i));
            else if (hand.get(i).getSuite() == 2)
                d.add(hand.get(i));
            else if (hand.get(i).getSuite() == 1)
                c.add(hand.get(i));
        }
            if(s.size()>=5 ){
                flag = checkRoyalFlush(s);
            }
            if(h.size()>=5){
                flag = checkRoyalFlush(h);
            }
            if(d.size()>=5){
                flag = checkRoyalFlush(d);
            }
            if(c.size()>=5){
                flag =  checkRoyalFlush(c);
            }

        return flag;
    }

    public boolean checkRoyalFlush(ArrayList<Card>hand)
    {
        boolean flag = false;
        if(hand.get(0).getValue()==1 && hand.get(hand.size()-1).getValue()==13)
        {
            int counter = 0;
            for(int i= 1 ; i< hand.size()-1; i++)
            {
                if( hand.get(i).getValue() == 10)
                    counter++;
                if ( hand.get(i).getValue() == 11)
                    counter++;
                if (hand.get(i).getValue() == 12)
                    counter++;
                if (counter == 3){
                    flag= true;
                    break;
                }
            }
        }
        return flag;
    }
    public int getSingle() {
        return single;
    }

    public int getPair() {
        return pair;
    }

    public int getTriple() {
        return triple;
    }

    public int getFour() {
        return four;
    }

    public int getStraight() {
        return straight;
    }

    public int getFlush() {
        return flush;
    }

    public int getStraightFlush() {
        return straightFlush;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public int getRoyalFlush() {
        return royalFlush;
    }
    public void writeToCSV(int times,String title) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(title+".csv"), StandardCharsets.UTF_16))) {
            String header = "Hand, Number of Ways, Probability";
            writer.write(header + "\n");
            writer.write("Straight Flush," + straightFlush +","+ straightFlush / times + "\n");
            writer.write("Four of a kind," + four + ","+four / times + "\n");
            writer.write("Full House," + fullHouse +","+ fullHouse / times + "\n");
            writer.write("Flush," + flush + ","+flush / times + "\n");
            writer.write("Straight," + straight + ","+straight / times + "\n");
            writer.write("Three of a kind," +triple +  ","+triple / times + "\n");
            writer.write("Two Pair," + pair +","+ pair / times + "\n");
            writer.write("One Pair," + single +","+ single / times + "\n");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

}

