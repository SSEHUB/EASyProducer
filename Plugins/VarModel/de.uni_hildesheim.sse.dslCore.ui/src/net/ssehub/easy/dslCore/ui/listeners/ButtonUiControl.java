/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.dslCore.ui.listeners;

import org.eclipse.swt.widgets.Button;

/**
 * Implements a UI control class for {@link Button}.
 * 
 * @author Holger Eichelberger
 */
public class ButtonUiControl implements IControl {

    private Button button;
    private String initialText;
    
    /**
     * Creates a button UI control.
     * 
     * @param button the button
     */
    public ButtonUiControl(Button button) {
        this.button = button;
        this.initialText = button.getText();
    }

    @Override
    public void setEnabled(IAggregatableListener key, final boolean enabled) {
        if (!button.isDisposed()) {
            button.getDisplay().asyncExec(new Runnable() {
    
                @Override
                public void run() {
                    Button button = ButtonUiControl.this.button;
                    button.setEnabled(enabled);
                    if (enabled) {
                        button.setText(ButtonUiControl.this.initialText);
                    } else {
                        button.setText("Loading...");
                    }
                }
                
            });
        }
    }

}
