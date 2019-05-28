default: cpsc2150/banking/MortgageApp.java cpsc2150/banking/IMortgage.java cpsc2150/banking/ICustomer.java cpsc2150/banking/AbsMortgage.java cpsc2150/banking/AbsCustomer.java cpsc2150/banking/Mortgage.java cpsc2150/banking/Customer.java
	javac cpsc2150/banking/MortgageApp.java cpsc2150/banking/IMortgage.java cpsc2150/banking/ICustomer.java cpsc2150/banking/AbsMortgage.java cpsc2150/banking/AbsCustomer.java cpsc2150/banking/Mortgage.java cpsc2150/banking/Customer.java
	
run: cpsc2150/banking/MortgageApp.class cpsc2150/banking/IMortgage.class cpsc2150/banking/ICustomer.class cpsc2150/banking/AbsMortgage.class cpsc2150/banking/AbsCustomer.class cpsc2150/banking/Mortgage.class cpsc2150/banking/Customer.class
	java cpsc2150.banking.MortgageApp

test: cpsc2150/banking/TestMortgage.java cpsc2150/banking/IMortgage.java cpsc2150/banking/ICustomer.java cpsc2150/banking/AbsMortgage.java cpsc2150/banking/AbsCustomer.java cpsc2150/banking/Mortgage.java cpsc2150/banking/Customer.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/banking/TestMortgage.java cpsc2150/banking/IMortgage.java cpsc2150/banking/ICustomer.java cpsc2150/banking/AbsMortgage.java cpsc2150/banking/AbsCustomer.java cpsc2150/banking/Mortgage.java cpsc2150/banking/Customer.java

runtest: cpsc2150/banking/TestMortgage.class cpsc2150/banking/IMortgage.class cpsc2150/banking/ICustomer.class cpsc2150/banking/AbsMortgage.class cpsc2150/banking/AbsCustomer.class cpsc2150/banking/Mortgage.class cpsc2150/banking/Customer.class
	java  -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.banking.TestMortgage

clean:
	rm -f cpsc2150/banking/*.class
