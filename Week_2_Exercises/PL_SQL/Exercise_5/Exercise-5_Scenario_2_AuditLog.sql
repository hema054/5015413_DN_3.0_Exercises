CREATE TABLE AuditLog (
  AuditLogID NUMBER PRIMARY KEY,
  TransactionID NUMBER,
  TransactionDate DATE,
  Amount NUMBER,
  TransactionType VARCHAR2(10),
  LogDate DATE
);

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (AuditLogID, TransactionID, TransactionDate, Amount, TransactionType, LogDate)
  VALUES (AuditLog_SEQ.NEXTVAL, :NEW.TransactionID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType, SYSTIMESTAMP);
END LogTransaction;