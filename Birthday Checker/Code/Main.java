import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of students? ");
        int students = scan.nextInt();

        System.out.print("Number of runs? ");
        int runs = scan.nextInt();
        Run run = new Run(runs,students);
    }
}