import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class factory {

    private ArrayList<String> carTypes;
    private ArrayList<String> colorTypes;
    private ArrayList<Car> carList;
    public factory(){
        carList = new ArrayList<Car>();
        carTypes = new ArrayList<String>();
        carTypes.add("sedan");
        carTypes.add("sedan");
        carTypes.add("sedan");
        carTypes.add("truck");
        carTypes.add("truck");
        carTypes.add("suv");
        carTypes.add("suv");
        carTypes.add("ev");
        carTypes.add("ev");
        colorTypes = new ArrayList<String>();
        colorTypes.add("red");
        colorTypes.add("red");
        colorTypes.add("red");
        colorTypes.add("black");
        colorTypes.add("black");
        colorTypes.add("blue");
        colorTypes.add("blue");
        colorTypes.add("white");
        colorTypes.add("white");
        colorTypes.add("green");
        colorTypes.add("green");
    }
    public void printList(){
        for(Car c : carList){System.out.println(c.toString());}
    }
    public String genRandCarType(){

        return carTypes.get(ThreadLocalRandom.current().nextInt(0, carTypes.size()));
    }
    public String genRandColorType(){

        return colorTypes.get(ThreadLocalRandom.current().nextInt(0, colorTypes.size()));
    }
    public int randNumYear(){

        return ThreadLocalRandom.current().nextInt(1973, 2023);
    }
    public int randMiles(){

        return ThreadLocalRandom.current().nextInt(0, 250000);
    }
    public void genCarList(){
        for(int i = 0; i < 1000; i++){
            Car Car = new Car(genRandCarType(), randNumYear(), genRandColorType(), randMiles());
            carList.add(Car);
        }
    }
    //Cited Source: https://stackoverflow.com/questions/59193360/how-to-write-data-into-csv-file-using-only-core-java
    public void writeToCSV() throws Exception {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("carData.csv"), StandardCharsets.UTF_16))){
            String header = "makeType, year, color, miles";
            writer.write(header+ "\n");
            for(Car Car : carList) {
                writer.write(Car.toString()+ "\n");
            }
        }
        catch(Exception e) {
            System.out.println("Something went wrong.");
        }
    }
    public void CSVReader() throws FileNotFoundException, UnsupportedEncodingException {
        String file = "carData.csv";
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF16"));
        try {
            line = br.readLine();
            while (br.readLine() != null){
                System.out.println(line);
                line = br.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
