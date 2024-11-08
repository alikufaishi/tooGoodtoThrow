package com.example.TooGoodToThrow.Controller;

import com.example.TooGoodToThrow.Model.Madvare;
import com.example.TooGoodToThrow.Service.MadvareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {
    private final MadvareService madvareService;

    public HomeController(MadvareService madvareService) {
        this.madvareService = madvareService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("madvarer", madvareService.fetchAll());
        return "home/index";
    }

    @GetMapping("/createVirksomhed")
    public String createVirksomhed(){
        return "home/createVirksomhed";
    }

    @GetMapping("/createOrganisation")
    public String createOrganisation(){
        return "home/createOrganisation";
    }

    @GetMapping("/listFood")
    public String listFood(Model model){
        model.addAttribute("madvarer", madvareService.fetchAll());
        return "home/listFood";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Madvare m){
        madvareService.addMadvare(m);
        return "redirect:/";
    }

    @GetMapping("/viewOneFood/{id}")
    public String viewOneFood(@PathVariable("id") int id, Model model){
        model.addAttribute("madvare", madvareService.findMadvareById(id));
        return "home/viewOneFood";
    }

    @GetMapping("/deleteOneFood/{id}")
    public String deleteOneFood(@PathVariable("id") int id){
        madvareService.deleteMadvare(id);
        return "redirect:/";
    }

    /*@GetMapping("/updateOne/{id}")

    public String updateOne(@PathVariable("id") int id, Model model){
        model.addAttribute("madvare", madvareService.findMadvareById(id));
        return "home/updateOne";
    }
    */


    /*@PostMapping("/update")
    public String update(@ModelAttribute Madvare madvare){
        madvareService.updateMadvare(madvare);
        return "redirect:/";
    }
    */
}
