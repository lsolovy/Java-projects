import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JunitTests {

    @Test
    void cosine() {
        CosineSimilarity c = new CosineSimilarity();
        double[] a = {1, 2, 3};
        double[] b = {2, 6, 3};
        double[] i = {1, 2};
        double[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] f = {1,1,1,1,1,1,1,1,1,1};
        double[] g = {};
        double[] h = {2.5, 2.9};
        assertEquals(0.8781440805693944, c.Cosine(a, b),0.01);
        assertEquals(0.0,c.Cosine(a,i));
        assertEquals(0.8864052604279183,c.Cosine(d,f));
        assertEquals(0.9694515404198261,c.Cosine(h,i));
        assertEquals(0.0,c.Cosine(g,g));

    }

    @Test
    void hamming(){
        HammingDistance h = new HammingDistance();
        String a = "0110101";
        String b = "1110010";
        String c = "";
        String d = "0110000";
        String e = "101";
        String f = "111";
        String i = "111";
        assertEquals(4,h.Hamming(a,b));
        assertEquals(0,h.Hamming(a,c));
        assertEquals(2,h.Hamming(a,d));
        assertEquals(1,h.Hamming(e,f));
        assertEquals(0,h.Hamming(f,i));
    }

    @Test
    void euclidean() {
        EuclideanDistance e = new EuclideanDistance();
        double[] a = {1, 2, 3};
        double[] b = {2, 6, 3};
        double[] c = {1, 2};
        double[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        double[] g = {};
        double[] h = {2.5, 2.9};
        assertEquals(4.123105625617661, e.Euclidean(a, b));
        assertEquals(0.0, e.Euclidean(a, c));
        assertEquals(19.621416870348583, e.Euclidean(d, f));
        assertEquals(0.0, e.Euclidean(a, g));
        assertEquals(1.74928556845359, e.Euclidean(c, h));
    }



}



