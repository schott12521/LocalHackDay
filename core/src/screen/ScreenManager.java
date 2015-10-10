package screen;

public class ScreenManager {

    public static Screen currentScreen;

    public static  void setCurrentScreen(Screen screen) {
        if (currentScreen != null)
            currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen() {
        return currentScreen;
    }
}
