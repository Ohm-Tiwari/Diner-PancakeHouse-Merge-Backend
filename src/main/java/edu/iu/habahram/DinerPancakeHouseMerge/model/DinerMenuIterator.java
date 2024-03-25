package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.awt.*;
import java.util.Iterator;

public class DinerMenuIterator implements Iterator {

    MenuItem[] MenuItems;

    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItem){ this.MenuItems = menuItems;}

    public MenuItem next(){
        return null;
    }

    @Override
    public boolean hasNext(){
        if(position. )
    }

    public void remove(){
        if(position <= 0){
            throw new IllegalArgumentException("Cannot remove item");
        }
        if(MenuItems[position - 1] != null){
            for (int i = position - 1; i < (MenuItems.length - 1); i++) {
                MenuItems[i] = MenuItems[i + 1];
            }
            MenuItems[MenuItems.length - 1] = null;

        }
    }



}
