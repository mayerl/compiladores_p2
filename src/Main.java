import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		String in = "a>b>10";
		
		Lexico analisadorLexico = new Lexico(in);
		analisadorLexico.analyze();
		
	}

}
