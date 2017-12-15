import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexico {

	private String input;
	private ArrayList<Token> identifiedToken = new ArrayList<Token>();
	
	public Lexico(String input) {
		this.setInput(input);
	}
	
	public void analyze() {
		String currentToken = "";
		Token token = null;
		Token lastToken = null;
		for (char ch : input.toCharArray()) {
			currentToken += ch;
			token = identifyToken(currentToken);
			if (token == null) {
				lastToken = identifyToken(currentToken.substring(0, currentToken.length() - 1));
				if (lastToken != null) {
					identifiedToken.add(lastToken);
					currentToken = currentToken.substring(currentToken.length()-1);
					System.out.println("Encontrou " + lastToken.getType() + ": " + lastToken.getValue());
				}
			}
		}
		if (token != null) {
			identifiedToken.add(token);
			System.out.println("Encontrou " + token.getType() + ": " + token.getValue());
		}
	}
	
	public Token identifyToken(String token) {
		String readToken;
		if ( (readToken = isStackIdentifier(token)) != null) {
			return new Token("identifier", readToken);
		}
		if ( (readToken = isNumber(token)) != null) {
			return new Token("number", readToken);
		}
		if ( (readToken = isOperator(token)) != null) {
			return new Token("operator", readToken);
		}
		return null;
	}
	
	public String isStackIdentifier(String token) {
		Pattern p= Pattern.compile("^[a-z@]$");
        Matcher m = p.matcher(token);
        if (m.find()) {
        	return m.group();
        } else {
        	return null;
        }
	}
	
	public String isNumber(String token) {
		Pattern p= Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(token);
        if (m.find()) {
        	return m.group();
        } else {
        	return null;
        }
	}
	
	public String isOperator(String token) {
		Pattern p= Pattern.compile("^[\\>\\<\\+\\-\\?]$");
        Matcher m = p.matcher(token);
        if (m.find()) {
        	return m.group();
        } else {
        	return null;
        }
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}


}
