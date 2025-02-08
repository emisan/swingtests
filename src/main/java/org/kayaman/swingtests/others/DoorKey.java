package org.kayaman.swingtests.others;

import lombok.NonNull;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class DoorKey implements GameObject {

    private final String itemName;
    private final BufferedImage image;

    public DoorKey(@NonNull final String itemName,
                   @NonNull final BufferedImage image)
    {
        this.itemName = itemName;
        this.image = image;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
