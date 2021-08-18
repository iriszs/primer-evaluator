package nl.bioinf.imgorter.primer_evaluator.tests;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import nl.bioinf.imgorter.primer_evaluator.Calculator;
import nl.bioinf.imgorter.primer_evaluator.Nucleotide;
import nl.bioinf.imgorter.primer_evaluator.Primer;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    private Nucleotide[] toNucleotideArray(String seq) {
        char[] nucleotideChars = seq.toCharArray();
        Nucleotide[] nucleotides = new Nucleotide[nucleotideChars.length];
        for (int i = 0; i < nucleotideChars.length; i++) {
            nucleotides[i] = Nucleotide.fromChar(nucleotideChars[i]);
        }
        return nucleotides;
    }

    @Before
    public void setup() {
        this.calculator = new Calculator();
    }

    @Test
    public void testCountNucleotides() {
        HashMap<Nucleotide, Integer> expectedResult = new HashMap<>();
        expectedResult.put(Nucleotide.T, 1);
        expectedResult.put(Nucleotide.C, 2);
        expectedResult.put(Nucleotide.G, 3);
        expectedResult.put(Nucleotide.A, 4);

        assertEquals(expectedResult, this.calculator.CountNucleotides(new Primer("5'-TCGGCGAAAA-3'").getNucleotides()));
    }

    @Test
    public void testCalculateGC() {
        Primer p = new Primer("5'-CCTTGGAA-3'");
        assertEquals(50.0d, this.calculator.calculateGC(p.getNucleotideCount()), 0.05d);
    }

    @Test
    public void testCalculateMeltingTemp() {
        Primer p = new Primer("5'-CCTTGGAA-3'");
        assertEquals(24.0d, this.calculator.calculateMeltingTemp(p.getNucleotideCount()), 0.05d);
    }

    @Test
    public void testMaxHomopolymerLengthSingleOccurence() {
        HashMap<Nucleotide, Integer> expectedResult = new HashMap<>();
        expectedResult.put(Nucleotide.A, 3);
        expectedResult.put(Nucleotide.C, 3);
        expectedResult.put(Nucleotide.G, 3);
        expectedResult.put(Nucleotide.T, 4);

        HashMap<Nucleotide, Integer> foundResult =  this.calculator.calculateMaxHomopolymerLength(toNucleotideArray("AAACCCGGGTTTT"));
        assertEquals(expectedResult, foundResult);
    }

    @Test
    public void testMaxHomopolymerLengthMultiOccurence() {
        HashMap<Nucleotide, Integer> expectedResult = new HashMap<>();
        expectedResult.put(Nucleotide.A, 4);
        expectedResult.put(Nucleotide.C, 3);
        expectedResult.put(Nucleotide.G, 3);
        expectedResult.put(Nucleotide.T, 4);

        assertEquals(expectedResult, this.calculator.calculateMaxHomopolymerLength(toNucleotideArray("AAACCCGGGTTTTAAAA")));
        assertEquals(expectedResult, this.calculator.calculateMaxHomopolymerLength(toNucleotideArray("AAACCCGGGTTTTAAAAC")));
        assertEquals(expectedResult, this.calculator.calculateMaxHomopolymerLength(toNucleotideArray("AAACCCGGGTTTTAAAAG")));
        assertEquals(expectedResult, this.calculator.calculateMaxHomopolymerLength(toNucleotideArray("AAACCCGGGTTTTAAAAT")));
    }

    @Test
    public void testIntermolecularIdentity() {
        Primer a = new Primer("5'-ACTGCATGGCATCGCAGCT-3'");
        Primer b = new Primer("5'-GAGGCACTAGCATAGCTGC-3'");
        Primer c = new Primer("5'-CCCCC-3'");
        Primer d = new Primer("5'-AAAA-3'");

        assertEquals(2, this.calculator.calculateIntermolecularIdentity(a, b));
        assertEquals(0, this.calculator.calculateIntermolecularIdentity(c, d));
    }

    @Test
    public void testIntramolecularIdentity() {
        Primer a = new Primer("5'-ACTGCATGGCATCGCAGCT-3'");
        Primer b = new Primer("5'-AAAA-3'");

        assertEquals(4, this.calculator.calculateIntramolecularIdentity(a));
        assertEquals(0, this.calculator.calculateIntramolecularIdentity(b));
    }

}
