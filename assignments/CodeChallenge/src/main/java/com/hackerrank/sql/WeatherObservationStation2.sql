/*
Enter your query here.
*/
select round(sum(t.lat_n),2) as lat,round(sum(t.long_w),2) as lon from STATION  t  