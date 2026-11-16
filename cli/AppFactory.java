package cli;

import cli.io.ConsoleInputReader;
import cli.io.ConsolePrinter;
import cli.io.InputReader;
import cli.io.Printer;
import cli.pages.ChooseMenuPage;
import cli.pages.EchoPage;
import cli.pages.MainMenuPage;

import java.util.List;

public class AppFactory {
    public static App create() {
        Printer printer = new ConsolePrinter();
        InputReader reader = new ConsoleInputReader();

        MainMenuPage mainMenu = new MainMenuPage(printer, reader);
        mainMenu.add(new ChooseMenuPage(printer, reader,
                List.of("Nasi Goreng", "Mie Ayam", "Soto Banjar", "Es Teh")));
        mainMenu.add(new EchoPage(printer, reader));

        return new App(mainMenu);
    }
}
