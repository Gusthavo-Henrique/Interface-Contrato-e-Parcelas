package model.services;

public class PaypalService implements OnlinePaymentServices{
	public double interest(double amount , int months) {
		return amount * (100 + months)/100;
	}
	public double paymentFee(double amount) {
		return amount * 1.02;
	} 
}
