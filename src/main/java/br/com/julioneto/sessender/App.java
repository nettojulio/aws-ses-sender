package br.com.julioneto.sessender;

import br.com.julioneto.sessender.services.AwsSesService;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\n\n");

        System.out.print("Para: ");
        String sendTo = keyboard.nextLine();

        System.out.print("Título do e-mail: ");
        String title = keyboard.nextLine();

        System.out.print("Corpo do e-mail: ");
        String message = keyboard.nextLine();

        System.out.println("\n\n");

        AwsSesService.sendMessage(sendTo, title, message);
    }
}
