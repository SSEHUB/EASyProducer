// just a placeholder taken from SVNControl

/*
 * SVNControl - remote administration of a subversion (SVN) repository server
 * Copyright (C) 2007  Frank Fischer, Felix Gelpke, Thomas Skowron
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

import static gui.MessageConstant.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class BenutzerrechteTab extends FrameParentComponentListenerPanel {

    public static final String CONF_NAME = 
        BenutzerrechteTab.class.getSimpleName().toLowerCase();
    
    private BenutzerrechteTab(JFrame parent, Client client) {
        super(parent);
    }

    static void create(JFrame parent, JTabbedPane tabs, 
        Client client) {
        tabs.add(MAINTAB_PERMISSIONS.format(), 
            new BenutzerrechteTab(parent, client));
    }

}
