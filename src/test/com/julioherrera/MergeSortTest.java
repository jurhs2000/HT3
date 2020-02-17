package test.com.julioherrera; 

import com.julioherrera.MergeSort;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static junit.framework.TestCase.assertEquals;

/** 
* MergeSort Tester. 
* 
* @author Julio Herrera
* @since <pre>feb. 16, 2020</pre> 
* @version 1.0 
*/ 
public class MergeSortTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sort(Comparable[] numbersToOrder) 
* 
*/ 
@Test
public void testSort() throws Exception {

    Comparable[] numbersDeso = {8,-5,1,6,-9,15,354,74,212,108,-86,-21};
    MergeSort mergeSort = new MergeSort();
    Comparable[] numbersOrd = new Comparable[12];
    numbersOrd = mergeSort.sort(numbersDeso);
    Comparable[] numbersOrdEsp = {-86,-21,-9,-5,1,6,8,15,74,108,212,354};
    assertEquals(numbersOrdEsp[0], numbersOrd[0]);
    assertEquals(numbersOrdEsp[1], numbersOrd[1]);
    assertEquals(numbersOrdEsp[2], numbersOrd[2]);
    assertEquals(numbersOrdEsp[3], numbersOrd[3]);
    assertEquals(numbersOrdEsp[4], numbersOrd[4]);
    assertEquals(numbersOrdEsp[5], numbersOrd[5]);
    assertEquals(numbersOrdEsp[6], numbersOrd[6]);
    assertEquals(numbersOrdEsp[7], numbersOrd[7]);
    assertEquals(numbersOrdEsp[8], numbersOrd[8]);
    assertEquals(numbersOrdEsp[9], numbersOrd[9]);
    assertEquals(numbersOrdEsp[10], numbersOrd[10]);
    assertEquals(numbersOrdEsp[11], numbersOrd[11]);
}
} 
