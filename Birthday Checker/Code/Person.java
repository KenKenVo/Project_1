import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person {
    int randomMonth;
    int randomDay;


    public void createBirthday() { // Create random MM/DD

        Random random = new Random();
        randomMonth = ThreadLocalRandom.current().nextInt(1, 12) + 1; //To make sure it hits 1-12 months

        if(randomMonth == 1 || randomMonth == 3 || randomMonth == 5 || randomMonth == 7 || randomMonth == 8|| randomMonth == 10 || randomMonth == 12){
            randomDay = ThreadLocalRandom.current().nextInt(1, 31) + 1;
        }else if (randomMonth == 2){
            randomDay = ThreadLocalRandom.current().nextInt(1, 28) + 1; // leap year was excluded
        }else{
            randomDay = ThreadLocalRandom.current().nextInt(1, 30) + 1;
        }
    }

    public String toString()
    {
        String birthday = String.valueOf(randomMonth) +"/"+ String.valueOf(randomDay);
        return  birthday;
    }
}