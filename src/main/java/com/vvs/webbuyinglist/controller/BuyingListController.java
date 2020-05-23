package com.vvs.webbuyinglist.controller;

import com.vvs.webbuyinglist.persist.BuyingItem;
import com.vvs.webbuyinglist.persist.BuyingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuyingListController {

    private final BuyingItemRepository repository;

    @Autowired
    public BuyingListController(BuyingItemRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new BuyingItem());
        return "index";
    }
    @PostMapping
    public String newBuyingItem(BuyingItem item) {
        repository.save(item);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteBuyingItem(@PathVariable("id") long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
