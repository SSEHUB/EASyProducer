package gui.views.inside.displays;

import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

import properties.ProgramSettings;

public class FloorChainDisplay extends JSlider {
	
	private static final long serialVersionUID = 841340392425621437L;

	public FloorChainDisplay() {
		super(0, ProgramSettings.FLOORS, 0);
		init();
	}
	
	private void init() {
		setPaintTrack(false);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>(this.getMaximum());
		JLabel nn;
		for (int i = 0; i < this.getMaximum(); i++) {
			nn = new JLabel("" + i);
			
			labelTable.put(i, nn);
		}
		this.setLabelTable(labelTable);
		this.setPaintLabels(true);
		this.setOpaque(false);
	}
}