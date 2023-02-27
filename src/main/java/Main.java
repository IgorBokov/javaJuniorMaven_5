import org.apache.log4j.Logger;

public class Main {
    private static  final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.trace("Ошибка");
        LOGGER.debug("debug2");
        LOGGER.warn("warn2");
        LOGGER.error("error22");
        LOGGER.fatal("fatal2");

    }
}
