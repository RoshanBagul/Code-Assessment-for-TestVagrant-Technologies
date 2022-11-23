package maven.maven;

import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class fileReader {
    public static Object obj;
   public static void loadFile() throws IOException, ParseException {

       JSONParser jsonParser = new JSONParser(); // to Parse Json data form Json File

       java.io.FileReader reader = new java.io.FileReader("TeamRCB.json"); //Read the Json file
       obj = jsonParser.parse(reader);

   }
}
