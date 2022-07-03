Array Operations: Carrots Consumed

David owns a carrot farm.
He placed N baskets in a row with 1 unit space among them.
Each basket contains Ai carrots in it.
A rabbit can cover M units in one jump. He starts from the first basket and then jumps to further baskets until no baskets are left.
Before jumping from a basket, the rabbit eats all the carrots present in that basket.
Find the total number of carrots consumed by the rabbit.

Function Description
In the provided code snippet, implement the provided carrotsConsumed(...) method using the variables to print the total number of carrots consumed by the rabbit. You can write your code in the space below the phrase “WRITE YOUR LOGIC HERE”.

There will be multiple test cases running so the Input and Output should match exactly as provided.
The base Output variable result is set to a default value of -404 which can be modified. Additionally, you can add or remove these output variables.
 
Input Format
The first line of input contains two integers N denotes the number of baskets and M denotes the distance covered by a rabbit in one jump.
The next line of input contains N space-separated integers denoting the number of carrots present in the baskets.

Sample Input
5 2                      --denotes N and M.
2 3 1 4 5             --denotes the number of carrots present in the baskets.

Constraints
1 <= N <= 100, 1 <= M <= N
1 <= Ai <= 109

Output Format
The output contains a single integer denoting the number of carrots consumed by the rabbit.

Sample Output
8
 
Explanation
Initially, the rabbit is at 1st basket and the number of carrots consumed by it will be 2.
Then, it jumps to 1 + 2 = 3rd basket and consumes 1 carrot.
Then, it jumps to 3 + 2 = 5th basket and consumes 5 carrots.
The total number of carrots consumed by the rabbit will be 2+1+5 = 8 carrots.
Skill: Coding - Easy

INPUT	 	EXPECTED OUTPUT
5 2 2 3 1 4 5		8
50 10 46 27 30 33 44 15 44 46 24 7 25 11 4 35 50 22 36 46 21 3 31 19 34 12 19 48 24 24 36 1 18 47 34 1 27 9 1 35 13 49 28 15 19 43 6 26 6 17 32 22		148
100 32 922 938 103 689 526 118 314 496 373 47 224 544 495 656 804 754 269 356 354 536 817 597 787 178 516 659 790 993 786 169 866 779 997 350 674 437 219 546 564 893 402 449 751 628 238 686 392 951 716 439 332 563 215 146 746 311 866 773 548 675 731 183 890 802 488 944 473 25 662 559 732 534 777 144 502 593 839 692 84 337 679 718 1005 663 709 940 86 469 310 960 902 233 606 761 116 231 662 903 68 622		3069
25 7 73 56 65 70 57 57 49 50 65 68 54 48 66 55 55 66 60 70 47 62 63 70 62 70 63		248
47 2 35 79 84 56 67 95 80 34 77 68 14 55 95 32 40 89 58 79 96 66 50 79 35 86 31 74 91 35 22 72 84 38 11 59 73 51 65 11 11 62 30 12 32 71 69 15 11		1261
100 6 51678 28453 32306 18256 83320 38183 15932 75372 2031 79837 40481 46016 6372 80094 84164 39741 18243 70790 22209 38493 22888 38846 47173 62836 11187 3964 23649 67761 60148 70785 27519 63813 77102 44934 40067 29682 82639 18765 22658 26772 2758 84549 9950 51699 71356 52982 79303 80743 39755 41944 8275 37058 28969 12288 4638 25961 66845 76699 71346 38283 27249 28009 71736 25431 22406 33098 32061 14882 26618 76084 40750 84190 7029 2986 73667 10236 25486 41046 6372 80094 84164 39741 18243 70790 22209 38493 22888 38846 47173 62836 11187 40067 29682 82639 18765 22658 26772 2758 84549 9950		404758