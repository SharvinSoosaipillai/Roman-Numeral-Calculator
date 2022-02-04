class intToRoman{//creating the into to roman class which is responsible for convertin integer values to roman numerals
  
  
  private String romanNumber = ""; //once the object is initialized, a private string variable is created that is only accessible through the convertToString method in this class. Currently this string is empty and holds no value, that way when the method is used, this string value is updated and shown back the the user


  public String convertToString(short number){// new class method called convertToString which takes on a short integer value passed in, this method is used to take the integer that is passed in and convert it to a roman numeral
    

    
    //Once the method is called this 2d array is created called dictionary. It is an object array which allows it to store multiple different data types, in this case, it is being used to store an integer value as well as a string value. It has no encapsulation methods as this variable is created once the method is called. This 2D array store all of the possible decimal values along with their corresponding roman numeral value (example, 1000 = M), in decending order. It also holds values that are effected by the subtraction rule such as 900 (CM), in order to check for any eceptions. It is done this way to decrement the integer value passed in by a certain amount until it can't decrement the number any more
    Object [][] dictionary = {{1000, "M"}, {900, "CM"},{500, "D"},{400, "CD"},{100, "C"},{90, "XC"},{50, "L"},{40, "XL"},{10, "X"}, {9, "IX"},{5, "V"}, {4, "IV"},{1, "I"}};
    
    for (int i = 0; i < dictionary.length; i++){ //creating a for loop to loop through the length of the dictionary, that way the program is able to check each instance in the dictionary on whether or not that value passed in can be subtracted from another value in the dictionary

      while (number >= (int) dictionary[i][0]){// this while loop is used to check to see if the current short number value is bigger than the current integer index value of the dictionary. If the number is bigger than the current integer index value, that means that the number in the dictionary index value can be subtracted from the decimal number passed in, and that the corresponding roman numeral in the 2d array can be added to the roman numeral string that was initialized once the intToRoman object was created

        romanNumber += dictionary[i][1]; //concantonating the roman number string with the corresponding roman numeral 
        number -= (int) dictionary[i][0];// decrementing the number passed in by the corresponding integer value of the roman numeral

      //process is repeated until the number passed in can no longer be subtracted by the corresponding roman numeral, in which case it moves on to check if the next highest roman numeral can fit into the current value of the number (which has been decremented)

      }
    }
    
    return romanNumber;//returns the roman numeral string value that was made through the convert to string method
  }
}