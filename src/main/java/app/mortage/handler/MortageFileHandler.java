package app.mortage.handler;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class MortageFileHandler {
    MortageDataManager manager;

    public MortageFileHandler(MortageDataManager manager){
        this.manager = manager;
    }

    public void readFile(Path path) {
        boolean firstLineRead = false;
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line;
            while ((line = br.readLine()) != null) {

                /*
                * \\p{L} matches any letter character, including accented characters.
                * \\p{N} matches any digit character.
                * \\s matches any white space character
                * \\, matches any comma
                * \\. matches any dot
                * The ^ inside the square brackets means "not"
                *
                * Anything that doesn't meet the above conditions is removed.
                **/
                line = line.replaceAll("[^\\p{L}\\p{N}\\s\\,\\.]", "");
                String[] parts = line.split(",");

                if (firstLineRead && parts.length >= 4) {
                    if(parts.length > 4) {
                        parts = parseArray(parts);
                    }
                    //TODO Exception handling
                    manager.addMortage(parts);
                } else {
                    firstLineRead = true;
                }
            }
        } catch (NoSuchFileException e){
            System.err.println("File not found " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] parseArray(String[] array){
        StringBuilder builder = new StringBuilder();
        String[] parsedArray = new String[4];
        int currentIndex = 0, parsedArrayIndex = 1;

        for(String str: array){
            if(!NumberUtils.isParsable(str)){
                builder.append(str);
                builder.append(" ");
                currentIndex++;
            }
            else{
                break;
            }
        }
        parsedArray[0] = builder.toString().trim();
        for(int i = currentIndex; i < array.length; i++){
            //TODO exception if index goes past 3 for parsedArrayIndex before an insertion to the array.
            parsedArray[parsedArrayIndex++] = array[i];
        }
        return parsedArray;
    }
}
