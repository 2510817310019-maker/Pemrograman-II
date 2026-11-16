package cli;

import cli.pages.MenuItem;

public class App {
    private final MenuItem home;

    public App(MenuItem home) {
        this.home = home;
    }

    public void run() {
        home.open();
    }
}
