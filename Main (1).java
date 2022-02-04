import java.util.Scanner; // importing the scanner class to get the input from the user 

class Main { // main method that is used to get the input from the user and display the roman numeral
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); //Initializing the scanner object that is used to get the input from the user 
    

    //initializing variables in order to help determine what type of number is going to be inputed, whether it is a decimal number or a roman numeral
    String typeOfNumber;
    boolean decimal = false;
    
    // loop used to get the type of number the user is going to enter in
    while (true){
      System.out.println("Do you want to enter in a roman numeral or a decimal numbers");
      
      
      typeOfNumber = scan.nextLine();//getting the user input for the type of number that they want to enter in and stores is in a string variable 


      // if the user were to enter in that they want a roman numeral converted the program will go into this if statement
      if (typeOfNumber.equals("roman numeral") ||typeOfNumber.equals("Roman Numeral") || typeOfNumber.equals("roman") ||typeOfNumber.equals("Roman")){
        
        //setting the value of decimal to false, allowing the computer to understand that it is going to get a roman numeral / string. 
        decimal = false;
        break; // breaks out of the while true loop


      // if they entered in they wanted to convert a decimal number the program will go into this else if statement
      } else if (typeOfNumber.equals("Decimal") ||typeOfNumber.equals("decimal")) {
        

        //sets the value of decimal to true, allowing the computer to understand that it is going to get an integer/short value
        decimal = true;
        break;//breaks out of the while true loop
      
      //if the user did not enter either of those statements, the program will go into this else statement, telling them that what they entered was an invalid input
      } else {
 
        System.out.println("Invalid input");
 
      }

    }


    //if they entered a decimal number, that means the decimal boolean value is true, meaning that the program will go into this if statement
    if (decimal){
      while (true){// while true statement used to see if the user entered in a proper integer value
        
        System.out.print("Enter in your number: ");
        short decimalNumber = scan.nextShort();// getting the input from the user on what their decimal number is and storing it into a short variable, some values that I have used that work include 123(CXXIII), 1666(MDCLXVI), and 2567(MMDLXVII)

        // Since traditional roman numerals can only be inputed between 1 - 3999, this checks to see if the user entered in a valid number that can be converted into a roman numeral
        if (decimalNumber < 1 || decimalNumber > 3999){

          System.out.println("Invalid input");

        //if the if statement above is false, that means that the user entered in a valid decimal number, making the program go into this else statement
        } else {

          
          intToRoman num = new intToRoman();//creating a roman numeral object called num in order to use the properties of the intToRoman class and convert the decimal number to a Roman numeral
          
          String result = num.convertToString(decimalNumber);//uses the converToString method in the intToRoman class to convert the short value passed in to a string and storing it in a variable
          System.out.println(result);  //prints the roman numeral back to the user


          break;//breaks out of the while true loop
        }
        
      }

    //if the decimal boolean value is false that means that the user wanted to enter in a roman numeral, thus the program will go into this else statement
    } else {
      while (true){ //this loops the program in order to determine if the user will enter in an appropriate number, otherwise the program will repeat
        
        
        
        System.out.print("Enter in your Roman numeral number: ");
        String romanNumeral = scan.nextLine();//getting the string input from the user on the roman numeral that they are passing in . Some values that you can test are MMXI(2011), MCII (1102)and LVIII (58). 
        romanToInt num = new romanToInt(); //creating a new object from the romanToInt class (located in the convertToInt.java file) to be used as an object to convert the number into a roman numeral

        short convertedDecimalNumber = (short) num.convertToInt(romanNumeral);// assigning a variable to the converted roman numeral using the convertToInt method while passing the roman numeral



        if (num.checkInvalid(romanNumeral) +1 > 3){ //using a method found in the convertToInt.java file, it checks to see if the input is invalid, in this case if they have not followed the proper rules and have used more than 3 of the same character consecutivly 
          System.out.println("Ivalid input, please try again");//tells the user that they have entered an invalid input

        //if they did follow the rules and did not enter in more than 3 of a roman numeral value consecutivly, it will go into this else statement 
        } else {
          
          //this if statement checks to see if the converted decimal value variable is between 1 - 3999, ensuring that the user has entered in a proper roman numeral
          if (convertedDecimalNumber < 1 || convertedDecimalNumber > 3999){
            System.out.println("Invalid input");

          // if the number entered is within the range, the program will go into this else statement to show the user the converted decimal number
          } else {

            System.out.println(convertedDecimalNumber);//prints out the decimal value to the user    
            break; //breaks out of the while true loop
          }

        }


        }
        
    }



  }
}