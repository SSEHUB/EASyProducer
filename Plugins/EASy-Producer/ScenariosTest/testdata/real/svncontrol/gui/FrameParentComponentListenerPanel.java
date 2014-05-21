/*
 * SVNControl - remote administration of a subversion (SVN) repository server
 * Copyright (C) 2007  Holger Eichelberger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package gui;

import java.awt.Component;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class FrameParentComponentListenerPanel extends Component {

    private JFrame frameParent;
    
    public FrameParentComponentListenerPanel(JFrame frameParent) {
        this.frameParent = frameParent;
    }
    
    protected JFrame getFrameParent() {
        return frameParent;
    }
    
}
