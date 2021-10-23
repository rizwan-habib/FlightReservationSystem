import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ManagerClass {
	private ArrayList<Flight> flights=new ArrayList<Flight>();
	private ArrayList<Passenger> passengers=new ArrayList<Passenger>();
	private ArrayList<Admin> admins=new ArrayList<Admin>();
// 	Passenger
 	public ManagerClass() {
		// TODO Auto-generated constructor stub
	}
 	
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}


	public ArrayList<Flight> getFlights() {
		return flights;
	}


	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	public void addNewFlight() {
		Scanner myObj = new Scanner(System.in);
		
		System.out.print("Enter Year: ");
	    String year = myObj.nextLine();
	    System.out.print("Enter Month(1-12): ");
	    String month = myObj.nextLine();
	    System.out.print("Enter day: ");
	    String day = myObj.nextLine();
	    String date=day+"_"+month+"_"+year;
	    System.out.print("Enter Origin: ");
	    String origin = myObj.nextLine();
	    System.out.print("Enter Destination: ");
	    String destination = myObj.nextLine();
	    System.out.print("Departure: ");
	    
	    System.out.print("Enter hours(0-24): ");
	    String hrs = myObj.nextLine();
	    System.out.print("Enter minutes(0-60): ");
	    String mins = myObj.nextLine();
	    String time1=hrs+":"+mins;
	    System.out.print("Arrival: ");
	    
	    System.out.print("Enter hours(0-24): ");
	    String hrs1 = myObj.nextLine();
	    System.out.print("Enter minutes(0-60): ");
	    String mins1 = myObj.nextLine();
	    String time2=hrs1+":"+mins1;
	    System.out.print("Enter Fare: ");
	    double fare = myObj.nextDouble();
	    myObj.nextLine();
	    System.out.print("Enter plane type: ");
	    String type = myObj.nextLine();
	    if (type.equals("Bussiness")) {
	    	Flight f=new BusinessClass(null, null, type, origin, destination,date, time1,time2);
	    	boolean[] array=new boolean[80];
	    	for (int i = 0; i < array.length; i++) {
				array[i]=false;
			}
	    	f.setSeats(array);
	    	f.setPrice(fare);
	    	flights.add(f);
	    }
	    else if (type.equals("Economy")) {
	    	Flight f=new BusinessClass(null, null, type, origin, destination,date, time1,time2);
	    	boolean[] array=new boolean[120];
	    	for (int i = 0; i < array.length; i++) {
				array[i]=false;
			}
	    	f.setSeats(array);
	    	f.setPrice(fare);
	    	flights.add(f);    
		}
	    String str="flights.csv";
		try
		{
		    FileWriter fw = new FileWriter(str,true); //the true will append the new data
		    fw.write("\n"+date+","+origin+","+time1+","+destination+","+time2+","+fare+","+type);
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	    
	}
	public void flightCancelation() throws CanNotFoundFlight {
		Scanner myReader = new Scanner(System.in);
		System.out.print("Enter Origin: ");
		String origin=myReader.nextLine();
		System.out.print("Enter Destination: ");
		String destination=myReader.nextLine();
		System.out.print("Enter year: ");
		String year=myReader.nextLine();
		System.out.print("Enter month(1-12): ");
		String month=myReader.nextLine();
		System.out.print("Enter day(1-31): ");
		String day=myReader.nextLine();
		String date=day+"_"+month+"_"+year;	
		File file=new File(Paths.get(".").toAbsolutePath().normalize().toString());
		File[] list = file.listFiles();
        
      	if(list!=null)
	        for (File fil : list)
	        {
	            if (!fil.isDirectory())
	            {
	            	if(fil.getName().equals(origin+destination+date+".csv")) {
	            		fil.delete();
	            	}
	            }
	            
	        }
		boolean flag=false;
		int index=0;

      	for (int i = 0; i < flights.size(); i++) {
//			for (int j = 0; j < flights.get(i).getTickets().size(); j++) {
//				System.out.println(flights.get(i).getTickets().get(j).getDestination());
    			if(origin.equals(flights.get(i).getOrigin()) 
						&& destination.equals(flights.get(i).getDestination()) 
						&& date.equals(flights.get(i).getDate())	
								) {
					flag=true;
					index=i;
//					t=j;
					flights.remove(i);
				}	

		}
    	if (flag) {
			File fold=new File("flights.csv");
			fold.delete();
			File file1 = new File("flights.csv");
		    boolean isFileCreated;
			try {
				isFileCreated = file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File fnew=new File("flights.csv");
//			String source = textArea.getText();
//			System.out.println(source);
//			Flight f=flights.get(index);
			try {
			    FileWriter f2 = new FileWriter(fnew, false);
			    for (int i = 0; i < flights.size(); i++) {
//			    	f2.write();
				    if(file.length()!=0) {
				    	f2.write("\n"+flights.get(i).date+","+flights.get(i).getOrigin()+","+flights.get(i).getDeparture()+","+flights.get(i).getDestination()+","+flights.get(i).getArrival()+","+flights.get(i).getPrice()+","+flights.get(i).getTypeOfPlane());
				    }
				    else {
				    	f2.write(flights.get(i).date+","+flights.get(i).getOrigin()+","+flights.get(i).getDeparture()+","+flights.get(i).getDestination()+","+flights.get(i).getArrival()+","+flights.get(i).getPrice()+","+flights.get(i).getTypeOfPlane());
				    }

				}
			    
			    f2.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}  
		}
		else {
			throw new CanNotFoundFlight(
	                "Could not delete Flight ");
		}
	}
	public void ticketCancelation(Passenger user) throws SeatNotFoundException   {
		Scanner myReader = new Scanner(System.in);
		System.out.print("Enter Origin: ");
		String origin=myReader.nextLine();
		System.out.print("Enter Destination: ");
		String destination=myReader.nextLine();
		System.out.print("Enter seat no: ");
		int seat=myReader.nextInt();
		myReader.nextLine();
//		
//		Flight f;
		int index=0;
		boolean flag=false;
		for (int i = 0; i < flights.size(); i++) {
			for (int j = 0; j < flights.get(i).getTickets().size(); j++) {
//				System.out.println(flights.get(i).getTickets().get(j).getDestination());
				if(origin.equals(flights.get(i).getTickets().get(j).getOrigin()) 
						&& destination.equals(flights.get(i).getTickets().get(j).getDestination()) 
						&& user.getPassportNumber().equals(flights.get(i).getTickets().get(j).getPassenger().getPassportNumber()) 
						&& (seat-1)==flights.get(i).getTickets().get(j).getSeatNo()	
								) {
					flag=true;
					index=i;
//					t=j;
					flights.get(i).getTickets().remove(j);
					flights.get(i).getSeats()[seat-1]=false;
				}	
			}
		}
		if (flag) {
			File fold=new File(flights.get(index).getOrigin()+flights.get(index).getDestination()+flights.get(index).getDate()+".csv");
			fold.delete();
			File file = new File(flights.get(index).getOrigin()+flights.get(index).getDestination()+flights.get(index).getDate()+".csv");
		    boolean isFileCreated;
			try {
				isFileCreated = file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File fnew=new File(flights.get(index).getOrigin()+flights.get(index).getDestination()+flights.get(index).getDate()+".csv");
//			String source = textArea.getText();
//			System.out.println(source);
			Flight f=flights.get(index);
			try {
			    FileWriter f2 = new FileWriter(fnew, false);
			    for (int i = 0; i < flights.get(index).getTickets().size(); i++) {
//			    	f2.write();
				    if(file.length()!=0) {
				    	f2.write("\n"+f.getOrigin()+","+f.getDestination()+","+f.getDate()+","+f.getTypeOfPlane()+","+f.getTickets().get(i).getSeatNo()+","+f.getTickets().get(i).getPassenger().getName()+","+f.getTickets().get(i).getPassenger().getPassportNumber()+","+f.getTickets().get(i).getPassenger().getAddress()+","+f.getTickets().get(i).getPassenger().getAge()+","+f.getTickets().get(i).getPassenger().getUsername()+","+f.getTickets().get(i).getPassenger().getPassword());
				    }
				    else {
				       	f2.write(f.getOrigin()+","+f.getDestination()+","+f.getDate()+","+f.getTypeOfPlane()+","+f.getTickets().get(i).getSeatNo()+","+f.getTickets().get(i).getPassenger().getName()+","+f.getTickets().get(i).getPassenger().getPassportNumber()+","+f.getTickets().get(i).getPassenger().getAddress()+","+f.getTickets().get(i).getPassenger().getAge()+","+f.getTickets().get(i).getPassenger().getUsername()+","+f.getTickets().get(i).getPassenger().getPassword());
				    }

				}
			    
			    f2.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}  
		}
		else {
			throw new SeatNotFoundException(
	                "Could not find Ticket ");
		}
	}
	public void signup() {

		Scanner myReader = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = myReader.nextLine();
		System.out.println("Enter your address: ");
		String address = myReader.nextLine();
		System.out.println("Enter your age: ");
		int age = myReader.nextInt();
		myReader.nextLine();
		System.out.println("Enter your passport number: ");
		String pNo = myReader.nextLine();
		System.out.println("Enter username to set: ");
		String username = myReader.nextLine();
		System.out.println("Enter password to set: ");
		String password = myReader.nextLine();
		Passenger p=new Passenger(name, address, age, pNo, username, password);
		try
		{
		    String filename= "passengers.csv";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n"+name+","+address+","+age+","+pNo+","+username+","+password);//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	public void adminLogin() {
		try {
			File myObj = new File("admins.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",");
	        	Admin admin=new Admin();
		        admin.setUsername(arrOfStr[0]);
		        admin.setPassword(arrOfStr[1]);
		        admins.add(admin);
			}
			myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		String username="",username1="",password="";
		Scanner myObj = new Scanner(System.in);
		boolean flag=false;
		Admin a=new Admin();
		do {
			System.out.print("Enter Username: ");
		    username = myObj.nextLine();
		    for (int i = 0; i < admins.size(); i++) {
		    	if(username.equals(admins.get(i).getUsername())) {
		    		flag=true;
		    		a=admins.get(i);
		    	}	
			}
		} while (!flag);
		do {
			System.out.print("Enter Password: ");
		    password = myObj.nextLine();
		    
		} while (!password.equals(a.getPassword()));
	}
	public Passenger login() {
		try {
			File myObj = new File("passengers.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",");
	        	Passenger passenger=new Passenger();
		        passenger.setName(arrOfStr[0]);
		        passenger.setAddress(arrOfStr[1]);
		        passenger.setAge(Integer.parseInt(arrOfStr[2]));
		        passenger.setPassportNumber(arrOfStr[3]);
		        passenger.setUsername(arrOfStr[4]);
		        passenger.setPassword(arrOfStr[5]);
		        passengers.add(passenger);
			}
			myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		String username="",username1="",password="";
		Scanner myObj = new Scanner(System.in);
		boolean flag=false;
		Passenger p=new Passenger();
		do {
			System.out.print("Enter Username: ");
		    username = myObj.nextLine();
		    for (int i = 0; i < passengers.size(); i++) {
		    	if(username.equals(passengers.get(i).getUsername())) {
		    		flag=true;
		    		p=passengers.get(i);
		    	}	
			}
		} while (!flag);
		do {
			System.out.print("Enter Password: ");
		    password = myObj.nextLine();
		    
		} while (!password.equals(p.getPassword()));
		return p;
	}

	public void FlightReading() throws UnknownFlights {
		try {
			File myObj = new File("flights.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",");
			    if(arrOfStr[6].equals("Business")) {
		        	Flight flight=new BusinessClass();
			        flight.setDate(arrOfStr[0]);
			        flight.setOrigin(arrOfStr[1]);
			        flight.setDeparture(arrOfStr[2]);
			        flight.setDestination(arrOfStr[3]);
			        flight.setArrival(arrOfStr[4]);
			        flight.setPrice(Double.parseDouble(arrOfStr[5]));
			        flight.setTypeOfPlane("Business");
			        boolean[] seats;
			        seats=new boolean[80];
			        for (int i = 0; i < seats.length; i++) {
						seats[i]=false;
					}
			        flight.setSeats(seats);
			        flights.add(flight);
			    }
			    else if(arrOfStr[6].equals("Economy"))
			    {
			    	Flight flight=new EconomyClass();
			        flight.setDate(arrOfStr[0]);
			        flight.setOrigin(arrOfStr[1]);
			        flight.setDeparture(arrOfStr[2]);
			        flight.setDestination(arrOfStr[3]);
			        flight.setArrival(arrOfStr[4]);
			        flight.setPrice(Double.parseDouble(arrOfStr[5]));
			        flight.setTypeOfPlane("Economy");
			        boolean[] seats;
			        seats=new boolean[120];
			        for (int i = 0; i < seats.length; i++) {
						seats[i]=false;
					}
			        flight.setSeats(seats);
			        flights.add(flight);
			    }
			    else {
			    	throw new UnknownFlights("Unknown Flight\n");
			    }
			}
			myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		File file=new File(Paths.get(".").toAbsolutePath().normalize().toString());
		File[] list = file.listFiles();
        
//        System.out.println("jkl");
		for (int i = 0; i < flights.size(); i++) {
			if(list!=null)
	        for (File fil : list)
	        {
	            if (!fil.isDirectory())
	            {
//	            	System.out.println(fil.getName());
//	            	System.out.println("matched");
	            	if(fil.getName().equals(flights.get(i).getOrigin()+flights.get(i).getDestination()+flights.get(i).getDate()+".csv")) {
//	            		System.out.println("matched");
	            		try {
	        				File myObj = new File(fil.getName());
	        				Scanner myReader = new Scanner(myObj);
	        				while (myReader.hasNextLine()) {
	        			        String data = myReader.nextLine();
	        			        String[] arrOfStr = data.split(",");
        				    	Ticket ticket=new Ticket();
        				        ticket.setOrigin(arrOfStr[0]);
        				        ticket.setDestination(arrOfStr[1]);
        				        ticket.setDate(arrOfStr[2]);
        				        ticket.setFlightType(arrOfStr[3]);
        				        ticket.setSeatNo(Integer.parseInt(arrOfStr[4]));
        				        Passenger p=new Passenger(arrOfStr[5], arrOfStr[7], Integer.parseInt(arrOfStr[8]), arrOfStr[6], arrOfStr[9], arrOfStr[10]);
        				        ticket.setPassenger(p);
    				            flights.get(i).getTickets().add(ticket);
    				            flights.get(i).bookSeat(Integer.parseInt(arrOfStr[4]));
	        				    
	        				}
	        				myReader.close();
	        		    } catch (FileNotFoundException e) {
	        		      System.out.println("An error occurred.");
	        		      e.printStackTrace();
	        		    }
	            	}
	            }
	            
	        }
//			if(flights.get(i).getOrigin().equals(flights))
			
		}
	}
	
	public void searchAndBook(Passenger user) throws SearchError {
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter Departure City: ");
		
	    String departure = myObj.nextLine();
		System.out.print("Enter Destination City: ");
		String destination = myObj.nextLine();
		ArrayList<Flight> direct_flights=new ArrayList<Flight>();
		ArrayList<Flight> indirect_flights1=new ArrayList<Flight>();
		ArrayList<Flight> indirect_flights2=new ArrayList<Flight>();
		boolean flag=false;
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getOrigin().equals(departure) && flights.get(i).getDestination().equals(destination)) {
				flag=true;
				System.out.println();
				System.out.println();
				System.out.println();
				flights.get(i).display();
				direct_flights.add(flights.get(i));
			}
			else if (flights.get(i).getOrigin().equals(departure)) {
				
				for (int j = 0; j < flights.size(); j++) {
//					System.out.print("matched"+flights.get(j).getDestination());
					if (flights.get(j).getDestination().equals(destination) && flights.get(j).getOrigin().equals(flights.get(i).getDestination())) {
//						System.out.print("matched"+flights.get(j).getDestination());
						flag=true;
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Indirect Flight:");
						System.out.println("Flight 1:");
						flights.get(i).display();
						System.out.println();
						System.out.println("Flight 2:");
						flights.get(j).display();
						indirect_flights1.add(flights.get(i));
						indirect_flights2.add(flights.get(j));
					
					}
				}
			}
			
		}
		if(!flag) {
			throw new SearchError("Flight did not found\n");
		}
		else if (direct_flights.size()>0) {
			Scanner myObj1 = new Scanner(System.in);
			int number=1;
			while(number!=0) {
				do {
					System.out.print("Select a flight from above direct to show the available seats or press 0 to go for booking: ");
					number=myObj1.nextInt();
					myObj1.nextLine();
				}while(number>direct_flights.size() || number<0);
				if(number!=0)
					direct_flights.get(number-1).showAvailableSeats();
			}
			number=1;
			do {
				System.out.print("Select a flight from above direct for booking: ");
				number=myObj1.nextInt();
				myObj1.nextLine();
			}while(number>direct_flights.size() || number<0);
			if(number!=0) {
				try {
					directBooking(direct_flights.get(number-1),user);
				} catch (Exception e) {
					// TODO: handle exception
					System.err.print(e);
								
				}	
			}
			
		}
		else if (indirect_flights1.size()>0) {
			Scanner myObj1 = new Scanner(System.in);
			int number=1;
			while(number!=0) {
				do {
					System.out.print("Select a flight from above indirect to show the available seats or press 0 to go for booking: ");
					number=myObj1.nextInt();
					myObj1.nextLine();
				}while(number>indirect_flights1.size() || number<0);
				
				if(number!=0)
					indirect_flights1.get(number-1).showAvailableSeats();
			}
			number=1;
			do {
				System.out.print("Select a flight from above indirect for booking: ");
				number=myObj1.nextInt();
				myObj1.nextLine();
			}while(number>indirect_flights1.size() || number<0);
			if(number!=0) {
				try {
					indirectBooking(indirect_flights1.get(number-1),indirect_flights2.get(number-1),user);					
				} catch (Exception e) {
					// TODO: handle exception
					System.err.print(e);
				}

			}
		}
	}
	private void directBooking(Flight f,Passenger user) throws SeatNotFoundException {
		f.getPassengers().add(user);
		int num=0;
		Scanner myReader = new Scanner(System.in);
		
		do {
			System.out.print("Enter a available seat number for flight "+f.getOrigin()+" to "+f.getDestination()+": ");
			num = myReader.nextInt();
			myReader.nextLine();
			if(f.getTypeOfPlane().equals("Business")) {
				if (num<1||num>80) {
					throw new SeatNotFoundException(
			                "Could not find Ticket ");
				}
			}
		} while (f.getSeats()[num-1]);
		f.bookSeat(num-1);
		Ticket t=new Ticket(f.getOrigin(), f.getDestination(), f.getDate(),f.getTypeOfPlane() , num-1, user);
		f.getTickets().add(t);
//		try {
		  String str=f.getOrigin()+f.getDestination()+f.getDate()+".csv";
//		  fileName = fileName + ".txt";
//		  System.out.print(str);
		    File file = new File(str);
		    boolean isFileCreated;
			try {
				isFileCreated = file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // New change
//		    System.out.print("Was the file created? -- ");
//		    Syst11em.out.println(isFileCreated);
		try
		{
//		    String filename= f.getOrigin()+f.getDestination()+".csv";
		    FileWriter fw = new FileWriter(str,true); //the true will append the new data
		    if(file.length()!=0) {
		    	fw.write("\n"+f.getOrigin()+","+f.getDestination()+","+f.getDate()+","+f.getTypeOfPlane()+","+(num-1)+","+user.getName()+","+user.getPassportNumber()+","+user.getAddress()+","+user.getAge()+","+user.getUsername()+","+user.getPassword());//appends the string to the file
		    }
		    else {
		    	fw.write(f.getOrigin()+","+f.getDestination()+","+f.getDate()+","+f.getTypeOfPlane()+","+(num-1)+","+user.getName()+","+user.getPassportNumber()+","+user.getAddress()+","+user.getAge()+","+user.getUsername()+","+user.getPassword());
		    }
		    	fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	private void indirectBooking(Flight f1,Flight f2,Passenger user) throws SeatNotFoundException {
//		System.out.println("booking done");
//		f1.display();
//		f2.display();
		directBooking(f1, user);
		directBooking(f2, user);
	}

}
