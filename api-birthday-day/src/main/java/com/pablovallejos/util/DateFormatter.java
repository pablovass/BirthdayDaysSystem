package com.pablovallejos.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public LocalDate formatLocalDateTime(String dateTime) {
        if (dateTime != null) {
            // Definir el formateador con el patrón deseado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
            // Parsear la cadena de fecha al formato LocalDate utilizando el formateador
            return LocalDate.parse(dateTime, formatter);
        }
        return null;
    }

}
