public class StringCalculator {

    public static int add(String numbersString) {
        if (numbersString.length() == 0) {
            return 0;
        }
        String delimiter = ",|\\n";
        if (isOptionalDelimiterParameterPresent(numbersString)) {
            delimiter = delimiter.concat("|").concat(retrieveOptionalDelimiter(numbersString));
            numbersString = removeOptionalDelimiterParameterFromInput(numbersString);
        }
        return sumOfValues(delimiter,numbersString);
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
            System.out.println("parsing " + element);
            return Integer.parseInt(element);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
