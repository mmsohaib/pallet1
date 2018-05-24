
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rm214s
 */
public class folderCreater {

    public static void main(String args[])
    {
        createFolder("hilton");
    }
    
    public static void createFolder(String language)
    {
        try
        {
            // Create one directory
            boolean langFolder;
            boolean XMLfolder;

            // Create multiple directories
            langFolder = (new File(language)).mkdirs();
            XMLfolder = (new File(language + File.separator + "XML")).mkdirs();
            
            if (langFolder && XMLfolder)
            {
                System.out.println("Directories: " + language + " created");
            }
            else if((langFolder && XMLfolder) == false )
            {
                System.out.println("Directories: " + language + " already exists.");
            }
        }
        catch (Exception e)
        {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
