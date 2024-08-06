CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
BEGIN
    -- Check if the from account has sufficient funds
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the from account.');
    END IF;

    -- Deduct the amount from the from account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add the amount to the to account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Log the error
        INSERT INTO ErrorLog (LogID, ErrorMessage, ErrorDate)
        VALUES (ErrorLog_seq.NEXTVAL, SQLERRM, SYSDATE);

        -- Rollback the transaction
        ROLLBACK;
        RAISE;
END SafeTransferFunds;
/


