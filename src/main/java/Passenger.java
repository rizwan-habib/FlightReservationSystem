
public class Passenger {
	
	private String name;
	private String address;
	private int age;
	private String passportNumber;
	private String username;
	private String password;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	
	public Passenger(String name, String address, int age, String passportNumber,
			String username, String password) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.passportNumber = passportNumber;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
}
