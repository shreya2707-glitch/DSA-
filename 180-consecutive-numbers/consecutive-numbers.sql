WITH ConsecutiveLogs AS (
    SELECT 
        num,
        LEAD(num, 1) OVER (ORDER BY id) AS next_num,
        LEAD(num, 2) OVER (ORDER BY id) AS after_next_num
    FROM Logs
)
SELECT DISTINCT num AS ConsecutiveNums
FROM ConsecutiveLogs
WHERE num = next_num 
  AND num = after_next_num;