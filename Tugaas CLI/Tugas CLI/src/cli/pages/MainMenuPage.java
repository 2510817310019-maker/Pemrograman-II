package cli.pages;

import cli.io.InputReader;
import cli.io.Printer;

import java.util.ArrayList;
import java.util.List;

public class MainMenuPage extends Page {
    private final List<MenuItem> items = new ArrayList<>();

    public MainMenuPage(Printer printer, InputReader reader) {
        super("Menu Utama", printer, reader);
    }

    public void add(MenuItem item) {
        items.add(item);
    }

    @Override
    protected void onOpen() {
        boolean running = true;
        while (running) {
            showItems();
            String input = ask("Pilih halaman: ");
            if (input == null) {
                running = false;
            } else {
                running = handle(input.trim());
            }
        }
        out().println("Sampai jumpa!");
    }

    private void showItems() {
        for (int i = 0; i < items.size(); i++) {
            out().println((i + 1) + ". " + items.get(i).getLabel());
        }
        out().println("0. Keluar");
    }

    private boolean handle(String input) {
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            out().println("Masukkan angka yang sesuai.");
            return true;
        }
        if (choice == 0) {
            return false;
        }
        if (choice < 1 || choice > items.size()) {
            out().println("Pilihan tidak tersedia.");
            return true;
        }
        items.get(choice - 1).open();
        return true;
    }
}
