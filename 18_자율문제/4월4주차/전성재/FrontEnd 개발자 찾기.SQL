SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS AS D JOIN SKILLCODES AS S ON S.CODE & D.SKILL_CODE
WHERE CATEGORY = "Front End"
ORDER BY ID;
