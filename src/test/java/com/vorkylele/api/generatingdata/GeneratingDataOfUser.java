package com.vorkylele.api.generatingdata;

import com.github.javafaker.Faker;
import com.vorkylele.api.models.User;

public class GeneratingDataOfUser {
    public static User createNewUser() {
        return User.builder()
                .email(Faker.instance().internet().emailAddress())
                .password(Faker.instance().internet().password())
                .name(Faker.instance().name().nameWithMiddle())
                .build();
    }
}