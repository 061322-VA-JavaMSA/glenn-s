Strings: Reduce String

Sophia has a string of length N containing lowercase English letters that she wants to write in her notebook.
But she does not want to write the letters which she has already written.
Find the string that Sophia wrote in her notebook.
 
Function Description
In the provided code snippet, implement the provided reduceString(...) method using the variables to print the string Sophia wrote in her notebook. You can write your code in the space below the phrase “WRITE YOUR LOGIC HERE”.

There will be multiple test cases running so the Input and Output should match exactly as provided.
The base Output variable result is set to a default value of -404 which can be modified. Additionally, you can add or remove these output variables.

Input Format
The first line of input contains an integer N.
The second line of input contains a string containing lowercase English letters of length N.

Sample Input
5               -- denotes N
abbac       -- denotes S

Constraints
 1 <= N <= 100
 
Output Format
The output contains the string Sophia wrote in her notebook.
 
Sample Output
abc
 
Explanation
Sophia will write the letters "a" and "b".
As both letters in the third and fourth position are already written now, she will skip them.
At last, she will write the letter "c".
Hence, the final string that she writes is "abc".
Skill: Coding - Easy

INPUT	                EXPECTED OUTPUT

5 abbac	                abc
5 aaaaa					a
13 nwlrbbmqbhcda		nwlrbmqhcda
61 ebgnhamdhnuxbvzlufpkksnbvdsssjdwkkjumxxtntsooraiyrsllimgnhafq  ebgnhamduxvzlfpksjwtoriyq
12 gvwqtyskrgse	        gvwqtyskre
  
12 gvwqtyskrgse	         