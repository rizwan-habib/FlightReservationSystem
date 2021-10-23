import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerClass manager=new ManagerClass();
		try {
			manager.FlightReading();
				
		} catch (Exception e) {
			 System.err.print(e);					
							// TODO: handle exception
		}
		Passenger user=new Passenger();
		int num1=0;
		Scanner myReader = new Scanner(System.in);
		do {
			System.out.println("1.Admin Login");
			System.out.println("2.Passenger Login");
			System.out.println("3.Exit");
			num1 = myReader.nextInt();
			myReader.nextLine();
			
		} while (num1<1 || num1>3);
		if(num1==2) {
			int num=0;
			do {
				System.out.println("1.Login");
				System.out.println("2.Signup");
				System.out.println("3.Exit");
				num = myReader.nextInt();
				myReader.nextLine();
				
			} while (num<1 || num>3);
			if(num==1) {
				user=manager.login();
			}
			else if (num==2) {
				manager.signup();
			}
			else if (num==3) {
				myReader.close();
				return;
			}
			while(true) {
				
				num=0;
				do {
					System.out.println("1.Search and Book");
					System.out.println("2.Cancel Ticket");
					System.out.println("3.Modify Reservation");
					System.out.println("4.Print Ticket");
					System.out.println("5.Exit");
					num = myReader.nextInt();
					myReader.nextLine();
					
				} while (num<1 || num>5);
				if (num==1) {
					try {
						manager.searchAndBook(user);
					} catch (Exception e) {
						 System.err.print(e);					
						// TODO: handle exception
					}
					
				}
				if (num==2) {
					try {
						manager.ticketCancelation(user);
					} catch (Exception e) {
						// TODO: handle exception
						 System.err.print(e);
					}
					
				}
				if(num==3) {
					manager.modifyreservation(user);
				}
				if(num==4) {
					manager.printTicket(user);
				}
				if (num==5) {
					return;
				}
			}
		}
		else if(num1==1) {
			manager.adminLogin();
			while(true) {
				num1=0;
				do {
					System.out.println("1.Add New Flight");
					System.out.println("2.Delete a Flight");
					System.out.println("3.Exit");
					num1 = myReader.nextInt();
					myReader.nextLine();
					
				} while (num1<1 || num1>3);
				if (num1==1) {
//					try {
						manager.addNewFlight();
//					} catch (Exception e) {
//						 System.err.print(e);					
//						// TODO: handle exception
//					}
					
				}
				if (num1==2) {
					try {
						manager.flightCancelation();
					} catch (Exception e) {
						// TODO: handle exception
						 System.err.print(e);
					}
//					
				}
				if (num1==3) {
					return;
				}
			}
		}
		else {
			return;
		}
//		myReader.close();

			//		manager.FlightReading();
//		manager.searchAndBook();
	}

}
