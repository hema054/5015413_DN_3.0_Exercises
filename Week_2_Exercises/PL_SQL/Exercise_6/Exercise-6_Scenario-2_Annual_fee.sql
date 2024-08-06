DECLARE
  CURSOR cur_accounts IS
    SELECT AccountID, Balance
    FROM Accounts;
  
  v_account_id NUMBER;
  v_balance NUMBER;
  v_annual_fee NUMBER := 50; -- assume annual fee is $50
  
BEGIN
  OPEN cur_accounts;
  
  LOOP
    FETCH cur_accounts INTO v_account_id, v_balance;
    EXIT WHEN cur_accounts%NOTFOUND;
    
    UPDATE Accounts
    SET Balance = Balance - v_annual_fee
    WHERE AccountID = v_account_id;
    
    DBMS_OUTPUT.PUT_LINE('Annual fee of $' || v_annual_fee || ' deducted from Account ID: ' || v_account_id);
  END LOOP;
  
  CLOSE cur_accounts;
END ApplyAnnualFee;