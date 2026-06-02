package org.kayaman.swingtests.others;

import lombok.NonNull;

import javax.swing.DefaultListModel;

public class ItemInventoryListModel extends DefaultListModel<ItemInventoryEntry> {

    public void add(@NonNull final ItemInventoryEntry entry) {
        super.addElement(entry);
    }
}
