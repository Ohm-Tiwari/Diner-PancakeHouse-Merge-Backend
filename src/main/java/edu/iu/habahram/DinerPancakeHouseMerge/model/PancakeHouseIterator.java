package edu.iu.habahram.DinerPancakeHouseMerge.model;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseIterator implements Iterator {

    ArrayList<String> items;
    int position = 0;

    public PancakeHouseIterator(ArrayList<String> items) {
        this.items = items;
    }

    public String next() {
        String menuItem = (String) items.get(position);
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        } else {
            return true;
        }
    }
}
