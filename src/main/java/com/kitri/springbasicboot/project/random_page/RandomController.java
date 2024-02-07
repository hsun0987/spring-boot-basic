package com.kitri.springbasicboot.project.random_page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/random/color/")
    public String getColor(Model model){
        Random r = new Random();
        int n = r.nextInt(256 * 256 * 256);
        String Hexadecimal = Integer.toHexString(n);

        model.addAttribute("color", "#" + Hexadecimal);
        return "project/random_page/color";
    }

    @GetMapping("/random/{n}")
    public String getRandomNum(@PathVariable int n, Model model){
        Random r = new Random();
        int num = r.nextInt(n-1) + 1;

        model.addAttribute("number", num);
        return "project/random_page/number";
    }

}
