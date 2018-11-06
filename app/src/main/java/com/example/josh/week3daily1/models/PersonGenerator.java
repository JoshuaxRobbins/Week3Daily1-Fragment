package com.example.josh.week3daily1.models;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonGenerator {




    public static List<Person> generatePerson(Context context){

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            personList.add(new Person(getRandomName(),getRandomAge(),getRandomGender()));
            Toast.makeText(context, "Person Added",
                    Toast.LENGTH_LONG).show();
        }

        return personList;

    }

    public static String getRandomName(){
        List<String> names = new ArrayList<>();
        names.add("Josh");
        names.add("Assem");
        names.add("Nathan");
        names.add("Keenen");
        names.add("Tim");
        names.add("Michael");
        names.add("Bernardo");

        return names.get(new Random().nextInt(names.size()));


    }

    public static String getRandomAge(){
        return String.valueOf((new Random().nextInt(40)));
    }

    public static String getRandomGender(){
        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        return genders.get(new Random().nextInt(2));

    }
}
