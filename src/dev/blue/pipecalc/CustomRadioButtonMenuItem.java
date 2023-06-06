package dev.blue.pipecalc;

import java.awt.event.MouseEvent;

import javax.swing.JRadioButtonMenuItem;

public class CustomRadioButtonMenuItem extends JRadioButtonMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomRadioButtonMenuItem(String text) {
		super(text);
	}
	
	@Override
	protected void processMouseEvent(MouseEvent evt) {
		if(evt.getID() == MouseEvent.MOUSE_RELEASED && contains(evt.getPoint())) {
			doClick();
			setArmed(false);
		}else super.processMouseEvent(evt);
	}
}
