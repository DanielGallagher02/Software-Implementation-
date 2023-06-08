package ie.lyit.hotel;

public interface Payable {
	
	public abstract double calculatePay(double taxPercentage);
	public abstract double incrementSalary(double incrementAmount);

}
