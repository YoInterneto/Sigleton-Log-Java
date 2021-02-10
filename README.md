# Sigleton Log in Java

Implementation of a Log in Java ready to use in your project

Using this Log is simple and you can also customize the code to add new label like [INFO], [WARN] or giving your log a custom name.

### Steps

1. Instanciate your log in Log.java
```
public static Logger log = Logger.getInstance("yourLogName");
public static LoggerDB logDB = LoggerDB.getInstance("yourLogName2");
```
You can have in your project as many logs as you instanciate in this class<br />


2. Use info(), warn(), error() methods to log a new message
```
Log.log.info("Hello World!");
Log.log.warn("Something is not working...");
Log.log.error("Error message :(");

Log.logDB.info("Hello DataBase!");
Log.logDB.warn("Something is not working...");
Log.logDB.error("Error message :(");
```
You can add new label for your log message adding a new method in Logger class
