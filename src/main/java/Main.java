import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.FlightReading();
		Passenger user=new Passenger();
		int num=0;
		Scanner myReader = new Scanner(System.in);
		do {
			System.out.println("1.Login");
			System.out.println("2.Signup");
			System.out.println("3.Exit");
			num = myReader.nextInt();
			myReader.nextLine();
			
		} while (num<1 || num>3);
		if(num==1) {
			user=admin.login();
		}
		else if (num==2) {
			admin.signup();
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
				System.out.println("3.Exit");
				num = myReader.nextInt();
				myReader.nextLine();
				
			} while (num<1 || num>3);
			if (num==1) {
				admin.searchAndBook(user);
			}
			if (num==2) {
				try {
					admin.ticketCancelation(user);
				} catch (Exception e) {
					// TODO: handle exception
					 System.err.print(e);
				}
				
			}
			if (num==3) {
				return;
			}
		}
//		myReader.close();

			//		admin.FlightReading();
//		admin.searchAndBook();
	}

}
