package org.kayaman.swingtests.others;

import org.kayaman.swingtests.utils.SpriteLoader;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JWindow;
import java.awt.ScrollPane;

public class JLabelTest extends JWindow {

    public JLabelTest() {

        final JList<JLabel> labels = new JList<>();
        final DefaultListModel<JLabel> model = new DefaultListModel<>();
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("blue_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("red_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("green_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("yellow_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("blue_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("red_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("green_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("yellow_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("blue_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("red_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("green_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("yellow_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("blue_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("red_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("green_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("yellow_key.png"))));model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("blue_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("red_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("green_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("yellow_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("blue_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("red_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("green_key.png"))));
        model.addElement(new JLabel(
                new ImageIcon(SpriteLoader.getSprite("yellow_key.png"))));
        labels.setModel(model);
        final JList<JPanel> panels = new JList<>();

        for (int i = 0; i < labels.getModel().getSize(); i++) {
            panels.add(new JPanel().add(labels.getModel().getElementAt(i)));
        }
        final ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
        scrollPane.add(panels);
        getContentPane().add(scrollPane);
        setSize(200, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        validate();
    }
}
