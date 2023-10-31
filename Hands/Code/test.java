public class test {
    public static void main(String[] args) throws Exception {
        handEvaluator he = new handEvaluator();
        he.getStats(10000,5 ,"7 Card Poker");
        he.getStats(10000, 7 ,"5 Card Poker");
    }
}
