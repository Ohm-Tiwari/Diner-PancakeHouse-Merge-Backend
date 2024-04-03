package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVeg(){
        List<MenuItemRecord> items = mergerRepository.getVeg();
        return items;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast(){
        List<MenuItemRecord> items = mergerRepository.getBreakfast();
        return items;
    }


//    @GetMapping("/lunch")
//    public List<MenuItemRecord> lunch(){
//        return null;
//    }

//    @GetMapping("/supper")
//    public MenuItem supper(){
//        return null;
//    }
}