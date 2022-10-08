package io.rienel.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    private static final int ID_COLUMN_INDEX = 0;
    private static final int SURNAME_COLUMN_INDEX = 1;
    private static final int NAME_COLUMN_INDEX = 2;
    private static final int PATRONYMIC_COLUMN_INDEX = 3;
    private static final int SEX_COLUMN_INDEX = 4;
    private static final int BIRTH_DATE_COLUMN_INDEX = 5;
    private static final int SALARY_COLUMN_INDEX = 6;

    public static List<Stuff> readDataFromFile(String fileName) {
        List<Stuff> stuffList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String header = reader.readLine();
            String[] columns = header.split(",");
            String readedLine = reader.readLine();
            while (readedLine != null) {
                String[] csvRow = readedLine.split(",");
                Stuff stuff = new Stuff();
                if (csvRow.length < 7) {
                    readedLine = reader.readLine();
                    continue;
                }
                stuff.setId(UUID.fromString(csvRow[ID_COLUMN_INDEX]));
                stuff.setSurname(csvRow[SURNAME_COLUMN_INDEX]);
                stuff.setName(csvRow[NAME_COLUMN_INDEX]);
                stuff.setPatronymic(csvRow[PATRONYMIC_COLUMN_INDEX]);
                stuff.setSex(Boolean.valueOf(csvRow[SEX_COLUMN_INDEX]));
                stuff.setBirthDate(LocalDate.parse(csvRow[BIRTH_DATE_COLUMN_INDEX]));
                stuff.setSalary(Integer.valueOf(csvRow[SALARY_COLUMN_INDEX]));
                stuffList.add(stuff);
                readedLine = reader.readLine();
            }
        } catch (IOException e) {

        }
        return stuffList;
    }

    public static void main(String[] args) {
        List<Stuff> stuffList = readDataFromFile("Stuff.csv");
        long ivansCount = stuffList.stream()
                .map(s -> s.getName()) // .map(Stuff::getName)
                .filter(n -> n.equals("Иван"))
                .count();
        System.out.println("Иванов в компании: " + ivansCount);

        long femaleCount = stuffList.stream()
                .map(s -> s.getSex())
                .filter(s -> s)
                .count();
        System.out.println("Женщин в компании: " + femaleCount);

        long maleCount = stuffList.stream()
                .map(s -> s.getSex())
                .filter(s -> !s)
                .count();
        System.out.println("Мужчин в компании: " + maleCount);

        long septembersBirths = stuffList.stream()
                .map(s -> s.getBirthDate().getMonth())
                .filter(m -> m == Month.SEPTEMBER)
                .count();
        System.out.println("Родилось в сентябре: " + septembersBirths);

        long salaryLessThan40000 = stuffList.stream()
                .map(s -> s.getSalary())
                .filter(s -> s < 40000)
                .count();
        System.out.println("Зарплата <40000: " + salaryLessThan40000);

        long salaryGreaterThan40000LessThan80000 = stuffList.stream()
                .map(s -> s.getSalary())
                .filter(s -> 40000 <= s && s <= 80000)
                .count();
        System.out.println("Зарплата [40000,80000]: " + salaryGreaterThan40000LessThan80000);

        long salaryGreatThan80000 = stuffList.stream()
                .map(s -> s.getSalary())
                .filter(s -> s > 80000)
                .count();
        System.out.println("Зарплата >80000: " + salaryGreatThan80000);
    }
}
