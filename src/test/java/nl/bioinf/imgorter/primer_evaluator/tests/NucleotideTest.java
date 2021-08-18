package nl.bioinf.imgorter.primer_evaluator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import nl.bioinf.imgorter.primer_evaluator.Nucleotide;
import org.junit.Test;

public class NucleotideTest {

    @Test
    public void testPairsWith() {
        assertTrue(Nucleotide.T.pairsWith(Nucleotide.A));
        assertTrue(Nucleotide.A.pairsWith(Nucleotide.T));
        assertTrue(Nucleotide.C.pairsWith(Nucleotide.G));
        assertTrue(Nucleotide.G.pairsWith(Nucleotide.C));
    }

    @Test
    public void testGetComplement() {
        assertEquals(Nucleotide.T, Nucleotide.A.getComplement());
        assertEquals(Nucleotide.A, Nucleotide.T.getComplement());

        assertEquals(Nucleotide.G, Nucleotide.C.getComplement());
        assertEquals(Nucleotide.C, Nucleotide.G.getComplement());
    }

    @Test
    public void testFromChar() {
        assertEquals(Nucleotide.A, Nucleotide.fromChar('A'));
        assertEquals(Nucleotide.A, Nucleotide.fromChar('a'));

        assertEquals(Nucleotide.C, Nucleotide.fromChar('C'));
        assertEquals(Nucleotide.C, Nucleotide.fromChar('c'));

        assertEquals(Nucleotide.G, Nucleotide.fromChar('G'));
        assertEquals(Nucleotide.G, Nucleotide.fromChar('g'));

        assertEquals(Nucleotide.T, Nucleotide.fromChar('T'));
        assertEquals(Nucleotide.T, Nucleotide.fromChar('t'));

        assertEquals(null, Nucleotide.fromChar('z'));
    }

    @Test
    public void testEquals() {
        assertTrue(Nucleotide.T.equals(Nucleotide.T));
        assertTrue(Nucleotide.C.equals(Nucleotide.C));
        assertTrue(Nucleotide.G.equals(Nucleotide.G));
        assertTrue(Nucleotide.A.equals(Nucleotide.A));

        assertFalse(Nucleotide.A.equals(Nucleotide.C));

        assertTrue(Nucleotide.T.equals('T'));
        assertTrue(Nucleotide.C.equals('C'));
        assertTrue(Nucleotide.G.equals('G'));
        assertTrue(Nucleotide.A.equals('A'));

        assertFalse(Nucleotide.A.equals('T'));
    }
}