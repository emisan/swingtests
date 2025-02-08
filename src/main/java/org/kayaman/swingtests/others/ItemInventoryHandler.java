package org.kayaman.swingtests.others;

import lombok.NonNull;
import javax.annotation.CheckForNull;
import java.util.ArrayList;
import java.util.List;

public class ItemInventoryHandler {

    private static final int INCREMENT_AMOUNT = 1;
    private final List<ItemInventoryEntry> inventory;

    public ItemInventoryHandler() {
        inventory = new ArrayList<>();
    }

    public void addToInventory(@NonNull final GameObject gameObject) {
        final ItemInventoryEntry entry = inventory.stream()
                .filter(obj -> gameObject.getItemName().equalsIgnoreCase(obj.getItemName()))
                .findFirst().orElse(null);
        if (entry == null) {
            inventory.add(new ItemInventoryEntry(gameObject.getItemName(), INCREMENT_AMOUNT, gameObject));
        }
        else {
            entry.setAmount(entry.getAmount() + INCREMENT_AMOUNT);
        }
    }

    @CheckForNull
    public ItemInventoryEntry getGameObjectsBy(@NonNull final String objectName) {
        final ItemInventoryEntry entry =
                inventory.stream().filter(obj -> objectName.equalsIgnoreCase(obj.getItemName())).findFirst()
                        .orElse(null);
        if (entry != null) {
            return entry;
        }
        return null;
    }

    public List<ItemInventoryEntry> getInventory() {
        return inventory;
    }
}
