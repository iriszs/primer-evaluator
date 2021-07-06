package nl.bioinf.imgorter.primer_evaluator;

import java.io.FileNotFoundException;

public class PrimerEvaluator {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("In the PrimerEvaluator main");

        for (String arg : args) {
            System.out.println("input arguments are: " + arg);
        }


        String name = args[0];
        int age = Integer.parseInt(args[1]);
        String fileLocation = args[2];
        InputHandler inputHandler = new InputHandler(name, age, fileLocation);
        inputHandler.printInput();
        InputHandler IH = new InputHandler(name, age, fileLocation);
        IH.ReadFile();

    }
}
