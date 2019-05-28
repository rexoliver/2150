package setMods;
import static org.junit.Assert.*;
import org.junit.Test;
/*
 * Rex Oliver and Charles Hayes
 * CPSC 2150 Lab 7
 * TestListSet.java
 */
public class TestListSet {
    private ISet<Integer> MakeASet(){
        ISet<Integer> asTest = new ListSet<>();
        return asTest;
    }

    // TC : looks to see if duplicates are added
    @Test
    public void testAdd_1_2_add()
    {
        int num1 = 1;
        int num2 = 2;
        int size1 = 1;
        int size2 = 2;
        ISet<Integer> newSet = MakeASet();
        newSet.add(num1);
        assertEquals(size1, newSet.getSize(), 0.001);
        newSet.add(num2);
        // Shouldn't add the same value int twice
        assertEquals(size2, newSet.getSize(), 0.001);
    }

    // TC 2: tests contains on a set with zero values
    @Test
    public void testContains_0values(){
        int num1 = 1;

        ISet<Integer> newSet = MakeASet();

        assertTrue(!newSet.contains(num1));
    }
    // TC 3: tests if contains works on a single value
    @Test
    public void testContains_the_value(){
        int num1 = 1;
        ISet<Integer> newSet = MakeASet();
        newSet.add(num1);

        assertTrue(newSet.contains(num1));
    }
    // TC 4: tests if contains works when target int is not in set
    @Test
    public void testContains_does_not_contain_value_when_diff_val_present(){
        int num1 = 1;
        int num2 = 2;
        ISet<Integer> newSet = MakeASet();
        newSet.add(num1);
        assertTrue(!newSet.contains(num2));
    }
    // TC 5: tests if the union between a set with vals and no vals is correct
    @Test
    public void testUnion_SetVals_SetNoVals(){
        int num1 = 1;
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();

        set1.add(num1);
        set1.union(set2);

        assertTrue(set1.contains(num1));
        assertTrue(set1.getSize() == 1);
        assertTrue(set2.getSize() == 0);
    }
    // TC 6: tests if union between a set with no vals
    // and a set with vals works
    @Test
    public void testUnion_SetNoVals_SetVals(){
        int num1 = 1;
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();

        set2.add(num1);
        set1.union(set2);

        assertTrue(set1.contains(num1));
        assertEquals(set1.getSize(), 1, 0.0001);
        assertEquals(set2.getSize(), 0, 0.0001);
    }
    // TC 7: tests if a union of two sets with values works correctly.
    @Test
    public void testUnion_SetVals_SetVals(){
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();

        set1.add(num3);
        set2.add(num1);
        set2.add(num3);
        set1.add(num2);
        set1.union(set2);

        assertTrue(set1.contains(num1));
        assertTrue(set1.contains(num2));
        assertTrue(set1.contains(num3));
        assertEquals(set1.getSize(),3, 0.0001);
        assertEquals(set2.getSize(),0, 0.0001);
    }
    // TC 8: tests if difference
    @Test
    public void testDifference_SameVals(){
        int num1 = 1;
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        set2.add(num1);
        set1.add(num1);
        set1.difference(set2);
        assertEquals(set1.getSize(), 0);
        assertTrue(!set1.contains(num1));
    }
    @Test
    public void testDifference_Values_NoValues(){
        int num1 = 1;
        int num2 = 2;

        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();

        set1.add(num1);
        set1.add(num2);

        set1.difference(set2);
        assertEquals(set1.getSize(), 2, 0.0001);
        assertTrue(set1.contains(num1));
        assertTrue(set1.contains(num2));
    }
    @Test
    public void testDifference_FirstHasSomeSame_otherHasSomeSame(){
        int num1 = 1;
        int num2 = 2;
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();

        set1.add(num1);
        set1.add(num2);
        set2.add(num1);
        set1.difference(set2);

        assertTrue(set1.contains(num2));
        assertTrue(!set1.contains(num1));
    }
    // duplicate ints
    @Test
    public void testAdd_1_1()
    {
        int num1 = 1;
        int num2 = 1;
        int size1 = 1;
        int size2 = 2;
        ISet<Integer> newSet = MakeASet();
        newSet.add(num1);
        assertEquals(size1, newSet.getSize(), 0.001);
        newSet.add(num2);
        assertEquals(size2, newSet.getSize(), 0.001);
    }
    // positive and negative of same abs(value)
    @Test
    public void testAdd_neg1_1()
    {
        int num1 = 1;
        int num2 = -1;
        int size1 = 1;
        int size2 = 2;
        ISet<Integer> newSet = MakeASet();
        newSet.add(num1);
        assertEquals(size1, newSet.getSize(), 0.001);
        newSet.add(num2);
        assertEquals(size2, newSet.getSize(), 0.001);
    }
    // wrapper class (Integer) with min and max int vals
    @Test
    public void testAdd_min_max()
    {
        int size1 = 1;
        int size2 = 2;
        ISet<Integer> newSet = MakeASet();
        newSet.add(Integer.MAX_VALUE);
        assertEquals(size1, newSet.getSize(), 0.001);
        newSet.add(Integer.MIN_VALUE);
        assertEquals(size2, newSet.getSize(), 0.001);
    }
    // empty sets should be equivalent
    @Test
    public void testEquals_emptySet1_emptySet2()
    {
        ISet<Integer> newSet1 = MakeASet();
        ISet<Integer> newSet2 = MakeASet();
        assertTrue(newSet1.getSize() == 0);
        assertTrue(newSet2.getSize() == 0);
        assertEquals(newSet1, newSet2);
    }
    // sets with the same ints should be equivalent
    @Test

    public void testEquals_sameSet1_sameSet2()
    {
        int firstval = 1;
        int secondval = 2;
        int totalsize = 2;
        ISet<Integer> newSet1 = MakeASet();
        ISet<Integer> newSet2 = MakeASet();
        newSet1.add(firstval);
        newSet2.add(firstval);
        newSet1.add(secondval);
        newSet2.add(secondval);
        assertTrue(totalsize == newSet1.getSize());
        assertTrue(totalsize == newSet2.getSize());
        assertEquals(newSet1, newSet2);
    }
    // sets with different ints should not be equivalent
    @Test
    public void testEquals_diffSet1_diffSet2()
    {
        int firstval = 1;
        int secondval = 2;
        int thirdval = 3;
        int totalsize = 2;
        ISet<Integer> newSet1 = MakeASet();
        ISet<Integer> newSet2 = MakeASet();
        newSet1.add(firstval);
        newSet2.add(firstval);
        newSet1.add(secondval);
        newSet2.add(thirdval);
        assertTrue(totalsize == newSet1.getSize());
        assertTrue(totalsize == newSet2.getSize());
        assertTrue(!newSet1.contains(thirdval));
        assertTrue(!newSet2.contains(secondval));
        assertFalse(newSet1.equals(newSet2));
    }
    //same different all different
    @Test
    public void testIntersect_sameSet1_sameSet2()
    {
        int firstval = 1;
        int secondval = 2;
        int totalsize = 2;
        ISet<Integer> newSet1 = MakeASet();
        ISet<Integer> newSet2 = MakeASet();
        newSet1.add(firstval);
        newSet2.add(firstval);
        newSet1.add(secondval);
        newSet2.add(secondval);
        newSet1.intersect(newSet2);
        assertTrue(totalsize == newSet1.getSize());
        assertTrue(totalsize == newSet2.getSize());
    }
    // sets differing by 1 should return the correct sizes
    @Test
    public void testIntersect_diffSet1_diffSet2()
    {
        int firstval = 1;
        int secondval = 2;
        int thirdval = 3;
        int totalsize1 = 1;
        int totalsize2 = 2;
        ISet<Integer> newSet1 = MakeASet();
        ISet<Integer> newSet2 = MakeASet();
        newSet1.add(firstval);
        newSet2.add(firstval);
        newSet1.add(thirdval);
        newSet2.add(secondval);
        newSet1.intersect(newSet2);
        assertTrue(totalsize1 == newSet1.getSize());
        assertTrue(totalsize2 == newSet2.getSize());
    }
    // sets differing by all should make a union of size 0
    @Test
    public void testIntersect_alldiffSet1_alldifSet2()
    {
        int firstval = 1;
        int secondval = 2;
        int thirdval = 3;
        int fourthval = 4;
        int totalsizeset1 = 0;
        int totalsizeset2 = 2;
        ISet<Integer> newSet1 = MakeASet();
        ISet<Integer> newSet2 = MakeASet();
        newSet1.add(firstval);
        newSet2.add(secondval);
        newSet1.add(thirdval);
        newSet2.add(fourthval);
        newSet1.intersect(newSet2);
        assertTrue(totalsizeset1 == newSet1.getSize());
        assertTrue(totalsizeset2 == newSet2.getSize());
    }

}
