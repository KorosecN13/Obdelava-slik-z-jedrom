import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class GlavnoOkno extends JFrame implements ActionListener {

	private OriginalnoPlatno prvotnaSlika;
	private UstvarjalnoPlatno krogciSlika;
	private JMenuItem odpriSlikoMenu;
	private JMenuItem krogciMenu;

	public GlavnoOkno() throws HeadlessException {
		super();
		this.setTitle("Program�ek");
		this.setLayout(new GridBagLayout());
	
//		JPanel container = new JPanel();
//		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
//
//		JPanel panel1 = new OriginalnoPlatno();
//		JPanel panel2 = new UstvarjalnoPlatno();
//
//		panel1.setSize(400, 320);
//		panel2.setSize(300, 450);
//		
////		panel1.setVisible(True);
////		panel2.setVisible(True);
////		
////		
//
//		container.add(panel1);
//		container.add(panel2);
//		
//		panel1.setVisible(true);
//		panel2.setVisible(true);
//		
//		

		prvotnaSlika = new OriginalnoPlatno();
		this.getContentPane().add(prvotnaSlika);
		krogciSlika = new UstvarjalnoPlatno();
		this.getContentPane().add(krogciSlika);
		
		// Dodamo menu
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		this.odpriSlikoMenu = new JMenuItem("Odpri", KeyEvent.VK_O);
		menuBar.add(odpriSlikoMenu);
		this.krogciMenu = new JMenuItem("Krogci", KeyEvent.VK_K);
		menuBar.add(krogciMenu);

		
		this.odpriSlikoMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.ALT_MASK));
		this.getOdpriMenu().addActionListener(this);
	
		this.krogciMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_K, ActionEvent.ALT_MASK));
		this.getKrogciMenu().addActionListener(this);
		
//		// Dodamo opcijo Krogci
//		JMenuBar menuBar1 = new JMenuBar();
//		this.setJMenuBar(menuBar1);
//		this.krogciMenu = new JMenuItem("Krogci", KeyEvent.VK_K);
//		menuBar1.add(krogciMenu);
//
//		this.krogciMenu.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_K, ActionEvent.ALT_MASK));
//		this.getZbrisiMenu().addActionListener(this.platno);
		

	}

	private JMenuItem getOdpriMenu() {
		return this.odpriSlikoMenu;
	}
	
	private JMenuItem getKrogciMenu() {
		return this.krogciMenu;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getOdpriMenu()) {
			final JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
				    BufferedImage img = ImageIO.read(fc.getSelectedFile());
				    prvotnaSlika.setSlika(img);
				} catch (IOException exc) {
				}
			}
		}
		else if (e.getSource() == getKrogciMenu()) {	
		}
	}
}