/*
Enter your query here.
*/

select   
CASE
    WHEN g.grade < 8 THEN NULL
    ELSE s.name 
END AS usn
, g.grade , s.marks  from Students s  
left join Grades g on  marks >= min_mark and marks <= max_mark
   Order by grade desc,s.name 
   
/*   
Name, Grade and Mark
grade lower than 8
grade desc
same grade (8-10) assigned to them, order those particular students by their name alphabetically
  
select grade, min_mark, max_mark from Grades  
select name , marks from Students s  order by id  
 
11 Britney 95
12 Dyana 55
13 Jenny 66
14 Christene 88
15 Meera 24
16 Priya 76
17 Priyanka 77
18 Paige 74
19 Samantha 87
19 Jane 64   
   */
   
/*
 * 
Britney 10 95 
Heraldo 10 94 
Julia 10 96 
Kristeen 10 100 
Stuart 10 99 
Amina 9 89 
Christene 9 88 
Salma 9 81 
Samantha 9 87 
Scarlet 9 80
Vivek 9 84 
Aamina 8 77 
Belvet 8 78 
Paige 8 74 
Priya 8 76 
Priyanka 8 77  
NULL 7 64 
NULL 7 66 
NULL 6 55 
NULL 4 34 
NULL 3 24
 */   