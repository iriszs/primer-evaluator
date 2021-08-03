package nl.bioinf.imgorter.primer_evaluator;

import java.io.FileNotFoundException;

public class PrimerEvaluator {
    public static void main(String[] args) throws FileNotFoundException {
        for (String arg : args) {
            System.out.println("input arguments are: " + arg);
        }

        String name = args[0];
        int age = Integer.parseInt(args[1]);
        String fileLocation = args[2];
        InputHandler inputHandler = new InputHandler(name, age, fileLocation);
        inputHandler.printInput();
        InputHandler IH = new InputHandler(name, age, fileLocation);
        IH.ReadFile();

        // TODO for every sequence - create new primer object
        System.out.println("creating new primer object and reading the file");
        // Create new primer object while reading in the primer file
        Primer p = new Primer(IH.ReadFile());
        // Print the primers sequence
        p.getSequence();
        // Let the primer determine it's base sequence (only bases no 3'and 5')
        p.setBaseSequence(p.getBaseSequence());
        // Creating a new calculator object to calculate all characteristics of a primer
        Calculator cal = new Calculator();
        // Count individual bases and put in a hashmap
        p.setBaseCount(cal.CountNucleotides(p.getBaseSequence()));
        // Calculate GC percentage of primer using the individual base counts
        // and set result in primer object
        p.setGcPercentage(cal.calculateGC(p.getBaseCount()));
        // print result
        p.getGcPercentage();
        // Calculate melting temperature of the primer using the individual base counts
        // and set result in primer object
        p.setMeltingTemp(cal.calculateMeltingTemp(p.getBaseCount()));
        // print result
        p.getMeltingTemp();
        // Calculate the maximum homopolymer lenght in a hashmap using the individual base counts
        // and set result in primer object
        p.setHomopolymerLength(cal.calculateMaxHomopolymerLength(p.getBaseSequence()));
        // print result
        p.getMaxHomopolymerLength();


    }
}
