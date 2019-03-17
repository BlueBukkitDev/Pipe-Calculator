package dev.blue.pipecalc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea output;
	public JTextField input;
	public JMenu savedInput;
	public JMenu data;
	public JMenu panels;
	private String selectedOption = "panels";
	private final String size1 = "64.57 x 39.06";
	private final String size2 = "64.96 x 39.02";
	private final String size3 = "65.59 x 39.37";
	private final String size4 = "65.94 x 39.06";
	private final String size5 = "77.01 x 39.06";
	public Window() {
		setTitle("Pipe Calculator V-"+Main.version);
		Dimension d = new Dimension(1080, 750);
		JPanel panel = new JPanel();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMaximumSize(d);
		setMinimumSize(d);
		setSize(d);
		setLocationRelativeTo(null);
		output = new JTextArea(40, 80);
		output.setLineWrap(true);
		output.setEditable(false);
		JScrollPane pane = new JScrollPane(output);
		
		panel.add(pane);
		add(setupJMenuBar(), BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		try {
			setIconImage(ImageIO.read(Window.class.getResource("/logo.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		pack();
		setVisible(true);
	}
	
	public void println(String s) {
		output.append(s+"\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().startsWith(size1)) {
			Main.panelHeight = 64.57;
			Main.panelWidth = 39.06;
			switch(e.getActionCommand().replaceAll(size1, "")) {
			case "1":{panels.setText("AC-260P/60S"); return;}
			case "2":{panels.setText("AC-265P/60S"); return;}
			case "3":{panels.setText("AC-270P/60S"); return;}
			case "4":{panels.setText("AC-275P/60S"); return;}
			case "5":{panels.setText("AC-280P/60S"); return;}
			case "6":{panels.setText("AC-280M/60S"); return;}
			case "7":{panels.setText("AC-285M/60S"); return;}
			case "8":{panels.setText("AC-290M/60S"); return;}
			case "9":{panels.setText("AC-295M/60S"); return;}
			case "10":{panels.setText("AC-300M/60S"); return;}
			case "11":{panels.setText("AC-305M/60S"); return;}
			case "12":{panels.setText("AC-310M/60S"); return;}
			}
		}else if(e.getActionCommand().startsWith(size2)) {
			Main.panelHeight = 64.96;
			Main.panelWidth = 39.02;
			switch(e.getActionCommand().replaceAll(size2, "")) {
			case "1":{panels.setText("AC-260P/156-60SE"); return;}
			case "2":{panels.setText("AC-265P/156-60SE"); return;}
			case "3":{panels.setText("AC-270P/156-60SE"); return;}
			}
		}else if(e.getActionCommand().startsWith(size3)) {
			Main.panelHeight = 65.59;
			Main.panelWidth = 39.37;
			switch(e.getActionCommand().replaceAll(size3, "")) {
			case "1":{panels.setText("AC-270PG/156-60S"); return;}
			case "2":{panels.setText("AC-275PG/156-60S"); return;}
			case "3":{panels.setText("AC-280PG/156-60S"); return;}
			case "4":{panels.setText("AC-280MG/60S"); return;}
			case "5":{panels.setText("AC-285MG/60S"); return;}
			case "6":{panels.setText("AC-290MG/60S"); return;}
			case "7":{panels.setText("AC-295MG/60S"); return;}
			case "8":{panels.setText("AC-300MG/60S"); return;}
			}
		}else if(e.getActionCommand().startsWith(size4)) {
			Main.panelHeight = 65.94;
			Main.panelWidth = 39.06;
			switch(e.getActionCommand().replaceAll(size4, "")) {
			case "1":{panels.setText("AC-270PH/60S"); return;}
			case "2":{panels.setText("AC-275PH/60S"); return;}
			case "3":{panels.setText("AC-280PH/60S"); return;}
			case "4":{panels.setText("AC-285PH/60S"); return;}
			case "5":{panels.setText("AC-290PH/60S"); return;}
			case "6":{panels.setText("AC-310MH/60S"); return;}
			case "7":{panels.setText("AC-315MH/60S"); return;}
			case "8":{panels.setText("AC-320MH/60S"); return;}
			case "9":{panels.setText("AC-325MH/60S"); return;}
			}
		}else if(e.getActionCommand().startsWith(size5)) {
			Main.panelHeight = 77.01;
			Main.panelWidth = 39.06;
			switch(e.getActionCommand().replaceAll(size5, "")) {
			case "1":{panels.setText("AC-310P/72S"); return;}
			case "2":{panels.setText("AC-315P/72S"); return;}
			case "3":{panels.setText("AC-320P/72S"); return;}
			case "4":{panels.setText("AC-325P/72S"); return;}
			case "5":{panels.setText("AC-330P/72S"); return;}
			case "6":{panels.setText("AC-320P/156-72S"); return;}
			case "7":{panels.setText("AC-325P/156-72S"); return;}
			case "8":{panels.setText("AC-330P/156-72S"); return;}
			case "9":{panels.setText("AC-330M/156-72S"); return;}
			case "10":{panels.setText("AC-335M/156-72S"); return;}
			case "11":{panels.setText("AC-340M/156-72S"); return;}
			case "12":{panels.setText("AC-345M/156-72S"); return;}
			case "13":{panels.setText("AC-350M/156-72S"); return;}
			case "14":{panels.setText("AC-350M/72S"); return;}
			case "15":{panels.setText("AC-355M/72S"); return;}
			case "16":{panels.setText("AC-360M/72S"); return;}
			}
		}
		switch(e.getActionCommand()) {
		case "run":{actionPerformed(new ActionEvent(input, ActionEvent.ACTION_PERFORMED, "inputEntry")); Main.runCalculation(); Main.writeOut();return;}
		case "save":{if(output.getText().length() > 0) {saveOutput();} return;}
		case "exit":{System.exit(0);return;}
///////////////////////////////////////////////////////
		case "vBraces":{Main.usesVBraces = !Main.usesVBraces; Main.calculatePostSpacing(); return;}
		case "pipe1_5":{Main.pipeSize = 1.5; Main.calculatePostSpacing(); return;}
		case "pipe2":{Main.pipeSize = 2.0; Main.calculatePostSpacing(); return;}
		case "sch40":{Main.pipeSched = 40; Main.calculatePostSpacing(); return;}
		case "sch80":{Main.pipeSched = 80; Main.calculatePostSpacing(); return;}
		case "feetInch":{Main.format = 1; return;}
		case "justInch":{Main.format = 2; return;}
		case "feetInchW1":{Main.format = 3; Main.accuracy = 64; return;}
		case "feetInchW2":{Main.format = 3; Main.accuracy = 32; return;}
		case "feetInchW3":{Main.format = 3; Main.accuracy = 16; return;}
		case "feetInchW4":{Main.format = 3; Main.accuracy = 8; return;}
		case "panelsWide":{input.setText(""+(int)(Main.panelsWide)); data.setText("Panel Columns:"); selectedOption = e.getActionCommand(); return;}
		case "panelsHigh":{input.setText(""+(int)(Main.panelsHigh)); data.setText("Panel Rows:"); selectedOption = e.getActionCommand(); return;}
		case "pipeLength":{input.setText(""+Main.pipeLength+"\""); data.setText("Pipe Length:"); selectedOption = e.getActionCommand(); return;}
		case "clampWidth":{input.setText(""+Main.ySpacing+"\""); data.setText("Clamp Width:"); selectedOption = e.getActionCommand(); return;}
		case "panelSpace":{input.setText(""+Main.xSpacing+"\""); data.setText("Panel Space:"); selectedOption = e.getActionCommand(); return;}
		case "railLength":{input.setText(""+Main.railLength+"\""); data.setText("Rail Length:"); selectedOption = e.getActionCommand(); return;}
		case "railHang":{input.setText(""+Main.railExcess+"\""); data.setText("Rail Overhang:"); selectedOption = e.getActionCommand(); return;}
		case "arrays":{input.setText(""+(int)Main.arrays); data.setText("Arrays:"); selectedOption = e.getActionCommand(); return;}
///////////////////////////////////////////////////////
		case "inputEntry":{
			if(selectedOption == "panelsWide") {
				if((Main.panelsWide = (int)(Double.parseDouble(input.getText()))) == 0) {
					Main.panelsWide = 1;
				}
				input.setText(""+(int)(Main.panelsWide));
				return;
			}else if(selectedOption == "panelsHigh") {
				if((Main.panelsHigh = (int)(Double.parseDouble(input.getText()))) == 0) {
					Main.panelsHigh = 1;
				}
				input.setText(""+(int)(Main.panelsHigh));
				return;
			}else if(selectedOption == "pipeLength") {
				Main.pipeLength = Double.parseDouble(input.getText().replaceAll("\"", ""));
				return;
			}else if(selectedOption == "clampWidth") {
				Main.ySpacing = Double.parseDouble(input.getText().replaceAll("\"", ""));
				return;
			}else if(selectedOption == "panelSpace") {
				Main.xSpacing = Double.parseDouble(input.getText().replaceAll("\"", ""));
				return;
			}else if(selectedOption == "railLength") {
				Main.railLength = Double.parseDouble(input.getText().replaceAll("\"", ""));
				return;
			}else if(selectedOption == "arrays") {
			}else if(selectedOption == "railHang") {
				Main.railExcess = Double.parseDouble(input.getText().replaceAll("\"", ""));
				return;
			}else if(selectedOption == "arrays") {
				Main.arrays = (int)Double.parseDouble(input.getText().replaceAll("\"", ""));
				input.setText(""+(int)Main.arrays);
				return;
			}return;
		}
		default:{return;}
		}
	}
	
	private JMenuBar setupJMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		panels = new JMenu("AC-330P/156-72S");
		JMenu options = new JMenu("Options");
		JMenu formats = new JMenu("Formats");
		data = new JMenu("Panel Columns:");
		savedInput = new JMenu();
		savedInput.setIcon(new ImageIcon(getClass().getResource("/check.png")));
		savedInput.setToolTipText("Input is saved");
		input = new JTextField("", 5);
		input.setMaximumSize(new Dimension(80, 40));
		input.setText(""+(int)(Main.panelsWide));
		input.addKeyListener(new KeyAdapter() {
			char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
			@Override
			public void keyTyped(KeyEvent e) {
				if(input.getText().length() >=6 && e.getKeyChar() != KeyEvent.VK_ENTER) {
					e.consume();
					input.setText(input.getText().substring(0, 6));
				}else if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					actionPerformed(new ActionEvent(input, ActionEvent.ACTION_PERFORMED, "inputEntry"));
					savedInput.setIcon(new ImageIcon(getClass().getResource("/check.png")));
					savedInput.setToolTipText("Input is saved");
				}else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
					savedInput.setIcon(new ImageIcon(getClass().getResource("/unsaved.png")));
					savedInput.setToolTipText("An entry has not been saved");
				}else {
					for(char each:chars) {
						if(e.getKeyChar() == each) {
							savedInput.setIcon(new ImageIcon(getClass().getResource("/unsaved.png")));
							savedInput.setToolTipText("An entry has not been saved");
							return;
						}
					}
					e.consume();
				}
			}
		});
		
		JMenuItem run = new JMenuItem("Run");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		run.setActionCommand("run");
		save.setActionCommand("save");
		exit.setActionCommand("exit");
		run.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		JMenu axitecMenu1 = new JMenu("260P-280P/60S");
		ButtonGroup panelOptions = new ButtonGroup();
		JRadioButtonMenuItem axitec260p = new JRadioButtonMenuItem("AC-260P/60S");//size1
		JRadioButtonMenuItem axitec265p = new JRadioButtonMenuItem("AC-265P/60S");
		JRadioButtonMenuItem axitec270p = new JRadioButtonMenuItem("AC-270P/60S");
		JRadioButtonMenuItem axitec275p = new JRadioButtonMenuItem("AC-275P/60S");
		JRadioButtonMenuItem axitec280p = new JRadioButtonMenuItem("AC-280P/60S");
		axitec260p.setActionCommand(size1+"1");
		axitec265p.setActionCommand(size1+"2");
		axitec270p.setActionCommand(size1+"3");
		axitec275p.setActionCommand(size1+"4");
		axitec280p.setActionCommand(size1+"5");
		axitec260p.addActionListener(this);
		axitec265p.addActionListener(this);
		axitec270p.addActionListener(this);
		axitec275p.addActionListener(this);
		axitec280p.addActionListener(this);
		panelOptions.add(axitec260p);
		panelOptions.add(axitec265p);
		panelOptions.add(axitec270p);
		panelOptions.add(axitec275p);
		panelOptions.add(axitec280p);
		axitecMenu1.add(axitec260p);
		axitecMenu1.add(axitec265p);
		axitecMenu1.add(axitec270p);
		axitecMenu1.add(axitec275p);
		axitecMenu1.add(axitec280p);
		panels.add(axitecMenu1);
		
		JMenu axitecMenu2 = new JMenu("260P-270P/60SE");
		JRadioButtonMenuItem axitec260pe = new JRadioButtonMenuItem("AC-260P/156-60SE");//size2
		JRadioButtonMenuItem axitec265pe = new JRadioButtonMenuItem("AC-265P/156-60SE");
		JRadioButtonMenuItem axitec270pe = new JRadioButtonMenuItem("AC-270P/156-60SE");
		axitec260pe.setActionCommand(size2+"1");
		axitec265pe.setActionCommand(size2+"2");
		axitec270pe.setActionCommand(size2+"3");
		axitec260pe.addActionListener(this);
		axitec265pe.addActionListener(this);
		axitec270pe.addActionListener(this);
		panelOptions.add(axitec260pe);
		panelOptions.add(axitec265pe);
		panelOptions.add(axitec270pe);
		axitecMenu2.add(axitec260pe);
		axitecMenu2.add(axitec265pe);
		axitecMenu2.add(axitec270pe);
		panels.add(axitecMenu2);
		
		JMenu axitecMenu3 = new JMenu("270PG-280PG/60S");
		JRadioButtonMenuItem axitec270pg = new JRadioButtonMenuItem("AC-270PG/156-60S");//size3
		JRadioButtonMenuItem axitec275pg = new JRadioButtonMenuItem("AC-275PG/156-60S");
		JRadioButtonMenuItem axitec280pg = new JRadioButtonMenuItem("AC-280PG/156-60S");
		axitec270pg.setActionCommand(size3+"1");
		axitec275pg.setActionCommand(size3+"2");
		axitec280pg.setActionCommand(size3+"3");
		axitec270pg.addActionListener(this);
		axitec275pg.addActionListener(this);
		axitec280pg.addActionListener(this);
		panelOptions.add(axitec270pg);
		panelOptions.add(axitec275pg);
		panelOptions.add(axitec280pg);
		axitecMenu3.add(axitec270pg);
		axitecMenu3.add(axitec275pg);
		axitecMenu3.add(axitec280pg);
		panels.add(axitecMenu3);
		
		JMenu axitecMenu4 = new JMenu("270PH-290PH/60S");
		JRadioButtonMenuItem axitec270ph = new JRadioButtonMenuItem("AC-270PH/60S");//size4
		JRadioButtonMenuItem axitec275ph = new JRadioButtonMenuItem("AC-275PH/60S");
		JRadioButtonMenuItem axitec280ph = new JRadioButtonMenuItem("AC-280PH/60S");
		JRadioButtonMenuItem axitec285ph = new JRadioButtonMenuItem("AC-285PH/60S");
		JRadioButtonMenuItem axitec290ph = new JRadioButtonMenuItem("AC-290PH/60S");
		axitec270ph.setActionCommand(size4+"1");
		axitec275ph.setActionCommand(size4+"2");
		axitec280ph.setActionCommand(size4+"3");
		axitec285ph.setActionCommand(size4+"4");
		axitec290ph.setActionCommand(size4+"5");
		axitec270ph.addActionListener(this);
		axitec275ph.addActionListener(this);
		axitec280ph.addActionListener(this);
		axitec285ph.addActionListener(this);
		axitec290ph.addActionListener(this);
		panelOptions.add(axitec270ph);
		panelOptions.add(axitec275ph);
		panelOptions.add(axitec280ph);
		panelOptions.add(axitec285ph);
		panelOptions.add(axitec290ph);
		axitecMenu4.add(axitec270ph);
		axitecMenu4.add(axitec275ph);
		axitecMenu4.add(axitec280ph);
		axitecMenu4.add(axitec285ph);
		axitecMenu4.add(axitec290ph);
		panels.add(axitecMenu4);
		
		JMenu axitecMenu5 = new JMenu("280MG-300MG/60S");
		JRadioButtonMenuItem axitec280mg = new JRadioButtonMenuItem("AC-280MG/60S");
		JRadioButtonMenuItem axitec285mg = new JRadioButtonMenuItem("AC-285MG/60S");//size3
		JRadioButtonMenuItem axitec290mg = new JRadioButtonMenuItem("AC-290MG/60S");
		JRadioButtonMenuItem axitec295mg = new JRadioButtonMenuItem("AC-295MG/60S");
		JRadioButtonMenuItem axitec300mg = new JRadioButtonMenuItem("AC-300MG/60S");
		axitec280mg.setActionCommand(size3+"4");
		axitec285mg.setActionCommand(size3+"5");
		axitec290mg.setActionCommand(size3+"6");
		axitec295mg.setActionCommand(size3+"7");
		axitec300mg.setActionCommand(size3+"8");
		axitec280mg.addActionListener(this);
		axitec285mg.addActionListener(this);
		axitec290mg.addActionListener(this);
		axitec295mg.addActionListener(this);
		axitec300mg.addActionListener(this);
		panelOptions.add(axitec280mg);
		panelOptions.add(axitec285mg);
		panelOptions.add(axitec290mg);
		panelOptions.add(axitec295mg);
		panelOptions.add(axitec300mg);
		axitecMenu5.add(axitec280mg);
		axitecMenu5.add(axitec285mg);
		axitecMenu5.add(axitec290mg);
		axitecMenu5.add(axitec295mg);
		axitecMenu5.add(axitec300mg);
		panels.add(axitecMenu5);
		
		JMenu axitecMenu6 = new JMenu("280M-310M/60S");
		JRadioButtonMenuItem axitec280m = new JRadioButtonMenuItem("AC-280M/60S");//size1
		JRadioButtonMenuItem axitec285m = new JRadioButtonMenuItem("AC-285M/60S");
		JRadioButtonMenuItem axitec290m = new JRadioButtonMenuItem("AC-290M/60S");
		JRadioButtonMenuItem axitec295m = new JRadioButtonMenuItem("AC-295M/60S");
		JRadioButtonMenuItem axitec300m = new JRadioButtonMenuItem("AC-300M/60S");
		JRadioButtonMenuItem axitec305m = new JRadioButtonMenuItem("AC-305M/60S");
		JRadioButtonMenuItem axitec310m = new JRadioButtonMenuItem("AC-310M/60S");
		axitec280m.setActionCommand(size1+"6");
		axitec285m.setActionCommand(size1+"7");
		axitec290m.setActionCommand(size1+"8");
		axitec295m.setActionCommand(size1+"9");
		axitec300m.setActionCommand(size1+"10");
		axitec305m.setActionCommand(size1+"11");
		axitec310m.setActionCommand(size1+"12");
		axitec280m.addActionListener(this);
		axitec285m.addActionListener(this);
		axitec290m.addActionListener(this);
		axitec295m.addActionListener(this);
		axitec300m.addActionListener(this);
		axitec305m.addActionListener(this);
		axitec310m.addActionListener(this);
		panelOptions.add(axitec280m);
		panelOptions.add(axitec285m);
		panelOptions.add(axitec290m);
		panelOptions.add(axitec295m);
		panelOptions.add(axitec300m);
		panelOptions.add(axitec305m);
		panelOptions.add(axitec310m);
		axitecMenu6.add(axitec280m);
		axitecMenu6.add(axitec285m);
		axitecMenu6.add(axitec290m);
		axitecMenu6.add(axitec295m);
		axitecMenu6.add(axitec300m);
		axitecMenu6.add(axitec305m);
		axitecMenu6.add(axitec310m);
		panels.add(axitecMenu6);
		
		JMenu axitecMenu7 = new JMenu("310P-330P/72S");
		JRadioButtonMenuItem axitec310p = new JRadioButtonMenuItem("AC-310P/72S");//size5
		JRadioButtonMenuItem axitec315p = new JRadioButtonMenuItem("AC-315P/72S");
		JRadioButtonMenuItem axitec320p = new JRadioButtonMenuItem("AC-320P/72S");
		JRadioButtonMenuItem axitec325p = new JRadioButtonMenuItem("AC-325P/72S");
		JRadioButtonMenuItem axitec330p = new JRadioButtonMenuItem("AC-330P/72S");
		axitec310p.setActionCommand(size5+"1");
		axitec315p.setActionCommand(size5+"2");
		axitec320p.setActionCommand(size5+"3");
		axitec325p.setActionCommand(size5+"4");
		axitec330p.setActionCommand(size5+"5");
		axitec310p.addActionListener(this);
		axitec315p.addActionListener(this);
		axitec320p.addActionListener(this);
		axitec325p.addActionListener(this);
		axitec330p.addActionListener(this);
		panelOptions.add(axitec310p);
		panelOptions.add(axitec315p);
		panelOptions.add(axitec320p);
		panelOptions.add(axitec325p);
		panelOptions.add(axitec330p);
		axitecMenu7.add(axitec310p);
		axitecMenu7.add(axitec315p);
		axitecMenu7.add(axitec320p);
		axitecMenu7.add(axitec325p);
		axitecMenu7.add(axitec330p);
		panels.add(axitecMenu7);
		
		JMenu axitecMenu8 = new JMenu("310MH-325MH/60S");
		JRadioButtonMenuItem axitec310mh = new JRadioButtonMenuItem("AC-310MH/60S");//size4
		JRadioButtonMenuItem axitec315mh = new JRadioButtonMenuItem("AC-315MH/60S");
		JRadioButtonMenuItem axitec320mh = new JRadioButtonMenuItem("AC-320MH/60S");
		JRadioButtonMenuItem axitec325mh = new JRadioButtonMenuItem("AC-325MH/60S");
		axitec310mh.setActionCommand(size4+"6");
		axitec315mh.setActionCommand(size4+"7");
		axitec320mh.setActionCommand(size4+"8");
		axitec325mh.setActionCommand(size4+"9");
		axitec310mh.addActionListener(this);
		axitec315mh.addActionListener(this);
		axitec320mh.addActionListener(this);
		axitec325mh.addActionListener(this);
		panelOptions.add(axitec310mh);
		panelOptions.add(axitec315mh);
		panelOptions.add(axitec320mh);
		panelOptions.add(axitec325mh);
		axitecMenu8.add(axitec310mh);
		axitecMenu8.add(axitec315mh);
		axitecMenu8.add(axitec320mh);
		axitecMenu8.add(axitec325mh);
		panels.add(axitecMenu8);
		
		JMenu axitecMenu9 = new JMenu("320P-330P/156-72S");
		JRadioButtonMenuItem axitec320p2 = new JRadioButtonMenuItem("AC-320P/156-72S");//size5
		JRadioButtonMenuItem axitec325p2 = new JRadioButtonMenuItem("AC-325P/156-72S");
		JRadioButtonMenuItem axitec330p2 = new JRadioButtonMenuItem("AC-330P/156-72S");
		axitec320p2.setActionCommand(size5+"6");
		axitec325p2.setActionCommand(size5+"7");
		axitec330p2.setActionCommand(size5+"8");
		axitec320p2.addActionListener(this);
		axitec325p2.addActionListener(this);
		axitec330p2.addActionListener(this);
		panelOptions.add(axitec320p2);
		panelOptions.add(axitec325p2);
		panelOptions.add(axitec330p2);
		axitecMenu9.add(axitec320p2);
		axitecMenu9.add(axitec325p2);
		axitecMenu9.add(axitec330p2);
		panels.add(axitecMenu9);
		
		JMenu axitecMenu10 = new JMenu("330M-350M/156-72S");
		JRadioButtonMenuItem axitec330m = new JRadioButtonMenuItem("AC-330M/156-72S");//size5
		JRadioButtonMenuItem axitec335m = new JRadioButtonMenuItem("AC-335M/156-72S");
		JRadioButtonMenuItem axitec340m = new JRadioButtonMenuItem("AC-340M/156-72S");
		JRadioButtonMenuItem axitec345m = new JRadioButtonMenuItem("AC-345M/156-72S");
		JRadioButtonMenuItem axitec350m = new JRadioButtonMenuItem("AC-350M/156-72S");
		axitec330m.setActionCommand(size5+"9");
		axitec335m.setActionCommand(size5+"10");
		axitec340m.setActionCommand(size5+"11");
		axitec345m.setActionCommand(size5+"12");
		axitec350m.setActionCommand(size5+"13");
		axitec330m.addActionListener(this);
		axitec335m.addActionListener(this);
		axitec340m.addActionListener(this);
		axitec345m.addActionListener(this);
		axitec350m.addActionListener(this);
		panelOptions.add(axitec330m);
		panelOptions.add(axitec335m);
		panelOptions.add(axitec340m);
		panelOptions.add(axitec345m);
		panelOptions.add(axitec350m);
		axitecMenu10.add(axitec330m);
		axitecMenu10.add(axitec335m);
		axitecMenu10.add(axitec340m);
		axitecMenu10.add(axitec345m);
		axitecMenu10.add(axitec350m);
		panels.add(axitecMenu10);
		
		JMenu axitecMenu11 = new JMenu("350M-360M/72S");
		JRadioButtonMenuItem axitec350m2 = new JRadioButtonMenuItem("AC-350M/72S");//size5
		JRadioButtonMenuItem axitec355m2 = new JRadioButtonMenuItem("AC-355M/72S");
		JRadioButtonMenuItem axitec360m2 = new JRadioButtonMenuItem("AC-360M/72S");
		axitec350m2.setActionCommand(size5+"14");
		axitec355m2.setActionCommand(size5+"15");
		axitec360m2.setActionCommand(size5+"16");
		axitec350m2.addActionListener(this);
		axitec355m2.addActionListener(this);
		axitec360m2.addActionListener(this);
		panelOptions.add(axitec350m2);
		panelOptions.add(axitec355m2);
		panelOptions.add(axitec360m2);
		axitecMenu11.add(axitec350m2);
		axitecMenu11.add(axitec355m2);
		axitecMenu11.add(axitec360m2);
		panels.add(axitecMenu11);
		
		axitec330p2.setSelected(true);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		CustomCheckBoxMenuItem vBraces = new CustomCheckBoxMenuItem("VBraces");
		vBraces.setActionCommand("vBraces");
		vBraces.addActionListener(this);
		vBraces.setSelected(true);
		ButtonGroup pipeSize = new ButtonGroup();
		CustomRadioButtonMenuItem pipe1_5 = new CustomRadioButtonMenuItem("1.5\"");
		CustomRadioButtonMenuItem pipe2 = new CustomRadioButtonMenuItem("2\"");
		pipe1_5.setActionCommand("pipe1_5");
		pipe2.setActionCommand("pipe2");
		pipe1_5.addActionListener(this);
		pipe2.addActionListener(this);
		pipeSize.add(pipe1_5);
		pipeSize.add(pipe2);
		pipe1_5.setSelected(true);
		ButtonGroup pipeSchedule = new ButtonGroup();
		CustomRadioButtonMenuItem sch40 = new CustomRadioButtonMenuItem("Sch. 40");
		CustomRadioButtonMenuItem sch80 = new CustomRadioButtonMenuItem("Sch. 80");
		sch40.setActionCommand("sch40");
		sch80.setActionCommand("sch80");
		sch40.addActionListener(this);
		sch80.addActionListener(this);
		pipeSchedule.add(sch40);
		pipeSchedule.add(sch80);
		sch40.setSelected(true);
		ButtonGroup formatGroup = new ButtonGroup();
		CustomRadioButtonMenuItem feetInch = new CustomRadioButtonMenuItem("10' 6.5\"");
		CustomRadioButtonMenuItem justInch = new CustomRadioButtonMenuItem("126.5\"");
		CustomRadioButtonMenuItem feetInchW1 = new CustomRadioButtonMenuItem("63/64ths");
		CustomRadioButtonMenuItem feetInchW2 = new CustomRadioButtonMenuItem("31/32nds");
		CustomRadioButtonMenuItem feetInchW3 = new CustomRadioButtonMenuItem("15/16ths");
		CustomRadioButtonMenuItem feetInchW4 = new CustomRadioButtonMenuItem("7/8ths");
		JMenu feetInchW = new JMenu("10ft, 6 1/2in");
		feetInch.setActionCommand("feetInch");
		justInch.setActionCommand("justInch");
		feetInchW1.setActionCommand("feetInchW1");
		feetInchW2.setActionCommand("feetInchW2");
		feetInchW3.setActionCommand("feetInchW3");
		feetInchW4.setActionCommand("feetInchW4");
		feetInch.addActionListener(this);
		justInch.addActionListener(this);
		feetInchW1.addActionListener(this);
		feetInchW2.addActionListener(this);
		feetInchW3.addActionListener(this);
		feetInchW4.addActionListener(this);
		formatGroup.add(feetInch);
		formatGroup.add(justInch);
		formatGroup.add(feetInchW1);
		formatGroup.add(feetInchW2);
		formatGroup.add(feetInchW3);
		formatGroup.add(feetInchW4);
		feetInchW.add(feetInchW1);
		feetInchW.add(feetInchW2);
		feetInchW.add(feetInchW3);
		feetInchW.add(feetInchW4);
		feetInch.setSelected(true);
		
		ButtonGroup dataOptions = new ButtonGroup();
		CustomRadioButtonMenuItem panelsWide = new CustomRadioButtonMenuItem("Panel Columns");
		panelsWide.setSelected(true);
		CustomRadioButtonMenuItem panelsHigh = new CustomRadioButtonMenuItem("Panel Rows");
		CustomRadioButtonMenuItem pipeLength = new CustomRadioButtonMenuItem("Pipe Length");
		CustomRadioButtonMenuItem clampWidth = new CustomRadioButtonMenuItem("Clamp Width");
		CustomRadioButtonMenuItem panelSpacing = new CustomRadioButtonMenuItem("Panel Space");//How many pipes to be divided into posts + vbraces, how many into crossbraces + vbraces, etc. Need to add this into calcs. 
		CustomRadioButtonMenuItem railLength = new CustomRadioButtonMenuItem("Rail Length");
		CustomRadioButtonMenuItem railProtrusion = new CustomRadioButtonMenuItem("Rail Overhang");
		CustomRadioButtonMenuItem arrays = new CustomRadioButtonMenuItem("Arrays");
		panelsWide.setActionCommand("panelsWide");
		panelsHigh.setActionCommand("panelsHigh");
		pipeLength.setActionCommand("pipeLength");
		clampWidth.setActionCommand("clampWidth");
		panelSpacing.setActionCommand("panelSpace");
		railLength.setActionCommand("railLength");
		railProtrusion.setActionCommand("railHang");
		arrays.setActionCommand("arrays");
		panelsWide.addActionListener(this);
		panelsHigh.addActionListener(this);
		pipeLength.addActionListener(this);
		clampWidth.addActionListener(this);
		panelSpacing.addActionListener(this);
		railLength.addActionListener(this);
		railProtrusion.addActionListener(this);
		arrays.addActionListener(this);
		dataOptions.add(panelsWide);
		dataOptions.add(panelsHigh);
		dataOptions.add(pipeLength);
		dataOptions.add(clampWidth);
		dataOptions.add(panelSpacing);
		dataOptions.add(railLength);
		dataOptions.add(railProtrusion);
		dataOptions.add(arrays);
		
		data.add(panelsWide);
		data.add(panelsHigh);
		data.add(pipeLength);
		data.add(clampWidth);
		data.add(panelSpacing);
		data.add(railLength);
		data.add(railProtrusion);
		data.add(arrays);
		
		options.add(vBraces);
		formats.add(feetInch);
		formats.add(justInch);
		formats.add(feetInchW);
		options.add(formats);
		options.add(pipe1_5);
		options.add(pipe2);
		options.add(sch40);
		options.add(sch80);
		
		file.add(run);
		file.add(save);
		file.add(exit);
		
		bar.add(file);
		bar.add(panels);
		bar.add(options);
		bar.add(data);
		bar.add(input);
		bar.add(savedInput);
		
		return bar;
	}

	
	private void saveOutput() {
		File path = new File(System.getProperty("user.dir")+File.separator+"Output_"+getTime()+".txt");
		FileOutputStream out;
		try {
			out = new FileOutputStream(path.getAbsolutePath());
			out.write(output.getText().getBytes());
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static String getTime() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		year -= 2000;
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int minute = Calendar.getInstance().get(Calendar.MINUTE);
		int second = Calendar.getInstance().get(Calendar.SECOND);
		return month+"-"+day+"-"+year+"_"+hour+"-"+minute+"-"+second;
	}
}