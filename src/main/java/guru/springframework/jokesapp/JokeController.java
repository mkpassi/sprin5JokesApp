package guru.springframework.jokesapp;

import guru.springframework.jokesapp.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JokeController {

    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping(value = {"/",""}, method = {RequestMethod.GET,RequestMethod.POST})
    public String showJokes(Model model){
        model.addAttribute("joke", jokeService.getJoke());
        return "chuckNorris";
    }
}
