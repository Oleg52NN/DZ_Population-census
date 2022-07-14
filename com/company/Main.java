package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static com.company.Education.HIGHER;


public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long count = persons.stream()
                .filter((age) -> age.getAge() <= 18)
                .count();
        // System.out.println(count);

        List list = persons.stream()
                .filter((x) -> x.getAge() >= 18 && x.getAge() < 27
                        && x.getSex() == Sex.MAN)
                .map((x) -> x.getFamily())
                .collect(Collectors.toList());
        //System.out.println(list);


        List<Person> listWorker = persons.stream()
                .filter((x) -> x.getAge() >= 18 && x.getEducation() == HIGHER && ((x.getAge() < 65 && x.getSex() == Sex.MAN) || (x.getAge() < 60 && x.getSex() == Sex.WOMAN)))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        //System.out.println(listWorker);
    }
}
