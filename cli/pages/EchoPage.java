package cli.pages;

import cli.io.InputReader;
import cli.io.Printer;

public class EchoPage extends Page {
    public EchoPage(Printer printer, InputReader reader) {
        super("Scan Input", printer, reader);
    }

    @Override
    protected void onOpen() {
        boolean scanning = true;
        while (scanning) {
            String text = ask("Ketik sesuatu (kosongkan untuk kembali): ");
            if (text == null || text.isBlank()) {
                scanning = false;
            } else {
                out().println("Kamu mengetik: " + text);
                out().println("Jumlah karakter: " + text.length());
            }
        }
    }
}
