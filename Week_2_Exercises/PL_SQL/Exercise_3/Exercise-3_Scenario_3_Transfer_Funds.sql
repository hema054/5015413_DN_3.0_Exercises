CREATE OR REPLACE PROCEDURE TransferFunds(
  p_source_account_id IN NUMBER,
  p_target_account_id IN NUMBER,
  p_amount IN NUMBER
) AS
  v_source_balance NUMBER;
  v_target_balance NUMBER;
BEGIN
  SELECT balance INTO v_source_balance
  FROM Accounts
  WHERE accountid = p_source_account_id;
  
  IF v_source_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
  END IF;
  
  UPDATE Accounts
  SET balance = balance - p_amount
  WHERE accountid = p_source_account_id;
  
  UPDATE Accounts
  SET balance = balance + p_amount
  WHERE accountid = p_target_account_id;
END TransferFunds;