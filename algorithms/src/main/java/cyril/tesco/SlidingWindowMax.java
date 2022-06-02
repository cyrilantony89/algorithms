/* Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID. 

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],    
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3) [resource_3 is accessed at 53760, 54001, and 54060]
most_requested_resource(logs2) # => ('resource_3', 4) [resource_3 is accessed at 1199, 1200, 1201, and 1202]
most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]

Complexity analysis variables:

n: number of logs in the input
 */
package cyril.tesco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowMax {
  
  static class Access implements Comparable<Access>{
    int time;
    String resource;
    
    public int compareTo(Access to){
      return time - to.time;
    }
    
    public String toString(){
      return time + ":"+resource; 
    }
    
  }
  
  static String maxCount(String [][] logs){
    List<Access> list = new ArrayList<>();
    for(int i = 0 ; i < logs.length ; i++){
      Access a = new Access();
      a.time = Integer.parseInt(logs[i][0]);
      a.resource =  logs[i][2];
      list.add(a);
    }
    
    Collections.sort(list);
    
    //System.out.println(list);
    
    
    int size = list.size();
    int startIndex = 0;
    int i = 0;
    
    Map< String, Integer> map = new HashMap<>();
    
    int currentMaxCount = 0;
    String currentMaxresource = null;
    
    while(i < size){
      
      Access current = list.get(i);
      Access movingOut = list.get(startIndex);
          
      if((current.time - movingOut.time) > 300){
        // remove leftest element from sliding-window and adjust count in map   
        map.merge(movingOut.resource, -1 , Integer::sum);
        startIndex++;
        
      } else {
        // add rightest element to sliding-window and add count in map
        map.merge(current.resource, 1 , Integer::sum);
        Integer a = map.get(current.resource);
        // update the currentMaxresource if needed.
        if(currentMaxCount<a){
          currentMaxCount = a;
          currentMaxresource = current.resource;
        }
        i++;
      }
      
    }
    String s = currentMaxresource + " "+ currentMaxCount;
    System.out.println(s);
    return s;  
    
  }
  
  public static void main(String[] argv) {
    String[][] logs1 = new String[][] {
    { "58523", "user_1", "resource_1" },
    { "62314", "user_2", "resource_2" },
    { "54001", "user_1", "resource_3" },
    { "200", "user_6", "resource_5" },
    { "215", "user_6", "resource_4" },
    { "54060", "user_2", "resource_3" },
    { "53760", "user_3", "resource_3" },
    { "58522", "user_22", "resource_1" },
    { "53651", "user_5", "resource_3" },
    { "2", "user_6", "resource_1" },
    { "100", "user_6", "resource_6" },
    { "400", "user_7", "resource_2" },
    { "100", "user_8", "resource_6" },
    { "54359", "user_1", "resource_3"}
};

    String[][] logs2 = new String[][] {
        {"300", "user_1", "resource_3"},
        {"599", "user_1", "resource_3"},
        {"900", "user_1", "resource_3"},
        {"1199", "user_1", "resource_3"},
        {"1200", "user_1", "resource_3"},
        {"1201", "user_1", "resource_3"},
        {"1202", "user_1", "resource_3"}
    };

    String[][] logs3 = new String[][] {
        {"300", "user_10", "resource_5"}
    };
    
    
    maxCount(logs1);
    maxCount(logs2);
    maxCount(logs3);
    

  }
}
