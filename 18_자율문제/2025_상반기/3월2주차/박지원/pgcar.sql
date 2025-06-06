SELECT HISTORY_ID, 
    ROUND(DAILY_FEE * (DATEDIFF(B.END_DATE, B.START_DATE) + 1)
         * (CASE
            WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 7 THEN 1
            WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 30 THEN 0.95
            WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 90 THEN 0.92
            ELSE 0.85 END)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A,
    CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B,
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C
WHERE A.CAR_ID = B.CAR_ID
AND A.CAR_TYPE = C.CAR_TYPE
AND A.CAR_TYPE = '트럭'
GROUP BY HISTORY_ID
ORDER BY FEE DESC, HISTORY_ID DESC
