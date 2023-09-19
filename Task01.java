import java.util.*;
import java.util.logging.Logger;



public class Task01 {
    private static Map<String, List<String>> phoneNote = new HashMap<>();

    public static void main(String[] args) {
        int menuOption = 1;

        String fio = "";
        String phone = "";
        while (menuOption > 0){
            menuOption = menu();

            switch (menuOption){
                case 1:
                    fio = readStrConsole("ФИО: ");
                    phone = readStrConsole("Номер: ");
                    setPhone(fio, phone);
                    break;
                case 2:
                    fio = readStrConsole("ФИО: ");
                    List<String> phones = getPhones(fio);
                    if(phones.size() == 0) {
                        printLog("Абонент не найден!");
                    }else {
                        printLog(phones.toString());
                    }
                    break;
            }
        }

    }


    public static List<String> getPhones(String fio) {
        return phoneNote.getOrDefault(fio, new ArrayList<>());
    }


    public static void setPhone(String fio, String phoneNumber) {
        if (phoneNote.containsKey(fio)) {
            if (!phoneNote.get(fio).contains(phoneNumber)) {
                phoneNote.get(fio).add(phoneNumber);
            }
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            phoneNote.put(fio, phoneList);
        }
    }


    public static void printLog(String message){
        Logger logger = Logger.getAnonymousLogger();
        logger.info(message);
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int readIntConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }


    public static String readStrConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    }


    public static int menu(){
        System.out.println("1 - добавить запись");
        System.out.println("2 - найти телефон");
        System.out.println("0 - выход");
        return readIntConsole(">");
    }

}