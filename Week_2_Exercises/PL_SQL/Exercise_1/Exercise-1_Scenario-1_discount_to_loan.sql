DECLARE
    CURSOR customer_cur IS
        SELECT CustomerID, Name, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM DOB) AS Age
        FROM Customers;
    c_customer customer_cur%ROWTYPE;
BEGIN
    OPEN customer_cur;
    LOOP
        FETCH customer_cur INTO c_customer;
        EXIT WHEN customer_cur%NOTFOUND;
        
        -- Debug output to check age calculation
        DBMS_OUTPUT.PUT_LINE('Customer: ' || c_customer.Name || ', Age: ' || c_customer.Age);

        IF c_customer.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = c_customer.CustomerID;
            -- Debug output to confirm the update
            DBMS_OUTPUT.PUT_LINE('Updated InterestRate for CustomerID: ' || c_customer.CustomerID);
        END IF;
    END LOOP;
    CLOSE customer_cur;
    
    COMMIT;
END;
/


Select * FROM Customers;