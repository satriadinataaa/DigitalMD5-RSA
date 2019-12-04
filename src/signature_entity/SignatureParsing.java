/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signature_entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PcKu-Asus
 */
public class SignatureParsing {
   
    public static String returnlast(String lokasi) throws IOException{
        BufferedReader fin = new BufferedReader(new FileReader(lokasi));
        String lastLine=null,kata;
        while ((kata = fin.readLine()) != null) 
        {

            lastLine = kata;
        }
        return lastLine;
    }
     public static String returnexceptlast(String lokasi) throws IOException{
        BufferedReader fin = new BufferedReader(new FileReader(lokasi));
        String previousLine = null;
        String line;
        String kalimat="";
        while ((line = fin.readLine()) != null) {
            if (previousLine != null) {
               kalimat+=previousLine;
            }
            previousLine = line;
            kalimat+="\r\n";
        }
      return kalimat;
     }
    
}
