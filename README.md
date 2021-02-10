# Sigleton Log in Java

Implementation of a Log in Java ready to use in your project

Using this Log is simple and you can also customize the code to add new label like [INFO], [WARN] or giving your log a custom name.

## Steps

1. Instanciate your log in Log.java
```
public static Logger log = Logger.getInstance("yourLogName");
public static LoggerDB logDB = LoggerDB.getInstance("yourLogName2");
```
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You can have in your project as many logs as you instanciate in this class<br />
&nbsp;

2. Use info(), warn(), error() methods to log a new message
```
Log.log.info("Hello World!");
Log.log.warn("Something is not working...");
Log.log.error("Error message :(");

Log.logDB.info("Hello DataBase!");
Log.logDB.warn("Something is not working...");
Log.logDB.error("Error message :(");
```
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You can add new label for your log message adding a new method in Logger class
&nbsp;

#### Once you have done that the code will create: <br/>
&nbsp;&nbsp;- `logs` directory in your project folder <br/>
&nbsp;&nbsp;![alt text](./images/logs.png?raw=true) <br/>
&nbsp;&nbsp;- `logDate` directories with the date where the logs were created <br/>
&nbsp;&nbsp;![alt text](./images/logDay.png?raw=true) <br/>
&nbsp;&nbsp;- `logTime` logs files<br/>
&nbsp;&nbsp;![alt text](./images/newLogs.png?raw=true)<br/>
&nbsp;&nbsp;- Output of logs<br/>
&nbsp;&nbsp;![alt text](./images/log.png?raw=true)<br/>
&nbsp;&nbsp;![alt text](./images/logDb.png?raw=true)<br/>
