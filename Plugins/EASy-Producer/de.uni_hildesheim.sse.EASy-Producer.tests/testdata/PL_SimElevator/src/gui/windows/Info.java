package gui.windows;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Erstellt ein neues Fenster und zeigt Hilfefenster an
 * 
 */
public class Info extends JFrame{

	private static final long serialVersionUID = -2877239181330984931L;

	/**
	 * Konstruktor der Klasse Info
	 */
	public Info(String title, String url) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 550);
		setResizable(false);

		setLocation(400, 200);
		JEditorPane jep = new JEditorPane();
		try {
			jep = new JEditorPane(getClass().getResource(url));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JScrollPane scroller = new JScrollPane(jep,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setBackground(Color.WHITE);
		jep.setEditable(false);

		add(scroller);
		validate();
		repaint();
	}
}
