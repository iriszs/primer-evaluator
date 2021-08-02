package nl.bioinf.imgorter.primer_evaluator;

import java.util.HashMap;

public class Calculator {

    public HashMap<Character, Integer> calculateBaseCount(String baseSequence){
        System.out.println("In the calculate base count");
        System.out.println(baseSequence);
        HashMap<Character, Integer> baseCount = new HashMap ();
        char baseA = 'A';
        char baseC = 'C';
        char baseT = 'T';
        char baseG = 'G';

        int countA = 0;
        int countC = 0;
        int countT = 0;
        int countG = 0;

        for (int i = 0; i < baseSequence.length(); i++) {
            if (baseSequence.charAt(i) == baseA) {
                countA++;
            }
            if (baseSequence.charAt(i) == baseC) {
                countC++;
            }
            if (baseSequence.charAt(i) == baseT) {
                countT++;
            }
            if (baseSequence.charAt(i) == baseG) {
                countG++;
            }
        }
        baseCount.put(baseA, countA);
        baseCount.put(baseC, countC);
        baseCount.put(baseT, countT);
        baseCount.put(baseG, countG);

        return baseCount;
    }

    public double calculateGC(HashMap<Character, Integer> baseCount){
        System.out.println("basecount map" + baseCount);

        double GCPercentage;
        int countA = (int) baseCount.get('A');
        int countC = (int) baseCount.get('C');
        int countT = (int) baseCount.get('T');
        int countG = (int) baseCount.get('G');

        System.out.println("Count of A bases: " + countA);
        System.out.println("Count of C bases: " + countC);
        System.out.println("Count of T bases: " + countT);
        System.out.println("Count of G bases: " + countG);

        GCPercentage = (double) (countG + countC) / (countA + countC + countG + countT) * 100;

        System.out.println("GCpercentage calculated in the calculator = " + GCPercentage);

        return GCPercentage;
    }

    public int calculateMeltingTemp(HashMap<Character, Integer> baseCount){

        int meltingTemp;

        int countA = baseCount.get('A');
        int countC = baseCount.get('C');
        int countT = baseCount.get('T');
        int countG = baseCount.get('G');

        meltingTemp = (int) (4* (countG + countC)) + (2* (countA + countT));


        return meltingTemp;
    }

}
