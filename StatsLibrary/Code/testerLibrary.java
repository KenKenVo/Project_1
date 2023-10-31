import java.util.ArrayList;

public class testerLibrary {

    public static void main(String[] args){
        statsLibrary test = new statsLibrary();
        ArrayList<Integer> someNumbers = new ArrayList<>();
        ArrayList<Integer> someNumbers2 = new ArrayList<>();
        someNumbers.add(1);
        someNumbers.add(2);
        someNumbers2.add(3);
        someNumbers.add(3);
        someNumbers2.add(4);
        someNumbers.add(4);
        someNumbers.add(5);// 1+2+3+4= 10/4 = expected result 2.5
        someNumbers2.add(6);
        someNumbers2.add(7);
        double result = test.mean(someNumbers);
        double result2 = test.med(someNumbers);
        double result3 = test.standardDeviation(someNumbers);
        double result4 = test.mode(someNumbers);
        test.combination(someNumbers,3);
        System.out.println("Mode of input: " + result4);
        System.out.println("standard deviation of input: " + result3 );
        System.out.println("Median of input: "+ result2);
        System.out.println("Average of input: " + result);
        test.combination(someNumbers,2);
        test.permutation(someNumbers2,2);
        test.union(someNumbers,someNumbers2);
        test.Intersection(someNumbers,someNumbers2);
        test.complement(someNumbers,someNumbers2);
        test.binomialDistribution(8,20,.5);
        test.geometricDistributionPMF(.5,8);
        test.geometricDistributionCDF(.5,9);

        test.hyperGeometricDistribution(50,20,10);
        test.poissonDistribution(12,8);
        test.poissonDistribution(2);

    }

}