-- 내가 푼 풀이(암묵적 join 사용)
-- SUM과 같은 집계 함수를 사용할 때는 그 함수의 의미에 따라 데이터를 그룹화하는 GROUP BY 절이 필요함.
-- DISTINCT는 중복 제거의 용도로 사용되며, 집계와는 다른 목적으로 쓰임.
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(P.PRICE*O.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT P, FOOD_ORDER O
WHERE P.PRODUCT_ID=O.PRODUCT_ID AND YEAR(O.PRODUCE_DATE) = '2022' AND MONTH(O.PRODUCE_DATE) = '05'
GROUP BY P.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID;

-- 다른 풀이 (명시적 join 사용)
-- 명시적 조인을 사용하는 것이 현대 SQL 코딩 관행에 더 부합하고, 코드의 가독성과 유지보수성을 향상시키므로,
-- 현대엔 명시적 조인을 사용하는 것이 더 적절하다.
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT P
JOIN FOOD_ORDER O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE EXTRACT(YEAR FROM O.PRODUCE_DATE) = 2022 AND EXTRACT(MONTH FROM O.PRODUCE_DATE) = 5
GROUP BY P.PRODUCT_ID, P.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID;
