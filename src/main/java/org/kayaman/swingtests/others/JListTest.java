package org.kayaman.swingtests.others;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.ScrollPane;

public class JListTest extends JFrame {

    private final JList<ItemInventoryEntry> items;

    public JListTest() {
        items = new JList<>();
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_NEVER);
        scrollPane.add(items);
        setSize(400, 400);
        setVisible(true);
        getContentPane().add(scrollPane);
        setLocationRelativeTo(null);
        validate();
    }
}
