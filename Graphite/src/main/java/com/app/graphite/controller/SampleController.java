package com.app.graphite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	@RequestMapping(value = "/template", method = RequestMethod.GET)
    public String test(Model model) {
     model.addAttribute("title", "Sample title");
     model.addAttribute("body", "boht ache");
     return "template";
    }
}
