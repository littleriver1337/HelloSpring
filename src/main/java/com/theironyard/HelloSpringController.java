package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by MattBrown on 11/9/15.
 */
@Controller//calling this a controller from Spring - Creating Get and Post routes within the spring controller
public class HelloSpringController {
    @RequestMapping("/person") //takes an arguement and tells it where its going - /person
    public String person(Model model,
                         @RequestParam(defaultValue = "Bob") String name,//Annotates that the default value = default value
                         @RequestParam(defaultValue = "Charleston") String city,
                         @RequestParam(defaultValue = "30") Integer age
    ){//creates a model and automatically injects
        // the information that you want you and you can put the actual objects into the arguement itself
        Person p = new Person(name, city, age);//passes arguements defined within the person
        model.addAttribute("person", p);//injects the information to the model
        return "person";//returns the person I.E. mustache template

    }

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username){// going to take server request, going to take the username
        HttpSession session = request.getSession();
        session.setAttribute("username", username);//sets the attribute
        return "redirect:/";
    }
}
