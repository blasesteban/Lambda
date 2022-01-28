package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.lang.System.*;
import static java.util.stream.Collectors.*;

public class App {
    public static void main(String[] args) {
        new App().run();
        App app = new App();
        app.printMales(app.getPeople());

    }

    private void run() {
        List<Person> people = getPeople();
        out.println(people);
    }

    public List<Person> getPeople() {
        return List.of(
                new Person("Peter", Sex.MALE, 22),
                new Person("Sarah", Sex.FEMALE, 20),
                new Person("Tim", Sex.MALE, 54),
                new Person("Michelle", Sex.FEMALE, 16),
                new Person("Rob", Sex.MALE, 32),
                new Person("Julie", Sex.FEMALE, 47),
                new Person("Carlo", Sex.MALE, 17),
                new Person("Simon", Sex.MALE, 82),
                new Person("Melanie", Sex.FEMALE, 89),
                new Person("Vincenzo", Sex.MALE, 14)
        );
    }

    private void printMales(List<Person> people) {
        List<Person> males = new ArrayList<>();
        for (Person person : people) {
            if (person.getSex() == Sex.MALE) {
                males.add(person);
            }
        }
        out.println(males);

    }

    private void printAdultMales(List<Person> people) {
        for (Person person : people) {
            if (person.getSex() == Sex.MALE && person.getAge() >= 18) {
                out.println(person);
            }
        }
    }

    private void printFemales(List<Person> people) {
        people.stream()
                .filter(p -> p.getSex() == Sex.FEMALE)
                .forEach(p -> out.println(p));
        //.forEach(System.out::println);
    }

    private void printAdultFemales(List<Person> people) {
        List<Person> adultFemales = people.stream()
                .filter(p -> p.getSex() == Sex.FEMALE)
                .collect(toList());
        out.println(adultFemales);
    }

    void printAdultFemalesWithEvenLengthName(List<Person> people) {
        people.stream().filter(p -> p.getSex() == Sex.FEMALE)
                .filter(p -> p.getAge() >= 18)
                .map(Person::getName)
                .filter(name -> name.length() % 2 == 0)
                .forEach(out::println);
    }

    void printUppercaseAdultFemalesWithEvenLengthName(List<Person> people) {
        people.stream().filter(p -> p.getSex() == Sex.FEMALE)
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getName().length() % 2 == 0)
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(out::println);
    }

    List<Person> changeSexOfAdults(List<Person> people) {
        return people.stream()
                .map(p -> {
                            if (p.getAge() < 18) {
                                return p;
                            }
                            return new Person(p.getName(), (p.getSex() == Sex.MALE) ? Sex.FEMALE : Sex.MALE, p.getAge());
                        }
                )
                .collect(toList());
    }
}

enum Sex {
    MALE, FEMALE;
}

class Person {
    private String name;
    private Sex gender;
    private int age;

    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

