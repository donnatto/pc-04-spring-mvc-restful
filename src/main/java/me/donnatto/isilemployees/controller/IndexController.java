package me.donnatto.isilemployees.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/login"})
    private String index() {
        return "index";
    }
}
