import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnionFindTest {

    @Test
    public void test() {
        UnionFind test = new UnionFind(10);
        test.union(0,1);
        test.union(2,3);
        test.union(0,3);
        test.union(5,6);
        test.union(6,7);
        test.union(8,7);
        test.union(0,6);
        test.find(1);

        int expectedRoot = 6;
        int actualRoot = test.find(0);
        assertEquals(expectedRoot, actualRoot);
    }
}
