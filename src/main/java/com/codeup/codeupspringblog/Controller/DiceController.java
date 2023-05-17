package com.codeup.codeupspringblog.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showRollDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;

        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);

        if (guess == diceRoll) {
            model.addAttribute("message", "Congratulations! You guessed the correct number.");
        } else {
            model.addAttribute("message", "Sorry, your guess was incorrect.");
        }

        return "roll-dice-result";
    }

}
