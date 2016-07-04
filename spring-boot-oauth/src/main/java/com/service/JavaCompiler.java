package com.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods to run java source files
 */
@Component
public class JavaCompiler {

    /**
     *
     * @param path
     * @param output
     * @throws IOException
     * @throws InterruptedException
     */
    private void compileSource(String path, List<String> output) throws IOException, InterruptedException {

        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("javac " + path);
        InputStream stderr = proc.getErrorStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        StringBuilder obr = new StringBuilder();
        while ((line = br.readLine()) != null) {
            obr.append(line);
        }
        if (!obr.toString().isEmpty()) {
            output.add(obr.toString());
        }
        proc.waitFor();
    }

    /**
     *
     * @param directoryPath
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private  List<String> getJavaFilesInDirectory(String directoryPath) throws IOException, InterruptedException{

        Runtime rt = Runtime.getRuntime();
        StringBuilder command = new StringBuilder()
                .append("ls ")
                .append(directoryPath);

        Process proc = rt.exec(command.toString());
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        List<String> lineStr = new ArrayList<>();
        while ( (line = br.readLine()) != null) {
            if(line.endsWith("java")) {
                lineStr.add(line);
            }
        }
        proc.waitFor();
        return lineStr;
    }


    /**
     *
     * @param path
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public List<String> compile(String path) throws IOException, InterruptedException
    {
        //get mvn file in directory, if found then skip below step.
        List<String> line = getJavaFilesInDirectory(path);
        //send mvn command along with path
        List<String> output = new ArrayList<>();
        for (String l: line){
            String p = path + l;
            compileSource(p, output);
        }
        if(output.isEmpty()){
            output.add("Compilation successful");
        }
        return output;
    }


//    public static void main( String[] args ) throws Exception
//    {
//
//        JavaCompiler jc= new JavaCompiler();
//        String path = "/Users/varunsingh/Desktop/dfolder/cfolder/";
//        List<String> output = jc.compile(path);
//
//        System.out.println("Below is the output...");
//        for(String o: output){
//            System.out.println(output);
//        }
//
//    }


}
