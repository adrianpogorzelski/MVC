package com.example.mvc.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/test")
    public String test(Model model) {
        System.out.println("Metoda test");
        Integer i = new Random().nextInt();
        model.addAttribute("random", i);
        return "person/test";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Person> users = new ArrayList<>();
        users.add(new Person(1, "Janusz", "janusz@cebula.pl", true, new Date()));
        users.add(new Person(2, "Grażyna", "grażyna@cebula.pl", false, new Date()));
        users.add(new Person(567, "Seba", "sebix@jp200.pl", true, new Date()));

        model.addAttribute("users", users);
        return "person/list";
    }

    @GetMapping("/details")
    public String details(Model model) {
        Person janusz = new Person(1, "Janusz", "janusz@cebula.pl", true, new Date());

        model.addAttribute("user", janusz);

        return "person/details";
    }
}
