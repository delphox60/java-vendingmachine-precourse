package vendingmachine.view;

public class ErrorMessageOutputView {

    private static final String ERROR_SYMBOL = "[ERROR] ";

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }
}
