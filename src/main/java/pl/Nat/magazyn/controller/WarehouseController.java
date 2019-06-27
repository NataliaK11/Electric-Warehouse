package pl.Nat.magazyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.Nat.magazyn.model.form.WireForm;
import pl.Nat.magazyn.model.service.WireService;

@Controller
public class WarehouseController {

    @Autowired
    WireService wireService;

    @GetMapping("/warehouse")
    public String index(){
        return "index";
    }

    @GetMapping("/show")
        public String show(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("showAllWires",wireService.showAllWires());
        return "redirect:/warehouse";
    }

    @GetMapping("/warehouse/add")
        public String showAddChoice(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("showChoice",true);
        return "redirect:/warehouse";
    }
    @GetMapping("/warehouse/add/new")
    public String choiceNewElement(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("showChoice",true);
        redirectAttributes.addFlashAttribute("newElement",true);

        return "redirect:/warehouse";
    }

    @GetMapping("warehouse/show")
    public String showChoice(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("show",true);
        return "redirect:/warehouse";
    }
    @GetMapping("/wire")
        public String addWire(Model model){
        model.addAttribute("wireForm",new WireForm());
        return "add_wire";
    }
    @PostMapping("/wire")
        public String addWire(@ModelAttribute WireForm wireForm,
                              RedirectAttributes redirectAttributes){
        wireService.addNewWire(wireForm);
        redirectAttributes.addFlashAttribute("info","Dodano nowy rodzaj kabla");
        return "redirect:/warehouse";

    }

}
