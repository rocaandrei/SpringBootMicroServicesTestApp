package com.plantplaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//Exemple de teste JUnit
public class JUnitAnnotationExamples {

	@BeforeClass // ruleaza o singura data inaintea tuturor testelor
	public static void setupEverything() {

		int a = 1 + 1;

	}

	@Before // o sa ruleze dupa fiecare metoda de test
	public void setupBeforeEachTest() {

		int a = 1 + 1;

	}

	@Test // un test normal ce trebuie sa ruleze
	public void runTests() {

		double a = 1.0 + 1.0;
		assertEquals(2, a, 0.0);
		// si dupa in Ebar JUnit iti vezi rezultatul testului
	}

	@Test // un test normal ce trebuie sa ruleze
	public void runTests3() {

		double a = 1.01 + 1.0;
		//linia de jos, al 3 lea parametru zice ca valoarea finala sa se regasesca intre 0.0 si 0.3 - de asta trece desi rezultatul este de 2.01
		assertEquals(2, a, 0.3);
		Object s = null;
		assertNull(s);
		assertTrue(4 == 2+2);
	}
	
	@Ignore//asa o sa iti ignore testul asta de mai jos... nu o sa-l verifice
	@Test
	public void runFailTests() {
		fail();//cand vrei sa nu-ti treaca testul 
	}

	@Test
	public void runTests2() {

		int a = 1 + 2;
		assertEquals(3, a);

	}

	@AfterClass
	public static void teardownEverything() {

		int a = 1 + 1;
	}

	@After
	public void teardownBeforeEachTest2() {

		int a = 1 + 1;
	}

}
