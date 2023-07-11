package frameTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import frame.App;

class TableTest {

	@Test
	void rowCountAfterRemoveAllTest() {
		App app = new App();
		assertEquals(0, app.removeAllRows());
	}
	
	
	@Test
	void createStudentsTest() {
		App app = new App();
		assertEquals(6, app.createStudents());
	}
	
	
	
	@Test
	void existTableTest() {
		App app = new App();
//assertTrue(app.table.getParent()==app.frame);
assertTrue(app.table.getParent().equals(app.scrollPane));
	}
}
