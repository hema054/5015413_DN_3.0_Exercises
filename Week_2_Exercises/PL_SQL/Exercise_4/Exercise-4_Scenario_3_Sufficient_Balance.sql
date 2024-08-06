CREATE OR REPLACE FUNCTION HasSufficientBalance(p_account_id IN NUMBER, p_amount IN NUMBER)
  RETURN BOOLEAN AS
  v_balance NUMBER;
BEGIN
  SELECT balance INTO v_balance
  FROM Accounts
  WHERE accountid = p_account_id;
  
  RETURN v_balance >= p_amount;
END HasSufficientBalance;