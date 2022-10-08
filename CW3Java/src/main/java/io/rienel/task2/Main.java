package io.rienel.task2;

import io.rienel.task1.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client.Builder builder = new Client.Builder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите данные о клиенте");
            do {
                System.out.println("Введите Фамилию");
                String surname = reader.readLine();
                if (!surname.isBlank()) {
                    builder.setSurname(surname);
                    break;
                }
            } while (true);
            do {
                System.out.println("Введите Имя");
                String name = reader.readLine();
                if (!name.isBlank()) {
                    builder.setName(name);
                    break;
                }
            } while (true);
            do {
                System.out.println("Введите Отчетство");
                String patronymic = reader.readLine();
                if (!patronymic.isBlank()) {
                    builder.setPatronymic(patronymic);
                    break;
                }
            } while (true);
            System.out.println("Введите пол (М или Ж) - необязательно");
            String sex = reader.readLine();
            if (!sex.isBlank() && (sex.equals("М") || sex.equals("Ж"))) {
                builder.setSex(sex.equals("Ж"));
            }
            do {
                System.out.println("Введите дату рождения в формате гггг-ММ-дд");
                String birthDateStr = reader.readLine();
                if (!birthDateStr.isBlank()) {
                    LocalDate birthDate = LocalDate.parse(birthDateStr);
                    builder.setBirthDate(birthDate);
                    break;
                }
            } while (true);
            do {
                System.out.println("Введите ИНН");
                String inn = reader.readLine();
                if (!inn.isBlank() && inn.length() == 10) {
                    builder.setInn(inn);
                    break;
                }
            } while (true);
            do {
                System.out.println("Введите серию номер паспорта");
                String passportSerial = reader.readLine();
                if (!passportSerial.isBlank() && passportSerial.length() == 11) {
                    builder.setPassportSerial(passportSerial);
                    break;
                }
            } while (true);
            System.out.println("Введите телефон");
            String phone = reader.readLine();
            if (!phone.isBlank()) {
                builder.setSex(sex.equals("Ж"));
            }
        } catch (IOException e) {
        }
        Client client = builder.build();
        System.out.println(client);
    }
}
