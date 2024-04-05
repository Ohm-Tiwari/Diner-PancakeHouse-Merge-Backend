package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergerRepository {


    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    private MenuItemRecord createMenuItemRecord(MenuItem menuItem) {
        return new MenuItemRecord(
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.isVegetarian(),
                menuItem.getPrice()
        );
    }

    public List<MenuItemRecord> getVeg() {
        MenuComponent allMenus = new Menu("ALL VEG MENUS", "All vegetarian combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> vegetarianItems = new ArrayList<>();
        CompositeIterator iterator = new CompositeIterator(allMenus.createIterator());

        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent.isVegetarian()) {
                MenuItem menuItem = (MenuItem) menuComponent;
                MenuItemRecord menuItemRecord = new MenuItemRecord(
                        menuItem.getName(),
                        menuItem.getDescription(),
                        menuItem.isVegetarian(),
                        menuItem.getPrice()
                );
                vegetarianItems.add(menuItemRecord);
            }
        }
        return vegetarianItems;
    }

    public List<MenuItemRecord> getBreakfast() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast");
        MenuItem[] breakfastItems = pancakeHouseMenu.getItems();

        return Arrays.stream(breakfastItems)
                .map(this::createMenuItemRecord)
                .toList();
    }

    public List<MenuItemRecord> getLunch() {
        DinerMenu dinerMenu = new DinerMenu("DINER MENU", "Lunch");
        MenuItem[] lunchItems = dinerMenu.getItems();

        return Arrays.stream(lunchItems)
                .map(this::createMenuItemRecord)
                .toList();
    }

    public List<MenuItemRecord> getSupper() {
        CafeMenu cafeMenu = new CafeMenu("CAFE MENU", "Dinner");
        MenuItem[] dinnerItems = cafeMenu.getItems();

        return Arrays.stream(dinnerItems)
                .map(this::createMenuItemRecord)
                .toList();
    }

    public List signup(String username, String password){
        return null;

    }


}