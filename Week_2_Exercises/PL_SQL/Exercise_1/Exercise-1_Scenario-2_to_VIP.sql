DECLARE
    CURSOR customer_cur IS
        SELECT CustomerID, Balance
        FROM Customers;
    c_customer customer_cur%ROWTYPE;
BEGIN
    OPEN customer_cur;
    LOOP
        FETCH customer_cur INTO c_customer;
        EXIT WHEN customer_cur%NOTFOUND;
        
        IF c_customer.Balance > 1000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = c_customer.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || c_customer.CustomerID || ' promoted to VIP');
        END IF;
    END LOOP;
    CLOSE customer_cur;
    
    COMMIT;
END;
/
Select * FROM CUSTOMERS;
