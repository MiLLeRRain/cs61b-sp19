import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void test() {
        UnionFind test = new UnionFind(10);

        test.union(1,0);
        test.union(2,3);
        test.union(3,0);
        test.union(5,6);
        test.union(8,7);
        test.union(6,7);
        test.union(2,7);
        test.find(2);

        int expectedRoot = 7;
        int actualRoot = test.find(2);
        assertEquals(expectedRoot, actualRoot);

        assertEquals(8, test.sizeOf(8));


    }

}
