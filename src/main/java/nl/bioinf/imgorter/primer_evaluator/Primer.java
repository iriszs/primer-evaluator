package nl.bioinf.imgorter.primer_evaluator;

public class Primer {
    private final String sequence;
    private int GCperc;
    private int Melt_temp;
    private int max_homopolymer;
    private int inter_identity;
    private int intra_identity;

    public Primer(String sequence){

        this.sequence = sequence;
    }

    public void PrintSequence(){
        System.out.println("The sequence of this primer is: " + sequence);
    }
}

