import java.util.List;

public class Formatter {

    public  String format(List<String> parsedLine, String sep)
    {
        StringBuilder result = new StringBuilder();
        for (String ch : parsedLine){
            result.append(ch.length());
            if(!parsedLine.get(parsedLine.size()-1).equals(ch)) {
                result.append(sep);
            }
        }
        result.append('\n');
        return  result.toString();
    }
}
