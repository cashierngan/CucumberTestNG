package nganxd.helper;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFackerHelpers {
    private static Faker faker;
    public static Faker createFacker(){
        faker = new Faker(new Locale("en"));
        return faker;
    }

    public static Faker createFackerByLocate(String locateName){
        faker = new Faker(new Locale(locateName));
        return faker;
    }

    public static Faker getFaker(){
        if(faker == null){
            faker = createFacker();
        }
        return faker;
    }

    public static Faker getFakerByLocate(String locateName){
        faker = createFackerByLocate(locateName);
        return faker;
    }

    public static void setFaker(Faker faker){
        DataFackerHelpers.faker = faker;
    }
}
