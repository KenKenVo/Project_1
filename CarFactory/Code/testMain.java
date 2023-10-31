public class testMain {
    public static void main(String[] args) throws Exception {
        factory fac = new factory();
        fac.genCarList();
        fac.writeToCSV();
        fac.CSVReader();
    }
}
