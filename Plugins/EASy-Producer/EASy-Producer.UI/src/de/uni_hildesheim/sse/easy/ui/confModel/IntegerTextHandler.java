package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to handle and format Set of Integers in the Editor.
 * 
 * @author Dennis Konoppa
 *
 */
public class IntegerTextHandler implements IGUITextHandler {

    /**
     * Separator for single integers.
     */
    private static String separator = ", ";
    
    /**
     * Separator for a range of integers.
     */
    private static String rangeSeparator = "-";
        
    @Override
    public String format(String text) throws NumberFormatException {
        String result = text.replaceAll("\\{", "");
        result = result.replaceAll("\\}", "");
        String[] values = result.split(",");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        if (values.length >= 1 && !values[0].equals("")) {
            for (String value: values) {
                String[] parts = value.split("-");
                if (2 == parts.length) {
                    int from = Integer.parseInt(parts[0].trim());
                    int to = Integer.parseInt(parts[1].trim());
                    for (int i = Math.min(from, to), n = Math.max(from, to); i <= n; i++) {
                        numbers.add(i);
                    }
                } else {
                    numbers.add(Integer.valueOf(parts[0].trim()));
                }
            }            
        }
        result = createTextAreaNumbers(numbers);
        
        /////////// TEST OF split-Method /////////////
        // split(result);
        //////////////////////////////////////////////
        return result;
    }

    @Override
    public List<Object> split(String format) throws NumberFormatException {
        String[] values = format.split(", ");
        int rangeIndex = 0;
        int rangeStart = 0;
        int rangeEnd = 0;
        int newNumber = 0;
        String currentValue = "";
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < values.length; i++) {
            currentValue = values[i];
            rangeIndex = currentValue.indexOf(rangeSeparator);
            if (rangeIndex != -1) {
                // Range found. Try to cast into integers
                try {
                    // Try to cast range begin and range end from string to integer
                    rangeStart = Integer.valueOf(currentValue.substring(0, rangeIndex));
                    rangeEnd = Integer.valueOf(currentValue.substring(rangeIndex + 1));
                    // Adding all ports between range borders
                    for (int cRange = rangeStart; cRange <= rangeEnd; cRange++) {
                        newNumber = cRange;
                        numbers.add(cRange);
                    }
                } catch (NumberFormatException exp) {
                    // handle cast errors with ranges
                    throw exp;
                }
            } else {
                // no range found. Try to cast whole value from string to integer
                if (null != currentValue && currentValue.length() > 0) {
                    try {
                        newNumber = Integer.valueOf(currentValue);
                        numbers.add(newNumber);
                    } catch (NumberFormatException exp) {
                        // handle cast errors with simple number
                        throw exp;
                    }
                }
            }
        }
        Collections.sort(numbers);
        ////////// TEST OUTPUT OF NUMBERS FROM THIS METHOD ///////////
        // System.out.println(numbers);
        //////////////////////////////////////////////////////////////
        List<Object> list = new ArrayList<Object>();
        for (Integer number: numbers) {
            list.add(number);
        }
        return list;
    }
    
    /**
     * Method to create format of lists of numbers in the Editor.
     * 
     * @return String with correct format for Editor
     * @param numbers - List of numbers
     */
    public String createTextAreaNumbers(ArrayList<Integer> numbers) {
        StringBuffer st = new StringBuffer();
        int rowBegin = 0;
        int rowEnd = 0;
        int rowCounter = 0;
        int currentNumber = 0;
        boolean started = false;
        for (int i = 0; i < numbers.size(); i++) {
            currentNumber = numbers.get(i);
            // first element
            if (!started) {
                if (numbers.size() == 1) {
                    // list has only 1 element
                    st.append(currentNumber);
                } else {
                    // size > 1 : start range
                    rowBegin = currentNumber;
                    rowEnd = currentNumber;
                    started = true;
                    rowCounter++;
                }
            } else if (started && (i < numbers.size() - 1)) {
                if (currentNumber == (rowEnd + 1)) {
                    // current number extends range: increase counter and set new rowEnd
                    rowEnd = currentNumber;
                    rowCounter++;
                } else if (currentNumber != (rowEnd + 1)) {
                    // current number not in range : finish range
                    if (rowCounter >= 2) {
                        // range >= 2 : adding range with rangeSeperator                         */
                        st.append(rowBegin);
                        st.append(rangeSeparator);
                        st.append(rowEnd);
                        st.append(separator);
                    } else {
                        // range is < 2 : adding just the last number (rowEnd) + ', '
                        st.append(rowEnd);
                        st.append(separator);
                    }
                    // start new range
                    rowBegin = currentNumber;
                    rowEnd = currentNumber;
                    rowCounter = 1;
                }
            } else if (started && (i == numbers.size() - 1)) {
                if (currentNumber == (rowEnd + 1)) {
                    // last element extends range : adding range to StringBuffer
                    st.append(rowBegin);
                    st.append(rangeSeparator);
                    st.append(currentNumber);
                } else if (currentNumber != (rowEnd + 1)) {
                    // last element not in range: finish range and separate last element
                    if (rowCounter >= 2) {
                        // range >= 2: finish range and add last element separately
                        st.append(rowBegin);
                        st.append(rangeSeparator);
                        st.append(rowEnd);
                        st.append(separator);
                        st.append(currentNumber);
                    } else {
                        // range < 2: add rowEnd and last element separately to StringBuffer
                        st.append(rowEnd);
                        st.append(separator);
                        st.append(currentNumber);
                    }
                }
            }
        }
        return st.toString();
    }
    
}
