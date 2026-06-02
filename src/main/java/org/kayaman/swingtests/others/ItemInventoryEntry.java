package org.kayaman.swingtests.others;

import lombok.NonNull;

public class ItemInventoryEntry {

    private String itemName;
    private int amount;
    private GameObject gameObject;

    public ItemInventoryEntry(final int amount, @NonNull final GameObject gameObject) {
        this.amount = amount;
        this.gameObject = gameObject;
        this.itemName = gameObject.getItemName();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(@NonNull final String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(@NonNull final GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
