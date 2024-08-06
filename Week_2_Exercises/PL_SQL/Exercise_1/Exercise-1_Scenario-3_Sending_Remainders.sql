DECLARE
    CURSOR loan_cur IS
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    c_loan loan_cur%ROWTYPE;
    customer_name VARCHAR2(100);
BEGIN
    OPEN loan_cur;
    LOOP
        FETCH loan_cur INTO c_loan;
        EXIT WHEN loan_cur%NOTFOUND;

        SELECT Name INTO customer_name
        FROM Customers
        WHERE CustomerID = c_loan.CustomerID;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || c_loan.LoanID || ' for customer ' || customer_name || ' is due on ' || TO_CHAR(c_loan.EndDate, 'YYYY-MM-DD'));
    END LOOP;
    CLOSE loan_cur;
END;
/
