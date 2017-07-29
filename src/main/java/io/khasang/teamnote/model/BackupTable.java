package io.khasang.teamnote.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gothmog on 27.07.2017.
 */
public class BackupTable {

    @Autowired
    Environment environment;

    public String runBackupTable() {
        String pgDump = environment.getProperty("postgresql.dumpAppPath");
        String dumpFile = environment.getProperty("postgresql.dumpFolder") + getDumpFileName();
        //Add commands to start pg_dump
        List<String> baseCommand = new ArrayList<>();
        //Path to pg_dump
        baseCommand.add(pgDump);
        baseCommand.add("-h");
        baseCommand.add("localhost");
        //Port
        baseCommand.add("-p");
        baseCommand.add("5432");
        //User
        baseCommand.add("-U");
        baseCommand.add(environment.getProperty("jdbc.postgresql.username"));
        //Add BLOB object into dump file
        baseCommand.add("-b");
        baseCommand.add("-v");
        //Path to dump file
        baseCommand.add("-f");
        baseCommand.add(dumpFile);
        //Base name
        baseCommand.add("teamnote");
        final ProcessBuilder processBuilder = new ProcessBuilder(baseCommand);
        //Password for PostgreSQL user
        final Map<String, String> env = processBuilder.environment();
        env.put("PGPASSWORD", environment.getProperty("jdbc.postgresql.password"));
        try {
            final Process process = processBuilder.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = reader.readLine();
            while (line != null) {
                System.err.println(line);
                line = reader.readLine();
            }
            reader.close();

            final int dcertExitCode = process.waitFor();
            if (dcertExitCode == 0) {
                return "Backup complete " + dumpFile;
            } else {
                return "Backup failed";
            }
        } catch (IOException | InterruptedException e) {
            return e.toString();
        }
    }

    private String getDumpFileName() {
        long currentTime = System.currentTimeMillis();
        String currentStringDate = new SimpleDateFormat("yyyy_MM_dd_HH-mm").format(currentTime);
        return "teamnote_" + currentStringDate + ".backup";
    }

}
