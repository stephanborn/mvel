package org.mvel2.patches;

import org.junit.Test;
import org.mvel2.MVEL;
import org.mvel2.patches.domain.Name;
import org.mvel2.patches.domain.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MVELTestCase {

//public static void main(String[] args) {
//    testCase();
//}

@Test
public void testCase() {
    Collection<Person> persons = getPersons(200);
    Map<String, Object> vars = new HashMap<String, Object>();
    vars.put("persons", persons);

    Object eval = MVEL.eval("(name.first in persons)", vars);
    System.out.println(eval);
}

private static Collection<Person> getPersons(int number) {
    Collection<Person> persons = new ArrayList<Person>();
    for (int i = 0; i < number; i++)
    {
        Person person2 = new Person();
        person2.setName(new Name(toLetter(i) + "name", "Last"));
        persons.add(person2);
    }
    return persons;
}

private static char toLetter(int i) {
    return (char) (i % (90 - 65 + 1)  + 65);
}
}