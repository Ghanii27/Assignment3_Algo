
package edu.neu.coe.info6205.sort.elementary;

        import edu.neu.coe.info6205.sort.*;
        import edu.neu.coe.info6205.util.*;
        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertTrue;

public class BenchmarkInsertionSort {
    final static LazyLogger logger = new LazyLogger(InsertionSort.class);


    //Ordered Array
    @Test
    public void testRepeat1() {
        final Timer timer = new Timer();

        final double mean = timer.repeat(100, () -> {
            final Random random = new Random();
            int n = random.nextInt(10);
            sort(n+1);
            System.out.println(n);

            return null;
        });
        System.out.println(mean);

        assertEquals(100, new PrivateMethodTester(timer).invokePrivate("getLaps"));
        assertEquals(5, mean, 5);

    }


    //Reverse Ordered Array
    @Test
    public void test2() {
        final Timer timer = new Timer();

        final double mean = timer.repeat(100, () -> {
            final Random random = new Random();
            int n = random.nextInt(10);
            sort2(n+1);
            return null;
        });
        System.out.println(mean);
        assertEquals(100, new PrivateMethodTester(timer).invokePrivate("getLaps"));
        assertEquals(5, mean, 5);

    }




    //Random Ordered Array
    @Test
    public void test3() {
        final Timer timer = new Timer();

        final double mean = timer.repeat(100, () -> {
            final Random random = new Random();
            int n = random.nextInt(10);
            sort3(n+1);
            return null;
        });
        System.out.println(mean);
        assertEquals(100, new PrivateMethodTester(timer).invokePrivate("getLaps"));
        assertEquals(5, mean, 5);

    }


    //Partially Ordered Array
    @Test
    public void test4() {
        final Timer timer = new Timer();

        final double mean = timer.repeat(100, () -> {

            sort4();
            return null;
        });
        System.out.println(mean);
        assertEquals(100, new PrivateMethodTester(timer).invokePrivate("getLaps"));
        assertEquals(5, mean, 5);

    }




    //Doubling the no. of elements each time
    @Test
    public void test6() {
        final Timer timer = new Timer();

        final double mean = timer.repeat(100, () -> {

            sort5();
            return null;
        });
        System.out.println(mean);
        assertEquals(100, new PrivateMethodTester(timer).invokePrivate("getLaps"));
        assertEquals(5, mean, 5);

    }

    private void sort(int count){
        final List<Integer> list = new ArrayList<>();
        for(int i =0;i<count;i++){
            list.add(i+1);
        }
        Integer[] xs = list.toArray(new Integer[0]);
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", list.size(), config);
        helper.init(list.size());
        final PrivateMethodTester privateMethodTester = new PrivateMethodTester(helper);
        final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");
        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
    }


    private void sort2(int count){
        final List<Integer> list = new ArrayList<>();
        for(int i =0;i<count;i++){
            list.add(count-i+1);
        }
        Integer[] xs = list.toArray(new Integer[0]);

        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", list.size(), config);
        helper.init(list.size());

        final PrivateMethodTester privateMethodTester = new PrivateMethodTester(helper);

        final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");
        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);

    }


    private void sort3(int count){
        final List<Integer> list = new ArrayList<>();
        for(int i =0;i<count;i++){
            final Random random = new Random();
            int n = random.nextInt(count);
            list.add(n);
        }
        Integer[] xs = list.toArray(new Integer[0]);

        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", list.size(), config);
        helper.init(list.size());

        final PrivateMethodTester privateMethodTester = new PrivateMethodTester(helper);

        final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");

        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);

    }

    private void sort4()
    {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        Integer[] xs = list.toArray(new Integer[0]);
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", list.size(), config);
        helper.init(list.size());

        final PrivateMethodTester privateMethodTester = new PrivateMethodTester(helper);
        final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");
        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
    }




    private void sort5(){
        final List<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(18);
        list.add(27);
        list.add(28);
        list.add(49);
        list.add(38);
        list.add(25);
        list.add(24);

        Integer[] xs = list.toArray(new Integer[0]);
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", list.size(), config);
        helper.init(list.size());
        final PrivateMethodTester privateMethodTester = new PrivateMethodTester(helper);
        final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");
        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
    }
}
