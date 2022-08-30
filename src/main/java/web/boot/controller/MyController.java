package web.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.boot.model.User;
import web.boot.service.MyService;


@Controller
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping(value = "/")
    public String showIndex(ModelMap model) {
        model.addAttribute("findAll", myService.findAll());
        //List<User> users = myService.findAll();
        //model.addAttribute("findAll", users);
        return "index";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        myService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, ModelMap modelMap) {
        User user = myService.findById(id);
        modelMap.addAttribute("user", user);
        System.out.println(user);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("user") User user) {
        myService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        myService.deleteById(id);
        return "redirect:/";
    }
}
