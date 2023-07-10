package nganxd.testcases;

import net.datafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class testDataFaker {
    @Test
    public void testDataFaker(){
        Faker faker = new Faker(new Locale("vi"));
        String computer = faker.computer().windows();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        System.out.println(computer);
        System.out.println(name);
        System.out.println(email);
    }
}
