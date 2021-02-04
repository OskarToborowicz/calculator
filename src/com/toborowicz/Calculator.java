package com.toborowicz;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);
        String typePath = myObj.nextLine();
        Path path = Paths.get(typePath);
        int lines = Files.readAllLines(path).size();

        if (Files.readAllLines(path).size() > 0){
        String result = Files.readAllLines(path).get(lines-1).replaceAll("apply", "");
        for (int i = 0; i < lines -1; i++) {
            String linia = Files.readAllLines(path).get(i);
            result += linia;
        }

        String finalString = convertToCharacter(result);
        System.out.println(finalString);
        String[] operators=finalString.split("[0-9]+");
        String[] operands=finalString.split("[-+/*]");
        int calculate = Integer.parseInt(operands[0]);
        for(int i=1;i<operands.length;i++){
            switch (operators[i]) {
                case "+" -> calculate += Integer.parseInt(operands[i]);
                case "-" -> calculate -= Integer.parseInt(operands[i]);
                case "*" -> calculate *= Integer.parseInt(operands[i]);
                case "/" -> calculate /= Integer.parseInt(operands[i]);
            }
        }
            System.out.println(calculate);
        } else {
            System.out.println("File is empty");
        }


    }
    public static String convertToCharacter(String str){
        return str.replaceAll("add", "+").
                replaceAll("subtract", "-").
                replaceAll("multiply","*").
                replaceAll("divide", "/").
                replaceAll(" ", "");
    }
}
