package com.codeup.codeupspringblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MathController {
    @GetMapping("/add/{number}")
    @ResponseBody
    public String addNum(@PathVariable int number) {
        return number + " plus 1 is " + (number + 1) + ".";
    }
    @GetMapping("/subtract/{number}")
    @ResponseBody
    public String subtractNum(@PathVariable int number) {
        return number + " minus 3 is " + (number - 3) + ".";
    }
    @GetMapping("/multiply/{number}")
    @ResponseBody
    public String multiplyNum(@PathVariable int number) {
        return number + " times 5 is " + (number * 5) + ".";
    }
    @GetMapping("/divide/{number}")
    @ResponseBody
    public String divideNum(@PathVariable int number) {
        return number + " divided by 2 is " + (number / 2) + ".";
    }
}

