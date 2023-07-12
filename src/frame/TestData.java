package frame;

import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JTable;

public class TestData {
	private JFrame frame;
	private JTable table;
	private ScrollPane scrollPane;
	public TestData(JFrame frame, JTable table, ScrollPane scrollPane) {
		this.frame = frame;
		this.table = table;
		this.scrollPane=scrollPane ;
	}
	/*

	public String getFrameTitle() {
		return frame.getTitle();
	}

	public Rectangle getFrameBound() {
		return frame.getBounds();

	}

	public int getCloseOperation() {
		return frame.getDefaultCloseOperation();
	}

	public String getFrameLayout() {
		LayoutManager layout = frame.getContentPane().getLayout();
		if (layout == null) {
			return "null";
		} else {
			return layout.toString();
		}
	}
	
	
	public boolean existTable() {
		return table.getParent().equals(scrollPane.getViewport());
	}
	
	*/

}
