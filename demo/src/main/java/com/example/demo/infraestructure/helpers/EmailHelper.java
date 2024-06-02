package com.example.demo.infraestructure.helpers;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmailHelper {
    //Inyectar el servicio de envio de correos
    private final JavaMailSender mailSender;

    // Funcion para leer el template del email
    public String readHTMLTemplate(String title, String description, String date) {
        //Indicar donde se encuentra el template
        final Path path = Paths.get("C:\\Users\\User\\Downloads\\spring-riwi\\demo\\src\\main\\resources\\emails\\email_template.html");

        // Leer el template
        try(var lines = Files.lines(path)) {
            var html = lines.collect(Collectors.joining());
            return html.replace("{title}", title).replace("{description}", description).replace("{date}", date);
        } catch (IOException e) {
            System.out.println("Ocurrio un error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //Funcion para enviar el email
    public  void sendEmail(String destiny, String title, String description, LocalDateTime date) {
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateAppointment = date.format(formatter);

        String htmlContent = readHTMLTemplate(title, description, dateAppointment);

        try{
            //el email de la cuenta que lo va enviar
            message.setFrom(new InternetAddress("sebastian030107@gmail.com"));
            //Ponemos el asunto
            message.setSubject("Asunto: example");

            //Quien lo va a enviar
            message.setRecipients(MimeMessage.RecipientType.TO,destiny);

            //Indicar que viene en archivo html
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            //eviamos el email
            mailSender.send(message);

        }catch (Exception e){
            System.out.println("Error al enviar el email: "+e.getMessage());
        }

    }

}
