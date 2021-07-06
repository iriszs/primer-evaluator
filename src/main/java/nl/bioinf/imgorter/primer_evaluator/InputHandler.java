package nl.bioinf.imgorter.primer_evaluator;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputHandler {

    private final String name;
    private final int age;
    private final String inputfile;

    public InputHandler(String name, int age, String file) {
        this.name = name;
        this.age = age;
        this.inputfile = file;
    }

    public String ReadFile() throws FileNotFoundException {
        FileReader fr = null;
        BufferedReader br = null;
        String sequence = null;


        try {
            fr = new FileReader(inputfile);
            br = new BufferedReader(fr);
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                sequence = currentLine;

            }

        }
        catch (IOException e) {

        e.printStackTrace();

        }
        finally {
            try {
                if (br != null){
                    br.close();
                    fr.close();
                }

         } catch (IOException ex) {
               ex.printStackTrace();
            }
    }

        return sequence;
    }

    public void printInput(){
        System.out.println("Executing Inputhandler.printInput");
        System.out.println("Hi " + name + ", your age is " + age);
        System.out.println("File location is " + inputfile);


    }
}
