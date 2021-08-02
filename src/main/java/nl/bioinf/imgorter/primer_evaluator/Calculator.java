package nl.bioinf.imgorter.primer_evaluator;

import java.util.HashMap;

public class Calculator {

    public HashMap<Character, Integer> calculateNucleotideCount(String baseSequence){
        System.out.println("In the calculate base count");
        System.out.println(baseSequence);
        HashMap<Character, Integer> nucCount = new HashMap ();
        char nucA = 'A';
        char nucC = 'C';
        char nucT = 'T';
        char nucG = 'G';

        int countA = 0;
        int countC = 0;
        int countT = 0;
        int countG = 0;

        for (int i = 0; i < baseSequence.length(); i++) {
            if (baseSequence.charAt(i) == nucA) {
                countA++;
            }
            if (baseSequence.charAt(i) == nucC) {
                countC++;
            }
            if (baseSequence.charAt(i) == nucT) {
                countT++;
            }
            if (baseSequence.charAt(i) == nucG) {
                countG++;
            }
        }
        nucCount.put(nucA, countA);
        nucCount.put(nucC, countC);
        nucCount.put(nucT, countT);
        nucCount.put(nucG, countG);

        return nucCount;
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
        System.out.println("melting temp in the function = " + meltingTemp);

        return meltingTemp;
    }

    public HashMap<Character, Integer> calculateMaxHomopolymerLength(String baseSeq) {
        final HashMap<Character, Integer> result = new HashMap<>();

        int aCounter = 0;
        int cCounter = 0;
        int gCounter = 0;
        int tCounter = 0;

        char[] baseSeqChars = baseSeq.toCharArray();
        char prevChar = 0;

        for(int i = 0; i < baseSeqChars.length; i++) {
            char c = baseSeqChars[i];

            if(prevChar == c) {
                switch(c) {
                    case 'A':
                        aCounter++;
                        break;
                    case 'C':
                        cCounter++;
                        break;
                    case 'G':
                        gCounter++;
                        break;
                    case 'T':
                        tCounter++;
                        break;
                }
            } else {
                switch(prevChar) {
                    case 'A':
                        insertIfLarger(result, prevChar, ++aCounter);
                        aCounter = 0;
                        break;
                    case 'C':
                        insertIfLarger(result, prevChar, ++cCounter);
                        cCounter = 0;
                        break;
                    case 'G':
                        insertIfLarger(result, prevChar, ++gCounter);
                        gCounter = 0;
                        break;
                    case 'T':
                        insertIfLarger(result, prevChar, ++tCounter);
                        tCounter = 0;
                        break;
                }
            }

            prevChar = c;
        }

        switch(prevChar) {
            case 'A':
                insertIfLarger(result, prevChar, ++aCounter);
                break;
            case 'C':
                insertIfLarger(result, prevChar, ++cCounter);
                break;
            case 'G':
                insertIfLarger(result, prevChar, ++gCounter);
                break;
            case 'T':
                insertIfLarger(result, prevChar, ++tCounter);
                break;
        }

        System.out.println("a Counter = " + aCounter);
        System.out.println("c Counter = " + cCounter);
        System.out.println("g Counter = " + gCounter);
        System.out.println("t Counter = " + tCounter);

        return result;
    }

    private void insertIfLarger(final HashMap<Character, Integer> polymerMap, char nuc, int nucCount) {
        Integer currentCount = polymerMap.get(nuc);
        if(currentCount == null) {
            polymerMap.put(nuc, nucCount);
            return;
        }

        if(nucCount > currentCount) {
            polymerMap.put(nuc, nucCount);
        }
    }

}
