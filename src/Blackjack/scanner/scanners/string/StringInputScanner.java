package Blackjack.scanner.scanners.string;

import Blackjack.scanner.InputScanner;

import java.io.PrintStream;
import java.util.Scanner;

public class StringInputScanner implements InputScanner<String> {

    private String message = "? : ";
    private String error = "Input empty!";

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public void show(PrintStream output) {
        output.print(message);
    }

    @Override
    public void error(PrintStream output) {
        output.println();
        output.println(error);
    }

    @Override
    public String getUserInput(Scanner input) {
        // The token was already consumed by hasValidInput,
        // so we need to get it from the last matcher
        return input.match().group();
    }

    @Override
    public boolean hasValidInput(Scanner input) {

        if (!input.hasNextLine()) {
            return false;
        }

        return !input.next().isEmpty();
    }
}
