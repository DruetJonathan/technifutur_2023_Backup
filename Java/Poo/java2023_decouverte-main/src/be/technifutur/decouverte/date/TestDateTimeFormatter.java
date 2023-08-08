package be.technifutur.decouverte.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestDateTimeFormatter {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        DateTimeFormatter writerFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");
        DateTimeFormatter readerFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        String text = date.format(writerFormatter);
        System.out.println(text);
        text = "21/1/2000";
        LocalDate parsedDate = LocalDate.parse(text, readerFormatter);
        System.out.println(parsedDate.format(writerFormatter));

        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter writer2Formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy à h 'heure' mm 'minutes'");
        DateTimeFormatter reader2Formatter = DateTimeFormatter.ofPattern("d/M/yyyy k:m");
        text = dateTime.format(writer2Formatter);
        System.out.println(text);
        text = "21/1/2000 20:15";
        LocalDateTime parsedDateTime = LocalDateTime.parse(text, reader2Formatter);
        System.out.println(parsedDateTime.format(writer2Formatter));

        LocalTime time = LocalTime.now();

        DateTimeFormatter writer3Formatter = DateTimeFormatter.ofPattern("h 'heure' mm 'minutes'");
        DateTimeFormatter reader3Formatter = DateTimeFormatter.ofPattern("k:m");
        text = time.format(writer3Formatter);
        System.out.println(text);
        text = "20:15";
        LocalTime parsedTime = LocalTime.parse(text, reader3Formatter);
        System.out.println(parsedTime.format(writer3Formatter));
    }
}
