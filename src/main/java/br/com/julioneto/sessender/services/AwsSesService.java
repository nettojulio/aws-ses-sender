package br.com.julioneto.sessender.services;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;

import javax.mail.MessagingException;
import java.io.IOException;


public class AwsSesService {
    public static void sendMessage(String sendTo, String title, String message) {

        Region region = Region.US_EAST_1;
        SesClient client = SesClient.builder()
                .credentialsProvider(AwsCredentials.AwsCredentials())
                .region(region)
                .build();

        String bodyText = message;

        String bodyHTML = "<html>"
                + "<head></head>"
                + "<body>"
                + "<h1>AWS SES SENDER</h1>"
                + "<p>" + message + "</p>"
                + "<br><br>"
                + "<p>Enviado pelo Java</p>"
                + "</body>"
                + "</html>";

        try {
            AwsSendMail.send(client, System.getenv("AWS_SES_EMAIL_SENDER"), sendTo, title,
                    bodyText, bodyHTML);
            client.close();

            System.out.println("Email envido.");

        } catch (IOException | MessagingException e) {
            e.getStackTrace();
        }
    }
}
