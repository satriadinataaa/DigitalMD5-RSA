/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author PcKu-Asus
 */
public class TextController {
    
   public String getFile()
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
        jfc.setFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);   
       
        int returnValue =  jfc.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            return path;

        }
        else{
            return "wrongpath";
        }
    }
   public String saveFile(){
       JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
        jfc.setFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            path+=".txt";
            return path;
        }
        else{
            return "wrongpath";
        }
   }
    
}
