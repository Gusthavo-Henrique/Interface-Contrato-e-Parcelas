package model.services;

public interface OnlinePaymentServices {
	public double interest(double amount , int months);
	public double paymentFee(double amount);
}
