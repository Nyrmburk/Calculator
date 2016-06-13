package calc;

import java.util.HashSet;

public class VariableSet {

	protected HashSet<VariableToken> variables = new HashSet<VariableToken>();

	public void register(String name) {

		register(name, 0);
	}
	
	public void register(String name, double value) {

		variables.add(new VariableToken(this, name, value));
	}
	
	public Token getToken(int startIndex, char[] input) {

		for (VariableToken variable : variables) {

			if (startsWith(startIndex, variable.name, input)) {

				return get(variable.name);
			}
		}
		return null;
	}
	
	private static boolean startsWith(int startIndex, String phrase,
			char[] checkAgainst) {

		int index = 0;
		char[] phraseChars = phrase.toCharArray();
		while (index < phraseChars.length
				&& index + startIndex < checkAgainst.length) {

			if (phraseChars[index] != checkAgainst[index + startIndex])
				break;
			index++;
		}

		if (index == phraseChars.length)
			return true;

		return false;
	}

	public VariableToken get(String name) {

		for (VariableToken token : variables) {

			if (name.equals(token.name))
				return token;
		}
		return null;
	}
}
