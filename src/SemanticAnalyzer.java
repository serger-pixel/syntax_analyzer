import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalyzer {
    public static HashMap<String, String> tableValue = new HashMap<>();

    public static String noValue = "-";


    public static Boolean createTable(String program){
        int endDeclaration = program.indexOf(";");
        int startDeclaration = 0;
        String declaration = program.substring(startDeclaration, endDeclaration);
        Pattern pattern = Pattern.compile(LexicalAnalyzer.regexIdentifier);
        Matcher matcher = pattern.matcher(declaration);
        matcher.results();
        while(matcher.find()){
            if (tableValue.containsKey(matcher.group())){
                return false;
            }
            tableValue.put(matcher.group(), noValue);
        }
        return true;
    }


}
