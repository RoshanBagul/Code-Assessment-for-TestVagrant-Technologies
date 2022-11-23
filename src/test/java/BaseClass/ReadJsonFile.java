package BaseClass;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile extends fileReader {
     public static String Wicketkeeper;
     public static String foreignPlayers;
     public static String IndianPlayers;
     public static Object obj;
    public void validateTest() throws IOException, ParseException {
        fileReader.loadFile();
        obj= super.obj;

        JSONObject RCBJsonobj = (JSONObject) obj; // Fetch the JsonObject and storing as a String

        String Tname = RCBJsonobj.get("name").toString();
        String location = RCBJsonobj.get("location").toString();

        System.out.println("name of the Team is = " + Tname);
        System.out.println("Location of the team is = " + location);
        System.out.println("**************************************");
/////////////////////////////////////////////////////////////////////////////////////////

        JSONArray array = (JSONArray) RCBJsonobj.get("player"); // Fetch the JsonObject from the Array and Extract them

        for (int i = 0; i < array.size(); i++)
        {
            JSONObject address = (JSONObject) array.get(i);
            if (array.get(i).toString().contains("Wicket-keeper"))  // To found the count of Wicket-keeper
            {
                Wicketkeeper = address.get("name").toString();
                System.out.println("one Wicket-keeper name is = " + Wicketkeeper);
            }
        }
        System.out.println("****************************");

///////////////////////////////////////////////////////////////////////////////////////////

        int count = 0;

        for (int i = 0; i < array.size(); i++)
        {
            JSONObject address = (JSONObject) array.get(i);

            if (array.get(i).toString().contains("India"))
            {
                IndianPlayers = address.get("name").toString(); //fetch the name of Foreign Players
               // System.out.println("Indian players are = "+ IndianPlayers );
            }
            else
            {
                foreignPlayers = address.get("name").toString();  //fetch the name of Foreign Players
                System.out.println("Foreign players are = "+ foreignPlayers);
                count++;
            }
        }
        System.out.println("Total Foreign players are = "+ count); //User to count Total Foreign Players
    }


    public static void main(String[] args) throws IOException, ParseException {
        ReadJsonFile obj = new ReadJsonFile();
        obj.validateTest();

    }
}

