package logtest;

public class Test {

    public static void main(String[] args) {
        Log.log.info("Hello World!");
        Log.log.warn("Something is not working...");
        Log.log.error("Error message :(");

        Log.logDB.info("Hello DataBase!");
        Log.logDB.warn("Something is not working...");
        Log.logDB.error("Error message :(");
    }
}
