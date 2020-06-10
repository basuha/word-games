package utilities.tg_bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;

public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot wirdGamesBot = new Bot("WordGamesNewBot", "1272238322:AAFeCY-hp3kBH3Tg6NwEzQbjgM86IESaqzM");
        wirdGamesBot.botConnect();
    }
}
