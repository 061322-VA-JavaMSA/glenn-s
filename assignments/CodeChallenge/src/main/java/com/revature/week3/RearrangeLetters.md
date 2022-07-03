Strings: Rearrange Letters

You have given a string S which consists of lowercase English letters only.
The frequency of occurrence of each letter can be 2 at max.
You also have to eliminate the letters which have appeared only one time in the string.
Rearrange the letters in the string in such a way that after rearrangement, the distance between the letters in each pair of similar letters will be 0 units and in alphabetical order.
Print the string after performing the mentioned operations. 
 
Note
A string S consists of only lowercase English letters.
A letter can be any letter between "a" to "z".
Every letter in the string cannot appear more than twice.
There will be at least one letter in the string that appears twice.
 
Function Description
In the provided code snippet, implement the provided rearrangeLetters(...) method using the variables to print the resultant string after performing the mentioned operations. You can write your code in the space below the phrase “WRITE YOUR LOGIC HERE”.

There will be multiple test cases running so the Input and Output should match exactly as provided.
The base Output variable result is set to a default value of -404 which can be modified. Additionally, you can add or remove these output variables.

Input Format
The first line contains a string S.
 
Sample Input
abcabcgfeke  -- denotes string S

Constraints
1< S.length() <= 100

Output Format
The output should contain the resultant string. 

Sample Output
aabbccee
 
Explanation
Here, S = abcabcgfeke
The letters which are appeared twice in the given string are "a", "b", "c", "e".
The letters which are appeared only once in the string are "g", "f", "k".
So, eliminate these letters from the resultant string.
Hence, after rearrangement, the string will be “aabbccee” (the resultant string should be in alphabetical order).
Skill: Coding - Easy

INPUT	 			EXPECTED OUTPUT
abcabc	 			aabbcc
ahkh	 			hh
abcddb	 			bbdd
kghg	 			gg
jjfgdhdssurg	 	ddggjjss
klmnek	 			kk