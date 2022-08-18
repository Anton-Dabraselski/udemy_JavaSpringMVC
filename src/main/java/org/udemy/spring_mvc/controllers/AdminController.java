package org.udemy.spring_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.udemy.spring_mvc.dao.PersonDAO;
import org.udemy.spring_mvc.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") Person person){
        model.addAttribute("people", personDAO.index());

        return "adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId() + " " + person.getName());

        return "redirect:/people";
    }


}
