package com.mycompany.taskmangmentproject;

/**/
/**
 *
 * @author noran
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class File_Handler {
    
    public void createFile( String fileName)
    {
        try {
             File file = new File( fileName);
            if (file.createNewFile()) {
                System.out.println("File created: "
                                   + file.getName());
            }
            else 
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred." + e.getMessage());
                                            }
    }
    public void createFile( File file)
    {
        try {
            if (file.createNewFile()) {
                System.out.println("File created: "
                                   + file.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred." + e.getMessage());
                                            }
    }
    
    public void readFile(String fileName)
        {
            File file = new File(fileName); 
            try (Scanner Reader = new Scanner(file)) 
            {
                while (Reader.hasNextLine()) {
                    String lines = Reader.nextLine();
                    System.out.println(lines);
                }
            }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred." + e.getMessage());
                                                             }
       }
    public void readFile(File file)
    {
        try (Scanner Reader = new Scanner(file)) 
            {
                while (Reader.hasNextLine()) {
                    String lines = Reader.nextLine();
                    System.out.println(lines);
                }
            }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred." + e.getMessage());
        }
    }
    
    public void deleteFile(String filename)
        {
            File file = new File(filename);
        if (file.delete()) 
        {
            System.out.println("The deleted file is : "
                               + file.getName());
        }
        else 
        {
            System.out.println(
                "Failed in deleting the file.");
        }
    
    }
    
    public void deleteFile(File file)
    {
          if (file.delete()) 
          {
            System.out.println("The deleted file is : "
                               + file.getName());
        }
        else
         {
            System.out.println(
                "Failed in deleting the file.");
        }
    }
     public void writeToFile(String fileName, String content, boolean append) 
     {
        try (FileWriter writer = new FileWriter(fileName, append)) 
        {
            writer.write(content);
            writer.write(System.lineSeparator());
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }  
    }
     
     public void updateFile(String oldFileName, String newFileName)
     {
            File oldFile = new File(oldFileName);
        if(!oldFile.exists())
        {
            System.out.println("File not found");
            return;
        }
        if(oldFile.renameTo(new File(newFileName)))
        {
            System.out.println("file renamed: " + newFileName);
        } 
        else 
        {
            System.out.println("Error renaming the file");
        }
     }
     public void updateFile(File oldFile, File newFile)
     {
            
        if(!oldFile.exists())
        {
            System.out.println("File not found");
            return;
        }
        if(oldFile.renameTo(newFile))
        {
            System.out.println("New file: : " + newFile);
        } 
        else 
        {
            System.out.println("Error updating the file");
        }
     }
     
     public boolean searchforFile(String fileName)
     {
         File file = new File(fileName);
        return file.exists();
     }
      public boolean searchforFile(File file)
      {
        return file.exists();
      }
      
    public ArrayList<String> returnFileList(int count, String prefix) throws InterruptedException {
    ArrayList<String> existingFiles = new ArrayList<>();

    for (int i = 0; i <= count; i++)
    {
        String fileName = prefix + i + ".txt";

        if (searchforFile(fileName)) 
        {
            existingFiles.add(fileName);
        }

        Thread.sleep(1000); 
    }

    return existingFiles;
}


      
   public void deleteLinebyIndex(String fileName, int lineIndex) {
    File file = new File(fileName);
    File tempFile = new File("temp_" + fileName);

    try (Scanner scanner = new Scanner(file);
         FileWriter writer = new FileWriter(tempFile)) {

        int currentIndex = 0;
        boolean lineDeleted = false;

        System.out.println("Deleting line at index: " + lineIndex);

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            if (currentIndex != lineIndex) {
                writer.write(currentLine + System.lineSeparator());
            } else {
                System.out.println("Line deleted: " + currentLine);
                lineDeleted = true;
            }
            currentIndex++;
        }

        writer.close();

        if (!lineDeleted) {
            System.out.println("No line found at index: " + lineIndex);
            tempFile.delete();
            return;
        }

        // proper deletion and renaming
        if (file.delete()) {
            System.out.println("Original file deleted.");
            if (tempFile.renameTo(file)) {
                System.out.println("Temporary file renamed to original file.");
            } else {
                System.out.println("Failed to rename temporary file.");
            }
        } else {
            System.out.println("Failed to delete the original file. Retrying...");
            Thread.sleep(100);
            if (!file.delete()) {
                System.out.println("Failed to delete the original file on retry.");
            }
        }

    } catch (IOException | InterruptedException e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}


   }
