package com.mtsmda.souvenir.helper;

import com.mtsmda.souvenir.exception.SouvenirException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MTSMDA on 30.01.2016.
 */
public class CommonSQLScript {

    private StringBuilder stringBuilderSQLText = new StringBuilder();

    public void createAndUpdateCommonSQLScript() {
        String folder = "src\\main\\resources\\db\\";
        File file = new File(folder /*+ File.separator */ + "common_script.sql");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new SouvenirException("Cannot create new file " + file.getAbsolutePath() + " - " + e.getMessage());
            }
        }
//        System.out.println(file.getAbsoluteFile());

        List<String> strings = new ArrayList<>();

        this.stringBuilderSQLText.append("\n\t\t/*drop and create database*/\n");
        readFiles(folder + "db_create.sql");
        readFilesFromFolder(strings, folder);
        writeFiles(file);
        System.out.println("Done");
    }

    private void readFilesFromFolder(List<String> strings, String folder) {
        String[] folders = new String[]{"table", "view", "trigger", "stored_procedure"};
        for (String current : folders) {
            getFilesRecursively(folder + current, strings);
            this.stringBuilderSQLText.append("\n").append("\t\t/*").append(current + "s").append("*/").append("\n");
            for (String currentFileName : strings) {
                readFiles(currentFileName);
            }
            strings.clear();
        }
    }

    private void getFilesRecursively(String path, List<String> strings) {
        if (StringUtils.isNotBlank(path)) {
            File file = new File(path);
            if (file != null && file.exists()) {
                if (file.isFile()) {
                    if (!file.getName().startsWith("call")) {
                        strings.add(file.getAbsolutePath());
                    }
                } else {
                    for (String s : file.list()) {
                        getFilesRecursively(file.getAbsolutePath() + File.separator + s, strings);
                    }
                }
            }
        }
    }

    private void readFiles(String fileName) {
        if (StringUtils.isNotBlank(fileName)) {
            readFiles(new File(fileName));
        } else {
            throw new SouvenirException("File name is null or empty!");
        }
    }

    private void readFiles(File fileName) {
        if (fileName != null && fileName.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    this.stringBuilderSQLText.append(line).append("\n");
                }
                this.stringBuilderSQLText.append("\n");
            } catch (Exception e) {
                throw new SouvenirException("File read exception - " + e.getMessage());
            }
        } else {
            throw new SouvenirException("File null or not exists!");
        }
    }

    private void writeFiles(File fileName) {
        if (fileName != null && fileName.exists()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));) {
                String line = null;
                bufferedWriter.write(this.stringBuilderSQLText.toString());
            } catch (Exception e) {
                throw new SouvenirException("File read exception - " + e.getMessage());
            }
        } else {
            throw new SouvenirException("File null or not exists!");
        }
    }

    private void writeFiles(String fileName) {
        if (StringUtils.isNotBlank(fileName)) {
            writeFiles(new File(fileName));
        } else {
            throw new SouvenirException("File name is null or empty!");
        }
    }

    public static void main(String[] args) {
        new CommonSQLScript().createAndUpdateCommonSQLScript();
    }

}