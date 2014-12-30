package examProject.ui.print;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;

public class Printer implements Printable, ActionListener {
	JFrame frameToPrint = new JFrame();

	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {
		if (page > 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		frameToPrint.printComponents(g);
		return PAGE_EXISTS;
	}

	public void actionPerformed(ActionEvent e) {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(this);
		boolean result = pj.printDialog();
		if (result) {
			try {
				pj.print();
			} catch (PrinterException ex) {
			}
		}
	}

	public Printer(JFrame f) {
		frameToPrint = f;
	}
}