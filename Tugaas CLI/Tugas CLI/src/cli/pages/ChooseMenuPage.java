package cli.pages;

import cli.io.InputReader;
import cli.io.Printer;

import java.util.ArrayList;
import java.util.List;

public class ChooseMenuPage extends Page {
    private final List<String> options;

    public ChooseMenuPage(Printer printer, InputReader reader, List<String> options) {
        super("Pilih Menu Makanan", printer, reader);
        this.options = new ArrayList<>(options);
    }

    @Override
    protected void onOpen() {
        boolean choosing = true;
        while (choosing) {
            showOptions();
            String input = ask("Pilih nomor: ");
            if (input == null || input.trim().equals("0")) {
                choosing = false;
            } else {
                choosing = !select(input.trim());
            }
        }
    }

    private void showOptions() {
        for (int i = 0; i < options.size(); i++) {
            out().println((i + 1) + ". " + options.get(i));
        }
        out().println("0. Kembali");
    }

    private boolean select(String input) {
        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.size()) {
                out().println("Kamu memilih: " + options.get(choice - 1));
                return true;
            }
        } catch (NumberFormatException e) {
            out().println("Masukkan angka yang sesuai.");
            return false;
        }
        out().println("Pilihan tidak tersedia.");
        return false;
    }
}
