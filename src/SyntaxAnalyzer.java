import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public  class SyntaxAnalyzer {
    //Таблица нетерминалов
    private static LinkedHashMap<String, String> notTerminals = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("A", "<Цифра>"),
            Map.entry("B", "<Конст>"),
            Map.entry("C", "<Конст'>"),
            Map.entry("D", "<Идент>"),
            Map.entry("E", "<Идент'>"),
            Map.entry("F", "<Ун. оп.>"),
            Map.entry("G", "<Бин. оп.>"),
            Map.entry("H", "<Буква>"),
            Map.entry("I", "<Программа>"),
            Map.entry("J", "<Объявление переменных>"),
            Map.entry("K", "<Описание вычислений>"),
            Map.entry("L", "<Список переменных>"),
            Map.entry("M", "<Список переменных'>"),
            Map.entry("N", "<Присваивание>"),
            Map.entry("O", "<Список операторов>"),
            Map.entry("P", "<Оператор>"),
            Map.entry("Q", "<Выражение>"),
            Map.entry("R", "<Выражение'>"),
            Map.entry("S", "<Операнд>"),
            Map.entry("T", "<Операнд'>"),
            Map.entry("U", "<Выбор>"),
            Map.entry("V", "<Список выбора>"),
            Map.entry("W", "<Список выбора'>")
    ));

    //Группы правил
    private enum GROUPS{
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }


    //Таблица переходов
    private static LinkedHashMap<String, List<String>> jumpTable = new LinkedHashMap<>();

    private static void createJumpTable(){
        jumpTable.put("BEGIN,K", List.of("S0", "END", "O")); 
        jumpTable.put("VAR,J", List.of("S0", ";INTEGER:", "L"));
        jumpTable.put(",,M", List.of("S0", "M", "D", ","));
        jumpTable.put("(,T", List.of("S0", ")", "Q", "("));
        jumpTable.put("WRITE,P", List.of("S0", ";", "L"));
        jumpTable.put("READ,P", List.of("S0", ";", "L"));
        jumpTable.put("CASE,P", List.of("S0", ";END_CASE", "V", "OF", "Q"));
        jumpTable.put("~,F", List.of("S0", "e"));
        jumpTable.put("+,G", List.of("S0", "e"));
        jumpTable.put("/,G", List.of("S0", "e"));
        jumpTable.put("-,G", List.of("S0", "e"));

        for (char c = '0'; c <= '9'; c++) {
            jumpTable.put(c + ",A", List.of("S0", "e"));
        }

        for (char c = 'a'; c <= 'z'; c++) {
            jumpTable.put(c + ",H", List.of("S0", "e"));
        }
    }
}
