CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  SELECT balance INTO v_balance
  FROM Accounts
  WHERE account_id = :NEW.AccountID;
  
  IF :NEW.TransactionType = 'Withdrawal' AND v_balance < :NEW.Amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal');
  ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
  END IF;
END CheckTransactionRules;