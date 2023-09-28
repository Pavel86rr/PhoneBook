import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook{




    public static void main(String[] args){
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        addContact(phoneBook,"Рыжков", "444-02-04");
        addContact(phoneBook,"Красикова","210-01-23");
        addContact(phoneBook,"Рыжков", "454-67-89");
        addContact(phoneBook,"Каткова", "131-65-43");
        addContact(phoneBook,"Каткова", "777-65-43");
        printPhoneBook(phoneBook);
    }




    public static void addContact(HashMap<String, ArrayList<String>> phoneBook,String name, String phoneNumber){
        if (phoneBook.containsKey(name)){
            phoneBook.get(name).add(phoneNumber);

        } else {        
            ArrayList<String> phoneNumbers = new ArrayList <>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }



    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook){
        HashMap<Integer, ArrayList<String>> sortedPhoneBook = new HashMap<>();

        for (String name : phoneBook.keySet()) {
            int numOfPhoneNumbers = phoneBook.get(name).size();
            if (sortedPhoneBook.containsKey(numOfPhoneNumbers)) {
                sortedPhoneBook.get(numOfPhoneNumbers).add(name);
            } else {
                ArrayList<String> names = new ArrayList <>();
                names.add(name);
                sortedPhoneBook.put(numOfPhoneNumbers, names);
            }
        }
        List<Integer> sortedKeys = new ArrayList<>(sortedPhoneBook.keySet());
        sortedKeys.sort(Collections.reverseOrder());

        for(int key : sortedKeys){
            ArrayList<String> names = sortedPhoneBook.get(key);
            for(String name : names){
                System.out.println(name + ": " + key + " phone numbers(s)");
            }
        }
    }
}