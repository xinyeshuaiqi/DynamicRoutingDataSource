package pers.wmx.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangmingxin03
 * Created on 2021-12-08
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/person/insert")
    public String insetPerson(@RequestParam String name,
                            @RequestParam int age) {
        personService.insertPerson(name, age);
        return "success";
    }
}
