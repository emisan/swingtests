package org.kayaman.swingtests.others;

import org.kayaman.swingtests.utils.SpriteLoader;

import javax.swing.JList;
import javax.swing.JWindow;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JListTest extends JWindow implements KeyListener {

    private JList<ItemInventoryEntry> items;
    private transient ItemInventoryHandler itemInventoryHandler;
    private ScrollPane scrollPane;
    int visibilityCounter;

    public JListTest() {
        visibilityCounter = 0;
        initList();
        setSize(400, 400);
        setVisible(true);
        getContentPane().add(scrollPane);
        setLocationRelativeTo(null);
        setOpacity(0.8f);
        addKeyListener(this);
        validate();
    }

    private void initList() {
        itemInventoryHandler = new ItemInventoryHandler();
        fillList();
        scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_NEVER);
        scrollPane.add(items);
    }

    private void fillList() {
        itemInventoryHandler.addToInventory(new DoorKey("Blue Key", SpriteLoader.getSprite("blue_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Red Key", SpriteLoader.getSprite("red_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Yellow Key", SpriteLoader.getSprite("yellow_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Green Key", SpriteLoader.getSprite("green_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Blue Key", SpriteLoader.getSprite("blue_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Red Key", SpriteLoader.getSprite("red_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Yellow Key", SpriteLoader.getSprite("yellow_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Green Key", SpriteLoader.getSprite("green_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Blue Key", SpriteLoader.getSprite("blue_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Red Key", SpriteLoader.getSprite("red_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Yellow Key", SpriteLoader.getSprite("yellow_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Green Key", SpriteLoader.getSprite("green_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Blue Key", SpriteLoader.getSprite("blue_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Red Key", SpriteLoader.getSprite("red_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Yellow Key", SpriteLoader.getSprite("yellow_key.png")));
        itemInventoryHandler.addToInventory(new DoorKey("Green Key", SpriteLoader.getSprite("green_key.png")));
        final ItemInventoryListModel model = new ItemInventoryListModel();
        itemInventoryHandler.getInventory().forEach(model::add);
//                        item.getItemName() + "\nAmount" + item.getAmount(),
//                        new ImageIcon(item.getGameObject().getImage())));
        items = new JList<>(model);
        items.setCellRenderer(new ItemInventoryRenderer());
        items.setBackground(Color.BLACK);
        items.setForeground(Color.WHITE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing to do yet
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_I && visibilityCounter == 0) {
            this.setVisible(true);
            visibilityCounter++;
        }
        else if (e.getKeyCode() == KeyEvent.VK_I && visibilityCounter == 1) {
            visibilityCounter = 0;
            this.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // nothing to do yet
    }
}
