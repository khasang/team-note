package io.khasang.teamnote.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.text.SimpleDateFormat;

/**
 * @author gothmog on 27.07.2017.
 */
public class BackupTable {

    @Autowired
    Environment environment;
    private String dumpAppPath = "C:\\Program Files\\PostgreSQL\\9.6\\bin\\pg_dump";
    private String dumpFolder = "C:\\Backup\\";

    public String runBackupTable(){
        String pgDump = environment.getProperty(dumpAppPath);
        String dumpFile = environment.getProperty(dumpFolder) + getDumpFileName();
        return null;
    }

    private String getDumpFileName(){
        long currentTime = System.currentTimeMillis();
        String currentStringDate = new SimpleDateFormat("yyyy_MM_dd_HH-mm").format(currentTime);
        return "teamnote_" + currentStringDate + ".backup";
    }

}
