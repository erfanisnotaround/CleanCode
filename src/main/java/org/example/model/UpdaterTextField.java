package org.example.model;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdaterTextField extends JTextField {
    private Supplier<String> initialTextSupplier;
    private Consumer<String> onTextChanged;
    public UpdaterTextField() {
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }
            private void update() {
                if (initialTextSupplier != null) {
                    initialTextSupplier.get();
                }
            }
        });
    }

//    public Supplier<String> getInitialTextSupplier() {
//        return initialTextSupplier;
//    }

    public void setInitialTextSupplier(Supplier<String> initialTextSupplier) {
        this.initialTextSupplier = initialTextSupplier;
    }

    public void setOnTextChanged(Consumer<String> onTextChanged) {
        this.onTextChanged = onTextChanged;
    }
//    public UpdaterTextField() {
//        super();
//    }
}
