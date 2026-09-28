# Write your MySQL query statement below
WITH Filtered AS (
    SELECT 
        id, 
        visit_date, 
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
),
Counts AS (
    SELECT 
        id, 
        visit_date, 
        people,
        COUNT(*) OVER (PARTITION BY grp) AS cnt
    FROM Filtered
)
SELECT 
    id, 
    visit_date, 
    people
FROM Counts
WHERE cnt >= 3
ORDER BY visit_date ASC;