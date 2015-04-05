package services;

import java.util.List;

import dao.LoanDao;
import entities.Loan;

public class LoanService {

	LoanDao loanDao;

	public LoanService(LoanDao lDao) {
		loanDao = lDao;
	}

	public void registerLoan(Loan l) {
		loanDao.registerLoan(l);
	}

	public List listLoan() {
		return loanDao.listLoan();
	}

	public void updateLoan(Loan l) {
		loanDao.updateLoan(l);
	}

	public void deleteLoan(int id) {
		loanDao.deleteLoan(id);
	}
}
