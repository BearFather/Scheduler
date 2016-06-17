package net.bearfather.Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Toolkit;

class NotesFrame extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextPane textPane = new JTextPane();
	private JButton btnOk = new JButton("Ok");
	private int pane;
	NotesFrame(int pane) {
		this.pane=pane;
		setupPanel();
		String note=Scheduler.notes.get(pane);
		if (!note.equals("0")){textPane.setText(note);}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnOk)){
			Scheduler.notes.put(pane,textPane.getText());
			this.setVisible(false);
		}
	}
	private void setupPanel(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(NotesFrame.class.getResource("/res/icon.png")));
		setTitle("Notes");
		getContentPane().setLayout(null);
		
		textPane.setBounds(10, 11, 414, 199);
		getContentPane().add(textPane);
		
		btnOk.setBounds(173, 227, 89, 23);
		btnOk.addActionListener(this);
		getContentPane().add(btnOk);
		this.setSize(449,298);
		this.setVisible(true);
		
	}
}
