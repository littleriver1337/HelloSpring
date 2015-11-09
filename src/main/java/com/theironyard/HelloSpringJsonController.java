package com.theironyard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MattBrown on 11/9/15.
 */
@RestController//this controller is used to return Json
public class HelloSpringJsonController {
    @RequestMapping("/person.json")//person information as json
    public Person person(
                        @RequestParam(defaultValue = "Bob")String name,
                        @RequestParam(defaultValue = "Charleston") String city,
                        @RequestParam(defaultValue = "30") Integer age
    ) {
        return new Person(name, city, age);//returns the information
    }
}
