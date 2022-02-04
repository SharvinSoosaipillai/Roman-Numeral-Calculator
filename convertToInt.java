class romanToInt{//initializing a class of roman to integer which is a class ment to take a given roma numeral string and convert it to an integer


  //initializing private short decimal value once the object is created to be used to increasae the objects decimal value and return the decimal value of a roman number after the conversion 
  private short decimalValue = 0;
  
  public short convertToInt(String romanNumber){ //public method called convertToInt which essentially converts the roman numeral to an integer value, it is also used to acess the private decimalValue variable. it takes a string parameter (which is the roman numeral) and returns a short value (which is the decimal value)
  
    //what this line of code is doing is creating a 2D array which acts like a dictionary for all of the single character roman numerals, essentially creating a dictionary for the values of all singular roman numerals, this is done to find the absolute value of the roman numeral without having to worry about the subtraction rules for roman numerals. By making an objects dictionary, it is able to store different data types such integers and chars and allow them to be used to determine the value of the roman numeral before subtraction rules. The elements in this dictionary comprise of a value along with their corrisponding roman numeral
    Object [][] singleCharacters = {{1000, 'M'},{500, 'D'},{100, 'C'},{50, 'L'},{10, 'X'}, {5, 'V'},{1, 'I'}};

    //what this line of code does is create an instance 2d array which acts like a dictionary that stores that values of the values that are used to decrement the decimal number. This dictionary will be used later on to see if the roman numeral string passed in contains one of these special instances. This 2d array stores the correct value that should be decremented from the roman numeral
    Object [][] twoCharacters = {{200, "CM"}, {200, "CD"}, {20, "XC"},{20, "XL"}, {2, "IX"},{2, "IV"}};



    // the first thing that needs to be done is to find the absolute value of the roman numeral by adding up all of the characters, to do this the for loop below goes through the length of the roman numeral in order to add each character
    for (int i = 0; i < romanNumber.length(); i++){ 
      //inside this for loop is another for loop for loop, which goes through the length of the single characters 2d array, this is used to see what character is at the same index of the string passed in 
      for (int x = 0; x < singleCharacters.length; x++){

        // this if statement checks to see if the character at a specific index is equal to a character inside of the single characters dictionary, if it is, it adds that corrisponding integer value to the private decimalValue variable 
        if (romanNumber.charAt(i) == (char) singleCharacters[x][1]){
          decimalValue += (int) singleCharacters[x][0]; //incrementing the decimal value variable by the appropriate amount
        }
      }
    }

    //once there is an absolute value, we must decrement the roman numeral by looking to see if there are any special subtraction rules that are taking place, to do this, we look at the twoCharacters 2d array to see if the string is located inside the array and the romanNumeral passed in

    //this for loop loops to the length of the twoCharacters 2d array to determine if any subtraction rules take place
    for (int y = 0; y < twoCharacters.length; y++){
      String specialSequence = (String) twoCharacters[y][1];//creating a variable that is used to take the string value at the current index of the twoCharacters list
      if (romanNumber.contains(specialSequence)){ //using the .contains method of the string class, this checks to see if the special sequence is present in the roman numeral passed in. If it is, then it goes into this if statement
        decimalValue -= (int) twoCharacters[y][0];//decrements the roman numeral by the corrisponding integer value at the same index
      }
    }

  
    return decimalValue;//returns the appropriate decimal value as a short value
  }




  public int checkInvalid(String romanNumeral){ //in case if the user were to enter in more than one of the same roman numeral, this method is used to check if they do so
    int maximum = 0;// integer value used to keep track of the number of times the character has been repeated


    //for the length of the roman numeral, this loop will repeat in order to check if there is more than 3 consecuitive characters
    for (int i = 1; i < romanNumeral.length(); i++){ 
      int count = 0;//the conunt value is used to check if the character is consecuitive and if the character is not consecuitive, when the loop comes back to the beginning, this value is reset to look at the next character

      // this while loop is used to count the amount of times the character shows up, it does this by taking a look at the current index of the string and the previous index to see if they are the same, it does this as long as the value of i (from the for loop) is less then the length of the string 
      while (i < romanNumeral.length() && romanNumeral.charAt(i -1) == romanNumeral.charAt(i)){
        //if the code enters this while loop, that means that there is a consecuitive character, it then adds one to the counter to count the consecuitive charactes and 1 to the value of i to make it keep on checking the other characters 
        count++;
        i++;
        maximum = Math.max(count,maximum);//sets the variable maximum to one of the 2 numbers, count or maximum(the current value), whichever number is bigger is what value is set to maximum

      }
    }
    
    return maximum; //returns an integer value used to determine how many consecuitive characters there are
  }

  
}