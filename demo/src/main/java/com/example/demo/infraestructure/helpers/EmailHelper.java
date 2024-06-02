package com.example.demo.infraestructure.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmailHelper {
    //Inyectar el servicio de email la libreria
    private final JavaMailSender mailSender;

    //Funcion para leer el email
    private String readHTMLTemplate(String description, String title, String date){
        //Indicar en donde se encuentra el template
        final Path path = Paths.get("src/main/resources/emails/email_template.html");

        try (var lines = Files.lines(path)){
            var html = lines.collect(Collectors.joining());

            return html.replace("{description}", description).replace("{tile}", title).replace("{date}", date);
        } catch (IOException e) {
            System.out.println("File could not be read "+e.getMessage());
            throw new RuntimeException();
        }
    }

    public void sendEmail(String destiny, String description, String title, LocalDateTime date){
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String dateAppointment = date.format(formatter);
        String htmlContent = this.readHTMLTemplate(description, title, dateAppointment);

        try {
            //El email de la cuanta de donde lo va enviar
            message.setFrom(new InternetAddress("sebastian030107@gmail.com"));
            // Titulo del email, lo que va antex del cuelpo del email
            message.setSubject("Hey!, read that email!");

            //Esto recibe quien lo va enviar y a donde lo va enviar
            message.setRecipients(MimeMessage.RecipientType.TO,destiny);
            //Se le indica que viene de un archivo html, ya que estamos usando un archivo html
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);
            //Enviamos el email
            mailSender.send(message);
            System.out.println("Email sent");

        } catch (Exception e) {
            System.out.println("ERROR. Could not send the email " + e.getMessage());

        }
    }
}
