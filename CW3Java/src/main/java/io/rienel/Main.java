package io.rienel;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {

    private static final List<String> maleSurnameList = List.of("Иванов", "Петров", "Сидоров", "Михайлов", "Белоусов", "Козлов", "Мотозов", "Мельников");
    private static final List<String> maleNameList = List.of("Иван", "Петр", "Артем", "Михаил", "Илья", "Алексей", "Александр", "Сергей", "Кирилл");
    private static final List<String> malePatronymicList = List.of("Иванович", "Петрович", "Артемович", "Михайлович", "Ильич", "Алексеевич", "Александрович", "Сергеевич", "Кириллович");
    private static final List<String> femaleSurnameList = List.of("Иванова", "Петрова", "Сидорова", "Михайлова", "Белоусова", "Козлова", "Мотозова", "Мельникова");
    private static final List<String> femaleNameList = List.of("Алена", "Александра", "Влада", "Екатерина", "Елизовета", "Дарья", "Анастасия", "Любовь");
    private static final List<String> femalePatronymicList = List.of("Ивановна", "Петровна", "Артемовна", "Михайловна", "Андреевна", "Алексеевна", "Александровна", "Сергеевна", "Кирилловна");
    private static final DateTimeFormatter isoFormat = DateTimeFormatter.ISO_DATE;

    public static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        boolean sex = false; // мужской false, женский true
        Random ran = new Random();
        try (FileWriter outputStream = new FileWriter("Stuff.csv", StandardCharsets.UTF_8)) {
            outputStream.write("id,surname,name,patronymic,sex,birthDate,salaryMultiplier\n");
            for (int i = 0; i < 10_000; i++) {
                outputStream.write(UUID.randomUUID() + ",");
                if (!sex) {
                    outputStream.write(maleSurnameList.get(ran.nextInt(maleSurnameList.size())) + ",");
                    outputStream.write(maleNameList.get(ran.nextInt(maleNameList.size())) + ",");
                    outputStream.write(malePatronymicList.get(ran.nextInt(malePatronymicList.size())) + ",");
                    outputStream.write(sex + ",");
                    outputStream.write(isoFormat.format(LocalDate.of(getRandomNumber(1970, 2001), getRandomNumber(1, 13), getRandomNumber(1, 29))) + ",");
                    outputStream.write(String.format("%.2f", Math.random() + 1));
                    sex = true;
                } else {
                    outputStream.write(femaleSurnameList.get(ran.nextInt(femaleSurnameList.size())) + ",");
                    outputStream.write(femaleNameList.get(ran.nextInt(femaleNameList.size())) + ",");
                    outputStream.write(femalePatronymicList.get(ran.nextInt(femalePatronymicList.size())) + ",");
                    outputStream.write(sex + ",");
                    outputStream.write(isoFormat.format(LocalDate.of(getRandomNumber(1970, 2001), getRandomNumber(1, 13), getRandomNumber(1, 29))) + ",");
                    outputStream.write(String.format("%.2f",  Math.random() + 1));
                    sex = false;
                }
                outputStream.write("\n");
            }
        } catch (IOException e) {

        }
    }
}