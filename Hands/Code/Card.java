public class Card {
    private int suite;
    private int value;

    public int getSuite() {
        return suite;
    }

    public int getValue() {
        return value;
    }

    public Card(int suite, int value){
        this.suite = suite;
        this.value = value;
    }
    public String toString(){
        String tempSuite="0";
        String tempValue=String.valueOf(value);
        if(suite == 1)
            tempSuite = "Clubs";
        else if(suite == 2)
            tempSuite="Diamond";
        else if(suite==3)
            tempSuite="Hearts";
        else if (suite==4)
            tempSuite="Spades";
        if(value==11)
            tempValue="Jack";
        if(value==12)
            tempValue="Queen";
        if(value==13)
            tempValue="King";
        if(value==1)
            tempValue="Ace";
        return tempValue + " of " +tempSuite;
    }
}
