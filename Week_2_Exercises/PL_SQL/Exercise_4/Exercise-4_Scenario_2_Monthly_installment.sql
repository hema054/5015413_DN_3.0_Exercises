CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_loan_amount IN NUMBER, p_interest_rate IN NUMBER, p_loan_duration IN NUMBER)
  RETURN NUMBER AS
  v_monthly_installment NUMBER;
BEGIN
  v_monthly_installment := p_loan_amount * (p_interest_rate / 1200) * POWER(1 + (p_interest_rate / 1200), p_loan_duration * 12) / (POWER(1 + (p_interest_rate / 1200), p_loan_duration * 12) - 1);
  RETURN v_monthly_installment;
END CalculateMonthlyInstallment;