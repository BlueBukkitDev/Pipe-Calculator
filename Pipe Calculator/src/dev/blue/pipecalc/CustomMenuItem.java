package dev.blue.pipecalc;

import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class CustomMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomMenuItem(String text) {
		super(text);
	}
	
	@Override
	protected void processMouseEvent(MouseEvent evt) {
		if(evt.getID() == MouseEvent.MOUSE_RELEASED && contains(evt.getPoint())) {
			doClick();
			setArmed(true);
		}else super.processMouseEvent(evt);
	}
}
