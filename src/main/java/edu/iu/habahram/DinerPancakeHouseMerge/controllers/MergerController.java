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
    public MenuItem[] get() {
        List<MenuItem> mergedMenu = new ArrayList<>();

        MenuItem[] dinerMenu = dinerRepository.getTheMenu();
        Collections.addAll(mergedMenu, dinerMenu);

        MenuItem[] pancakeHouseMenu = pancakeHouseRepository.getTheMenu();
        Collections.addAll(mergedMenu, pancakeHouseMenu);

        mergedMenu.sort((item1, item2) -> item1.getName().compareToIgnoreCase(item2.getName()));

        MenuItem[] mergedMenuArray = mergedMenu.toArray(new MenuItem[0]);

        return mergedMenuArray;
    }
}
