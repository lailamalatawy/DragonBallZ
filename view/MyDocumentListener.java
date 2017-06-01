package dragonball.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

class MyDocumentListener implements DocumentListener {

    private JLabel targetComponent;

    public MyDocumentListener(JLabel component) {
        this.targetComponent = component;
    }

    private void update(DocumentEvent e) {
        try {
            targetComponent.setText(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        update(e);
    } 
}
