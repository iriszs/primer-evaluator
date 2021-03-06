package nl.bioinf.imgorter.primer_evaluator;

import java.util.HashMap;

public class Primer {
    private final String sequence;
    private Nucleotide[] nucleotides;
    private boolean isForward;
    private String baseSequence;
    private HashMap<Nucleotide, Integer> baseCount;
    private double gcPercentage;
    private int meltingTemp;
    private HashMap <Nucleotide, Integer> maxHomopolymerLength;
    private int interIdentity;
    private int intraIdentity;

    /**
     * Create a new Primer object
     * @param sequence The sequence String of the primer
     */
    public Primer(String sequence){
        this.sequence = sequence;
        this.isForward = sequence.startsWith("5'-");
        if(isForward) {
            this.baseSequence = sequence.substring(sequence.indexOf('5') + 3, sequence.indexOf('3') -1);
        } else {
            this.baseSequence = sequence.substring(sequence.indexOf('3') + 3, sequence.indexOf('5') -1);
        }

        char[] sequenceChars = this.baseSequence.toCharArray();
        Nucleotide[] nucleotides = new Nucleotide[sequenceChars.length];

        for(int i = 0; i < sequenceChars.length; i++) {
            nucleotides[i] = Nucleotide.fromChar(sequenceChars[i]);
        }
        this.nucleotides = nucleotides;

    }

    public String getSequence() {
        return this.sequence;
    }

    public Nucleotide[] getNucleotides(){
        return this.nucleotides;
    }

    public Primer getReverse() {
        final String reversedNucleotideSeq = new StringBuilder(this.baseSequence).reverse().toString();

        String reversedSeq;
        if (this.isForward) {
            reversedSeq = String.format("3'-%s-5'", reversedNucleotideSeq);
        } else {
            reversedSeq = String.format("5'-%s-3'", reversedNucleotideSeq);
        }

        return new Primer(reversedSeq);
    }

    public Primer getComplement() {
        final char[] complementSeqChars = new char[this.nucleotides.length];
        for(int i = 0; i < this.nucleotides.length; i++) {
            Nucleotide base = this.nucleotides[i];
            complementSeqChars[i] = this.nucleotides[i].getComplement().getCharacter();
        }

        String complementSeq;
        if(this.isForward) {
            complementSeq = String.format("3'-%s-5'", String.valueOf(complementSeqChars));
        } else {
            complementSeq = String.format("5'-%s-3'", String.valueOf(complementSeqChars));
        }

        return new Primer(complementSeq);
    }

/**
    public void setBaseSequence(String baseSequence){
        this.baseSequence = baseSequence;
    }
*/
    public String getBaseSequence(){
        return this.baseSequence;
    }

    public void setNucleotideCount(HashMap<Nucleotide, Integer> baseCount){
        this.baseCount = baseCount;
    }

    public HashMap<Nucleotide, Integer> getNucleotideCount() {
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

    public void setHomopolymerLength(HashMap <Nucleotide, Integer> maxHomopolymerLength){
        this.maxHomopolymerLength = maxHomopolymerLength;

    }

    public HashMap<Nucleotide, Integer> getMaxHomopolymerLength() {
        System.out.println("The map with maximum homopolymer lenght is " + maxHomopolymerLength);
        return maxHomopolymerLength;
    }

    public void setInterIdentity(int interIdentity){
        this.interIdentity = interIdentity;
    }

    public int getInterIdentity(){
        System.out.println("The intermolecular identity of this primer is" + interIdentity);
        return interIdentity;
    }

    public void setIntraIdentity(int intraIdentity){
        this.intraIdentity = intraIdentity;
    }

    public int getIntraIdentity(){
        System.out.println("The intramolecular identity of this primer is " + intraIdentity);
        return intraIdentity;
    }


}

