package ru.netology.delivery.data;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        List<String> givenList = Arrays.asList("Москва","Владимир","Тверь","Уфа","Якутск");
        Random rand = new Random();
        String city = givenList.get(rand.nextInt(givenList.size()));

        return city;
    }

    public static String generateName(String locale) {

        Faker faker = new Faker(new Locale(locale));
        String firstName = String.valueOf(faker.name().firstName());
        String lastName = String.valueOf(faker.name().lastName());
        String name = lastName + " " + firstName;
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = String.valueOf(faker.numerify("+7##########"));
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)

            );
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
