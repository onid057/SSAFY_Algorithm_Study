WITH A AS (SELECT CODE FROM SKILLCODES WHERE CATEGORY='Front End')

SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D INNER JOIN A A ON D.SKILL_CODE & A.CODE
ORDER BY ID;
