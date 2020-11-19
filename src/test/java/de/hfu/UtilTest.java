package de.hfu;

import static org.junit.Assert.assertEquals;

import org.junit.*;


public class UtilTest {
	
	
	@Test
	public void testUtil() {
		assertEquals("Januar sollte im ersten Halbjahr sein",true,Util.istErstesHalbjahr(1));
		assertEquals("Februar sollte im ersten Halbjahr sein",true,Util.istErstesHalbjahr(2));
		assertEquals("März sollte im ersten Halbjahr sein",true,Util.istErstesHalbjahr(3));
		assertEquals("April sollte im ersten Halbjahr sein",true,Util.istErstesHalbjahr(4));
		assertEquals("Mai sollte im ersten Halbjahr sein",true,Util.istErstesHalbjahr(5));
		assertEquals("Juni sollte im ersten Halbjahr sein",true,Util.istErstesHalbjahr(6));
		assertEquals("Juli sollte im ersten Halbjahr sein",false,Util.istErstesHalbjahr(7));
		assertEquals("August sollte im ersten Halbjahr sein",false,Util.istErstesHalbjahr(8));
		assertEquals("September sollte im ersten Halbjahr sein",false,Util.istErstesHalbjahr(9));
		assertEquals("Oktober sollte im ersten Halbjahr sein",false,Util.istErstesHalbjahr(10));
		assertEquals("November sollte im ersten Halbjahr sein",false,Util.istErstesHalbjahr(11));
		assertEquals("Dezember sollte im ersten Halbjahr sein",false,Util.istErstesHalbjahr(12));
	}
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testNull() {
		Util.istErstesHalbjahr(0);
	}
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testNegativeZahlen() {
		Util.istErstesHalbjahr(-7);
	}
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testGroßeZahlen() {
		Util.istErstesHalbjahr(13);
	}
}
