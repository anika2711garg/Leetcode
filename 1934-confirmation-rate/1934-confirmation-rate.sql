# Write your MySQL query statement below
SELECT A.user_id , round(ifnull(avg(action='confirmed'),0),2) AS confirmation_rate
FROM Signups AS A
LEFT JOIN Confirmations As B
ON A.user_id=B.user_id
GROUP BY A.user_id;