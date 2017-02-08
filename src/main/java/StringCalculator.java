public class StringCalculator {

    public static final String DEFAULT_DELIMITER_EXPRESSION = ",|\\n";

    public static int add(String inString) {
        String delimiterExpression = DEFAULT_DELIMITER_EXPRESSION;
        if (isOptionalDelimiterParameterPresent(inString)) {
            delimiterExpression = delimiterExpression.concat("|").concat(retrieveOptionalDelimiter(inString));
            inString = removeOptionalDelimiterParameterFromInput(inString);
        }
        if (inString.length() == 0) {
            return 0;
        }
        return sumOfValues(delimiterExpression,inString);
    }

    private static boolean isOptionalDelimiterParameterPresent(String numbersString) {
        return (numbersString.startsWith("//;\n"));
    }

    private static String retrieveOptionalDelimiter(String numbersString) {
        return String.valueOf(numbersString.charAt(2));
    }

    private static String removeOptionalDelimiterParameterFromInput(String numbersString) {
        return numbersString.substring(4);
    }

    private static int sumOfValues(String delimiter, String numbersString) {
        int sumOfIntegers = 0;
        for (String number : (numbersString.split(delimiter))) {
            sumOfIntegers = sumOfIntegers + getValueOfNumber(number);
        }
        return sumOfIntegers;
    }

    private static int getValueOfNumber(String element) {
        try {
            System.out.println("parsing '" + element + "' for value.");
            return Integer.parseInt(element);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
