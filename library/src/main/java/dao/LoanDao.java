package dao;

import java.util.List;

import entities.Loan;

public interface LoanDao {

	public void registerLoan(Loan l);

	public List<Loan> listLoan();

	public void updateLoan(Loan l);

	public void deleteLoan(int id);
}
