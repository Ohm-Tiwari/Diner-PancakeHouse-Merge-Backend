package edu.iu.habahram.DinerPancakeHouseMerge.controllers;


import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;

    public MergerController(DinerController dinerController, PancakeHouseController pancakeHouseController){
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
         List<MenuItem> menuItems = new ArrayList<>();
         Iterator lunchItems = dinerRepository.getTheMenuIterator();
         while(lunchItems.hasNext()){
             menuItems.add(lunchItems.next());
         }
         List<MenuItem> breakfastItems = pancakeHouseRepository.getTheMenu();
         for (int i = 0; i < breakfastItems.size(); i++) {
            menuItems.add(breakfastItems.get(i));
        }
        return menuItems;
    }

}
