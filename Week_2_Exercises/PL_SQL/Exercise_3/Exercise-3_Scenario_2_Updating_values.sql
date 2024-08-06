

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN Employees.department%TYPE,
  p_bonus_percentage IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET salary = salary * (1 + p_bonus_percentage / 100)
  WHERE department = p_department;
END UpdateEmployeeBonus;

