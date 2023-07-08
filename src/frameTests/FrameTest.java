package frameTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import frame.App;

class FrameTest {
	@Test
	void titleTest() {
		App app = new App();
		assertEquals("Tanulók", app.getFrameTitle());
	}
	
	
	@Test
	void boundTest() {
		App app = new App();
		Rectangle r = app.getFrameBound();
		assertEquals(r.x,100);
		assertEquals(r.y,100);
		assertEquals(r.width,450);
		assertEquals(r.height,300);
	}
	
	
	@Test
	void closeTest() {
		App app = new App();
		assertEquals(app.getFraneCloseOperation(),3);
	}

}
