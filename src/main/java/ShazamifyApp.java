import interface_adaptors.ShazamifyUI;

public class ShazamifyApp {

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        (new ShazamifyUI()).setVisible(true);
    }
}
