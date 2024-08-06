DECLARE
  CURSOR cur_loans IS
    SELECT LoanID, InterestRate
    FROM Loans;
  
  v_loan_id NUMBER;
  v_interest_rate NUMBER;
  v_new_interest_rate NUMBER := 6.5; -- assume new interest rate is 6.5%
  
BEGIN
  OPEN cur_loans;
  
  LOOP
    FETCH cur_loans INTO v_loan_id, v_interest_rate;
    EXIT WHEN cur_loans%NOTFOUND;
    
    UPDATE Loans
    SET InterestRate = v_new_interest_rate
    WHERE LoanID = v_loan_id;
    
    DBMS_OUTPUT.PUT_LINE('Interest rate updated to ' || v_new_interest_rate || '% for Loan ID: ' || v_loan_id);
  END LOOP;
  
  CLOSE cur_loans;
END UpdateLoanInterestRates;