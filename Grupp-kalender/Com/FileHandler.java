package Com;

import java.io.*;
import java.util.*;

import Engine.Event;
import java.lang.Exception;

/**
* Filehandler for EventManager
*
* @author Akar
* @version 1.0
*/
public class FileHandler
{
    /*
* A constructor for FileHandler
*/
    public static void writeFile(LinkedList<Event> eventList)
    {
        try {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("events.sav"));
            save.writeObject(eventList);
            save.close();
        }

        catch(Exception e) {
           System.out.println(e.getMessage()); //FÖRSLAG: kanske använda "e.getMessage()" för att faktiskt få undantagets meddelande ... gäller alla undantag

           //Ännu ett förslag: Man kan använda JOptionPane.showMessageDialog() får att få upp en ny ruta med meddelandet
        }
    }

    public static LinkedList<Event> readFile()
    {
    	LinkedList<Event> readObject = null;
        try {
            ObjectInputStream restore = new ObjectInputStream(new FileInputStream("events.sav"));
            readObject = (LinkedList<Event>)restore.readObject();
            restore.close();
        }
        catch(Exception e) {
           System.out.println(e.getMessage());
        }
		return readObject;
    }

}