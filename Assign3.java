import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import java.util.*;
import java.lang.*;

public class Assign3{
  public static void main(String[] args)throws Exception{
    Scanner input = new Scanner(new File("input.txt"));
    HashMap<String,Integer> theWords = new HashMap<String,Integer>();

    int count = 0;

    //Reads in the words into the HashMap
    while(input.hasNext()){
      String next = input.next().toLowerCase();
      String word = next.replaceAll("\\p{Punct}", "").toLowerCase();

      if(theWords.containsKey(word) == true){
      theWords.put(word,theWords.get(word) + 1);
      count++;
    }else{
      theWords.put(word,1);
      count++;
    }

    }

    //HashMap is sorted
    HashMap<String,Integer> sorted = sortByValue(theWords);

    PrintWriter output = new PrintWriter("output.txt");

    //Prints out the list of words in the song
    for(String key : sorted.keySet()){
      output.println(sorted.get(key) + ":\t" + key);
    }
    output.println("There are " + count + " words in this song.");

    input.close();
    output.close();

  }

public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
  }
