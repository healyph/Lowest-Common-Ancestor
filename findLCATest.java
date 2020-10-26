import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class findLCATest {

	@Test
	void test() {
		LCA test = new LCA();
		int result = test.findLCA(7, 3);
		assertEquals(3, result);
	}

}
