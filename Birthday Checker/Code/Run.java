import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner; //To allow user to enter input.

public class Run
{
    public Run(int x, int y)
    {
        runSimulations(x,y);
    }
    public double runSimulations(int totalRuns, int totalStudents)
    {
        double counter = 0;

        HashMap<String,Integer> birthdayList = new HashMap<>();
        System.out.println("Determine the probability of any 2 people sharing a birthday in the class!");
        System.out.println("With total Students: " + totalStudents);
        System.out.println("Total runs: "+ totalRuns);

        for (int x = 0; x< totalRuns; x++)
        {
            Person[] people  = new Person[totalStudents];
            //array to populate random birthdays
            for (int i = 0; i < people.length; i++)
            {
                Person person = new Person();
                person.createBirthday();;
                people[i] = person;
            }
            //print peoples birthdays;
            for(Person p : people)
            {
                System.out.print(p.toString()+ ",");
            }

            //array to check if same birthdays found
            for (Person bd : people)
            {
                if(birthdayList.containsKey(bd.toString()))
                {
                    System.out.println("Match found:" + bd.toString());
                    counter++;
                    break;
                }
                else
                {
                    birthdayList.put(bd.toString(),1);
                }
            }
            System.out.println();
            people = null;
            birthdayList.clear();
        }
        double percentage = counter/totalRuns * 100;
        System.out.println(counter+"/"+totalRuns+"*100="+percentage);
        return percentage;
    }
}