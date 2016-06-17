package net.bearfather.Scheduler;

import java.awt.*;
import java.awt.print.*;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;

class PrintForm implements Printable{
	private Component what;
	
	PrintForm(Component what){
		this.what=what;
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintRequestAttributeSet prop = new HashPrintRequestAttributeSet();
        prop.add(OrientationRequested.LANDSCAPE);
        prop.add(new MediaPrintableArea(0.0f,0.0f,8.75f,11.0f,MediaPrintableArea.INCH));
    	PageFormat pf = job.defaultPage();
        job.setPrintable(this, pf);
        boolean ok = job.printDialog(prop);
        if (ok) {
            try {job.print(prop);} 
            catch (PrinterException ex) {JOptionPane.showMessageDialog(what, "There was an error printing!", "Printer error", JOptionPane.ERROR_MESSAGE);}
        }
	}
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
            if (page > 0) {return Printable.NO_SUCH_PAGE;}
            Dimension d = what.getSize();
            double ch = d.getHeight();
            double cw = d.getWidth();
            double ph = pf.getImageableHeight();
            double pw = pf.getImageableWidth();
            double px = pf.getImageableX();
            double py = pf.getImageableY();
            double x = pw / cw;
            double y = ph / ch;
            Graphics2D g2 = (Graphics2D) g;
            g2.translate(px, py);
            if (pf.getOrientation()==1){y=y/2;}//land=0 port=1
            g2.scale(x, y);
            what.printAll(g2);
            return Printable.PAGE_EXISTS;
    }
}
