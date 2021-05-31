package Tests;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class MainTest extends TestCase {

    private List<Time> createList(Time...times){
        return new ArrayList<>(Arrays.asList(times));
    }

    private final SILab2 lab = new SILab2();

    @Test
    void multipleCondition(){
        RuntimeException ex;
        Time t1 = new Time(-6, 55, 14);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        Time t2 = new Time(30, 21, 55);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
        Time t3 = new Time(6,10,12);
        List<Integer> list1 = Arrays.asList(22212);
        assertEquals(list1,lab.function(createList(t3)));
        Time t4 = new Time(5, 78, 33);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        Time t5 = new Time(5, 61, 55);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t5)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        List<Integer> list2 = Arrays.asList(22212);
        assertEquals(list2,lab.function(createList(time3)));
        Time t6 = new Time(12, 20,-64);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t6)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        Time t7 = new Time(20, 10, 166);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t7)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        assertEquals(list2,lab.function(createList(time3)));
        Time t8 = new Time(24, 0, 0);
        List<Integer> result3 = Arrays.asList(86400);
        assertEquals(result3,lab.function(createList(t8)));
        Time t9 = new Time(27, 6, 42);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t9)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
        Time t10 = new Time(27, 15, 14);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t10)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }

    @Test
    void everyBranch(){
        List<Integer> list = new ArrayList<>();
        RuntimeException ex;
        Time t1 = new Time(-12, 55, 55);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        Time t2 = new Time(25,12,13);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
        Time t3 = new Time(6, 10, 12);
        list= Arrays.asList(22212);
        assertEquals(list, lab.function(createList(t3)));
        Time t4 = new Time(12, 61,41);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        Time t5 = new Time(12,12,172);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t5)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        Time t6 = new Time(24,0,0);
        list= Arrays.asList(86400);
        assertEquals(list, lab.function(createList(t6)));
        Time t7 = new Time(26,1,6);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(t7)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }
}
