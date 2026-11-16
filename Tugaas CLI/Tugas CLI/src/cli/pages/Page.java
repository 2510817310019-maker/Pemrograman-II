package cli.pages;

import cli.io.InputReader;
import cli.io.Printer;

public abstract class Page implements MenuItem {
    private final String title;
    private final Printer printer;
    private final InputReader reader;

    protected Page(String title, Printer printer, InputReader reader) {
        this.title = title;
        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public String getLabel() {
        return title;
    }

    @Override
    public final void open() {
        printer.println("");
        printer.println("=== " + title + " ===");
        onOpen();
    }

    protected abstract void onOpen();

    protected Printer out() {
        return printer;
    }

    protected String ask(String prompt) {
        printer.print(prompt);
        return reader.readLine();
    }
}
