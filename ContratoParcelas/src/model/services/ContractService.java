package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentServices onlinePaymentServices;
	
	public ContractService() {
		
	}
 	
	public ContractService(OnlinePaymentServices onlinePaymentServices) {
		this.onlinePaymentServices = onlinePaymentServices;
	}
	

	public OnlinePaymentServices getOnlinePaymentServices() {
		return onlinePaymentServices;
	}

	public void setOnlinePaymentServices(OnlinePaymentServices onlinePaymentServices) {
		this.onlinePaymentServices = onlinePaymentServices;
	}

	public void processContract(Contract contract , int months) {
		double basicQuota = contract.getTotalValue()/ months;
		for(int i = 0 ; i < months ; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentServices.interest(basicQuota, months);
			double fee = onlinePaymentServices.paymentFee(interest);
			double quota = basicQuota + interest + fee;
			contract.getList().add(new Installment(dueDate, quota));
		}
	}
}
