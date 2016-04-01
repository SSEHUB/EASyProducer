
package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AuthorizeButton extends JButton {

	private static final long serialVersionUID = -5747868174847160408L;

	public AuthorizeButton() {
		Icon icon = new ImageIcon(getClass().getResource("../../key.gif"));
		setIcon(icon);
		addActionListener(new AuthorizeButtonListener());
	}
	
	
	private class AuthorizeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int result = Integer.valueOf(JOptionPane.showInputDialog(null,
						"Geben sie Ihre Authorisierungstufe ein!\n"
								+ "(Stufe/n: 0-keine Authorisierung\n"
								+ "sonst: 1-7: Schutzbereiche)"));
				if (result < 0 || result > 7) {
					JOptionPane.showMessageDialog(null, "Ungültige Sicherheitsstufe", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {

			}
		}
		
	}
}