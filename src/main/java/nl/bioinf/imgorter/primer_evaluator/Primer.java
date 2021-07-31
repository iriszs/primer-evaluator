package nl.bioinf.imgorter.primer_evaluator;

import java.util.HashMap;
import java.util.*;

public class Primer {
    private final String sequence;
    private String baseSequence;
    private Map baseCount;
    private double gcPercentage;
    private int meltingTemp;
    private int maxHomopolymerLength;
    private int inter_identity;
    private int intra_identity;

    public Primer(String sequence){
        this.sequence = sequence;
    }

    public String getSequence() {
        System.out.println("The sequence of this primer is: " + sequence);
        return sequence;
    }

    public void setBaseSequence(String baseSequence){
        this.baseSequence = baseSequence;
    }

    public String getBaseSequence(){
        baseSequence = sequence.substring(sequence.indexOf("5") + 3, sequence.indexOf("3") -1 );
        //String[] baseSequence = sequence.split("-");
        //werkt niet want daar zit dan nog een - aan
        return baseSequence;
    }

    public void setBaseCount(Map baseCount){
        this.baseCount = baseCount;
    }

    public Map getBaseCount() {
        return baseCount;
    }

    public void setGcPercentage(double gcPercentage) {
        this.gcPercentage = gcPercentage;
    }

    public double getGcPercentage(){
        System.out.println("The GC percentage of this primer is: " + gcPercentage);
        return gcPercentage;
    }
    public void setMeltingTemp(int meltingTemp){
        this.meltingTemp = meltingTemp;
    }

    public int getMeltingTemp(){
        System.out.println("The melting temperature of this primer is: " + meltingTemp);

        return meltingTemp;
    }

}

