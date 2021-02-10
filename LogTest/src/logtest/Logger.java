package logtest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author YoInterneto
 */
public final class Logger {
    private static final Logger instanceLog = new Logger();

    private String logName;
    protected String env;
    protected String os = System.getProperty("os.name");
    private static File logFile;

    public static Logger getInstance(){
        return instanceLog;
    }

    public static Logger getInstance(String name){
        
        if(name.equalsIgnoreCase("")){
            instanceLog.logName = "defaultLog";
        }else{
            instanceLog.logName = name;
        }

        //Sometime directory is different depending on the OS
        //This lines of code are used for Java Web Application
        /**
        if(!instanceLog.os.startsWith("Windows")){
            instanceLog.env = System.getProperty("catalina.base") + "/webapps";
        }else{
            instanceLog.env = System.getProperty("user.dir");
        }
        **/

        instanceLog.env = System.getProperty("user.dir");
        instanceLog.createLogFile();

        return instanceLog;
    }

    public void createLogFile(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        
        //Create a new directory if doesnt exist
        File mainDirectory = new File(env + "/logs");
        if(!mainDirectory.exists()){
            System.err.println("INFO: Creating directory " + env);
            mainDirectory.mkdir();
        }
        
        //New directory in order to agroupate logs 
        File directory = new File(env + "/logs/log" + dateFormat.format(calendar.getTime()));
        if(!directory.exists()){
            System.err.println("INFO: Creating directory " + env);
            directory.mkdir();
        }
        
        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int m = calendar.get(Calendar.MINUTE);
        int s = calendar.get(Calendar.SECOND);
        String dateTime = String.format("%02d··%02d··%02d", h, m, s);

        //Create log with name = [currentTime] + name
        logName = '[' +dateTime + ']' + logName + ".log";
        
        String path = env + "/logs/" + directory.getName() + "/" + logName;
        Logger.logFile = new File(path);
        try{
            if(logFile.createNewFile()){
                this.info("OS - "+ os);
                this.info("New log created at "+ path);
            }
        }catch(IOException e){
            System.out.println("ERROR:" + e.getMessage());
            System.exit(1);
        }
    }

    private Logger(){
        
    }
    
    public void info(String message){
        try{
            FileWriter output = new FileWriter(Logger.logFile, true);
            output.write("[INFO] "+ message);
            output.write("\n");
            output.close();
        }catch(IOException e){
            System.err.println("ERROR: File cannot be written");
        }
    }
    
    public void error(String message){
        try{
            FileWriter output = new FileWriter(Logger.logFile, true);
            output.write("[ERROR] "+ message);
            output.write("\n");
            output.close();
        }catch(IOException e){
            System.err.println("ERROR: File cannot be written");
        }
    }
    
    public void warn(String message){
        try{
            FileWriter output = new FileWriter(Logger.logFile, true);
            output.write("[WARN] "+ message);
            output.write("\n");
            output.close();
        }catch(IOException e){
            System.err.println("ERROR: File cannot be written");
        }
    }
}
