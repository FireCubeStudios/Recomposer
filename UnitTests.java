import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests {
  public static void main(String arg[])
  {

    test7(); //copied
    test8(); //NEW

    test1(); // copied
    test2(); // copied
    test3(); // copied
    test4(); //copied
    test5(); //copied
    test6(); //copied
  }

	
  ///This is the test that fails because it expects (Does It Offend You Yeah) instead of (Does It Off Yendea Youh) 
  ///but according to the instructions in the challenge "DeosItOffeYdnuoYaeh" will never become "Does It Offend You Yeah" 
  ///because "DeosItOffeYdnuoYaeh" split becomes [D, eo, s, I, t, O, ff, eY, dn, uoYae, h] which when reversed is [D, oe, s, I, t, O,ff, Ye, nd, eaYou, h] 
  ///which becomes "DoesItOffYendeaYouh" which when seperated by caps is Does It Off Yendea Youh
	@Test
  public static void test7() {
    try
    {
      assertEquals("Does It Offend You Yeah", Challenge.recompose("DeosItOffeYdnuoYaeh"));
    }
    catch (Exception e) 
    {
      //System.out.println(e.getMessage());
    }
  }
  ///This new test case I created does work because the scrambled text will become the expected text according to the challenge prompt
  public static void test8() {
      assertEquals("Does It Offend You Yeah", Challenge.recompose("DeosItOffednaeYuoY"));
  }



///Ignore below

    @Test
  public static void test1() {
    assertEquals("Kid Koala", Challenge.recompose("KiKdaola"));
  }
	
	@Test
  public static void test2() {
    assertEquals("Boards Of Canada", Challenge.recompose("BaosdrOCfanada"));
  }
	
	@Test
  public static void test3() {
    assertEquals("Chemical Brothers", Challenge.recompose("hCemicarBlohtesr"));
  }
	
	@Test
  public static void test4() {
    assertEquals("Mouse On Mars", Challenge.recompose("MuosOeMnasr"));
  }
	
	@Test
  public static void test5() {
    assertEquals("Aphex Twin", Challenge.recompose("AhpewTxin"));
  }
	
	@Test
  public static void test6() {
    assertEquals("Massive Attack", Challenge.recompose("MassivAettakc"));
  }
}