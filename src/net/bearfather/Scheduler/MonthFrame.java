package net.bearfather.Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

class MonthFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame frame=new JFrame(); // NO_UCD (unused code)
	private DefaultTableModel model = new DefaultTableModel(null, new Object[]{"ID", "Name","Category","Type","Hrs"}){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {return false;};
		}; 
	private JTable table = new JTable(model)	; 

	public MonthFrame(){
		setupPanel();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		}
	
	private void fillRow(){
		model.setRowCount(0);
		int thrs=0;
		for (Job job:Scheduler.availJobs.values()){
			if (job.getMonth()[Scheduler.cf.cbmonth.getSelectedIndex()]==1){
				String id=job.getId();
				String name=job.getName();
				String cat=job.sCat();
				String type=job.sType();
				int hrs=job.getLength();
				thrs=thrs+hrs;
				model.addRow(new Object[]{id,name,cat,type,hrs});
			}

		}
		setTitle("Total Hrs: "+thrs);
	}

	@SuppressWarnings("serial")
	private void setupPanel(){
		getContentPane().setLayout(null);
		setTitle("Total Hrs: 0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MonthFrame.class.getResource("/res/icon.png")));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 406, 320);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 402, 314);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setOpaque(false);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {//System.out.println(table.getModel().getValueAt(row, 0));
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        String chk=table.getModel().getValueAt(row, 0).toString();
		        if (chk.equals("*")){
		        	c.setBackground(Color.YELLOW);
		        }else if(row % 2 == 0){
			        c.setBackground(Color.LIGHT_GRAY);
		        }else{c.setBackground(Color.WHITE);}
		        return c;
		    }
		});
		fillRow();
		this.setSize(417,352);
		this.setVisible(true);
		
	}
}
