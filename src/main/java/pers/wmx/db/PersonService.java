package pers.wmx.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author wangmingxin03
 * Created on 2021-12-08
 */
@Service
@Lazy
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    @AppContextAspect
    public void insertPerson(String name, int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personMapper.insert(person);
    }
}
