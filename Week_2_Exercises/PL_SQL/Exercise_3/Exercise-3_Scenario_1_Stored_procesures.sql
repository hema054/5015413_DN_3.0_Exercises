CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE Accounts
  SET balance = balance *(1+0.01);
END ProcessMonthlyInterest;

;