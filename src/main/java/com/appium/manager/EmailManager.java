package com.appium.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailManager {

    public static void sendMail() {
        final String username = "robertomoja2@gmail.com";
        final String password = "scjwgywbhnbsdkzr";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });


        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("robertomoja2@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rbttm1999@gmail.com"));
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            message.setSubject("Ejecución de CPs Automatizados en APP AS para Android " + date);
            String casesHtml = "<h1 style=\"color: #173962; font-size: 20px; margin: 0 0 20px 0; font-family: Arial,sans-serif; \">Ejecución de CPs Automatizados en APP AS con Android "+ date + "</h1>";
            casesHtml +=  "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">A continuación, se adjuntan los informes de prueba de la ejecución realizada el <strong>"+ date +"</strong> de la batería de casos de prueba automatizados en <strong>AS</strong> sobre <strong>Android</strong></p>";
            try {
                File myObj = new File("failedtests.txt");
                Scanner myReader = new Scanner(myObj);
                if (myObj.length() == 0) {
                    casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">Resultado: <strong><span style=\"color: #37c41b;\">PASADO</span></strong></p>";
                }else {
                    casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">Resultado: <strong><span style=\"color: #CF2804;\">FALLADO</span></strong></p>";
                    casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">Los casos de prueba que han fallado durante la ejecuci&oacute;n han sido:</p>";
                    while (myReader.hasNextLine()) {
                        casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\"> -" + myReader.nextLine()+"</p>";
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\"><a style=\"color: #00cde2; text-decoration: underline;\" href=\"http://www.example.com\">Link al informe de pruebas generado en Allure</a></p>";
            casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">Adjuntamos también reporte en formato PDF.</p>";
            casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">Cualquier cosa que necesiten, no duden en ponerse en contacto con el equipo de QA.</p>";
            casesHtml += "<p style=\"margin: 0px 0px 12px; font-size: 16px; line-height: 24px; font-family: Arial, sans-serif; text-align: justify;\">Un saludo y muchas gracias.</p>";

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(EmailHTML.headHtml()+casesHtml+EmailHTML.footerHtml(),"text/html");

            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "./Reports/pdf/extentPdf.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("extentPdf.pdf");
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
