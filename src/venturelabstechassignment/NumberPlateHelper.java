package venturelabstechassignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *Provides functionality for the number plates functions
 * @author dkabii
 */
public class NumberPlateHelper 
{
    private static int LAST_NUM_COUNT=10; //car difference from the plate's third letter 0..9
    private static int SECOND_NUM_COUNT=100; //car difference from the plate's third letter 00..99
    private static int FIRST_NUM_COUNT=1000; //car difference from the plate's third letter 000..999
    private static int THIRD_LETTER_COUNT=26*FIRST_NUM_COUNT; //car difference from the plate's third letter A 000..Z 999
    private static int SECOND_LETTER_COUNT=26*THIRD_LETTER_COUNT; //car difference from the plate's third letter AA 000..ZZ 999
    private static int END_LETTER_COUNT=26*THIRD_LETTER_COUNT; //car difference from the plate's third letter AA 000A..ZZ 999Z
    //finds the first match of a kenyan number plate and prints it
    public static void searchRegistrationNumber(String str)
    {
        Pattern pattern=Pattern.compile("\\b[K][A-Z][A-Z]\\s[\\d][\\d][\\d][A-Z]\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // first plate only
        if (matcher.find()) 
        {
            System.out.println(matcher.group());
        }
        else
        {
            System.out.println("There is not valid Kenyan number plate in the sentence.");
        }
    }
    //determines if provided string is a valid Kenyan registration number
    private static boolean isRegistrationNumber(String str)
    {
        Pattern pattern=Pattern.compile("\\b[K][A-Z][A-Z]\\s[\\d][\\d][\\d][A-Z]\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.find()&&str.length()==8;
    }
    private static int getCarsBoughtBefore(String str)
    {
        int bought=0;
        if(isRegistrationNumber(str))
        {
            int fromNumbers=Integer.parseInt(str.substring(4,7));
            String strUpper=str.toUpperCase();
            int thirdCharIndex=(strUpper.charAt(2)-'A');
            int secondCharIndex=(strUpper.charAt(1)-'A');
            int endCharIndex=(strUpper.charAt(7)-'A');
            bought=fromNumbers+(thirdCharIndex*THIRD_LETTER_COUNT)
                    +(secondCharIndex*SECOND_LETTER_COUNT)+(endCharIndex*END_LETTER_COUNT);
        }
        return bought;
    }
    public static void getCarsBetweenPlates(String plate1,String plate2)
    {
        int carCount=-1;
        if(isRegistrationNumber(plate1)&&isRegistrationNumber(plate2))
        {
            int plate1CarsBefore=getCarsBoughtBefore(plate1);
            int plate2CarsBefore=getCarsBoughtBefore(plate2);
            carCount=Math.abs(plate1CarsBefore-plate2CarsBefore);
            System.out.println("Number of cars between "+plate1+" and plate2: "+carCount);
        }
        else
        {
            System.out.println("Ensured you have entered valid plates: ");
        }
    }
}
