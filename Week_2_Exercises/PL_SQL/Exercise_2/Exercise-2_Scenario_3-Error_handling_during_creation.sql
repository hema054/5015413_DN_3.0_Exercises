CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id IN Customers.customer_id%TYPE,
  p_name IN Customers.name%TYPE,
  p_email IN Customers.email%TYPE,
  p_phone IN Customers.phone%TYPE
) AS
BEGIN
  BEGIN
    INSERT INTO Customers (customer_id, name, email, phone)
    VALUES (p_customer_id, p_name, p_email, p_phone);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      RAISE_APPLICATION_ERROR(-20001, 'Customer with ID ' || p_customer_id || ' already exists.');
  END;
END AddNewCustomer;
/

Select * FROM Customers;