import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class phoneBook {

    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        ArrayList<Integer> phoneNums = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNums.add(phoneNum);
        phoneBook.put(name, phoneNums);
    }

    public ArrayList<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public static void printPhoheBookSortOnDec(){
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(phoneBook.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2){
                return o2.getValue().size() - o1.getValue().size();
            }
        });

        for(Map.Entry<String, ArrayList> entry: list)   {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

public class printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            name1 = "Яцыно";
            name2 = "Дьяков";
            phone1 = 3752945892145;
            phone2 = 6375445896321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        phoneBook myPhoneBook = new phoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        // System.out.println(phoneBook.getphoneBook());
        phoneBook.printPhoheBookSortOnDec(); 
    }
}
