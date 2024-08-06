CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmployeeID NUMBER,
    p_Percentage NUMBER
)
AS
BEGIN
    IF p_Percentage <= 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Invalid percentage');
    END IF;

    DECLARE
        v_CurrentSalary NUMBER;
    BEGIN
        SELECT Salary INTO v_CurrentSalary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;

        IF v_CurrentSalary IS NULL THEN
            RAISE_APPLICATION_ERROR(-20006, 'Employee not found');
        END IF;

        -- Update the salary
        UPDATE Employees
        SET Salary = Salary * (1 + p_Percentage / 100)
        WHERE EmployeeID = p_EmployeeID;

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20007, 'Error during salary update: ' || SQLERRM);
    END;
END UpdateSalary;