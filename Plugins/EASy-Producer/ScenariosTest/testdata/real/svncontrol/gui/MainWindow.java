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

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import tools.Tools;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    
    private JTabbedPane tabs = new JTabbedPane();
    
    public MainWindow(Client client) {
        // init

        // Create and add tabs (in constructor)
        // ugly construct to check if the tabs are hidden
        List<String> tabList = client.getHiddenTabs();
        if (!tabList.contains(RepositoryTab.CONF_NAME)) {
            RepositoryTab.create(this, tabs, client);
        }
        if (!tabList.contains(BenutzerTab.CONF_NAME)) {
            BenutzerTab.create(this, tabs, client);
        }
        if (!tabList.contains(GroupTab.CONF_NAME)) {
            GroupTab.create(this, tabs, client);
        }
        if (!tabList.contains(BenutzerrechteTab.CONF_NAME)) {
            BenutzerrechteTab.create(this, tabs, client);
        } 
        if (!tabList.contains(ScheduleTab.CONF_NAME)) {
            ScheduleTab.create(this, tabs, client);
        } 
        if (!tabList.contains(HooksTab.CONF_NAME)) {
            HooksTab.create(this, tabs, client);
        }
        
        // CreditTab
        
        Container pane = this.getContentPane();
        pane.add(tabs);

        pack();
        Dimension defaultDimension = new Dimension(900, 600);
        setMinimumSize(defaultDimension);
        setPreferredSize(defaultDimension); 
        setSize(defaultDimension);
        Tools.center(this);

        // set title, add window listener
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
}
