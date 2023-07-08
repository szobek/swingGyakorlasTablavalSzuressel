package frame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableTest {

	@Test
	void rowCountAfterRemoveAllTest() {
		App app = new App();
		assertEquals(0, app.removeAllRows());
	}

}
