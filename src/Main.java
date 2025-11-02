import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {

        String program =
                "VAR a, b:INTEGER;\n" +
                "BEGIN\n" +
                "CASE (a+b) OF " +
                        "4: " +
                        "c = (1 + (10));" +
                        "3:" +
                        "a = 2; " +
                        "END_CASE;\n"+
                "READ(a, b, c);\n"+
                "WRITE(a, b, c);\n"+
                "END";

        Boolean result = SyntaxAnalyzer.check(program);
        System.out.println(result);
    }
}
