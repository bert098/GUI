
public class Client {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String postalcode;
	private String PhoneNum;
	private char type;
	public Client(int i, String f, String l,  String a, String p, String ph, char c)
	{
		id = i;
		fname = f;
		lname = l;
		address = a;
		postalcode = p;
		PhoneNum = ph;
		type = c;
		
		
	}
	public void setId(int n)
	{
		id = n;
	}
	public void setFname(String f)
	{
		fname = f;
	}
	public void setlname(String f)
	{
		lname = f;
	}
	public void setadd(String f)
	{
		address = f;
	}
	public void setpost(String f)
	{
		postalcode = f;
	}
	public void setNum(String f)
	{
		PhoneNum = f;
	}
	public void setType(char f)
	{
		type = f;
	}
	public int getId()
	{
		return id;
	}
	
	public String getfName()
	{
		return fname;
	}
	public String getlName()
	{
		return lname;
	}
	public String getaddress()
	{
		return address;
	}
	public String getpost()
	{
		return postalcode;
	}
	public String getphone()
	{
		return PhoneNum;
	}
	public char getType()
	{
		return type;
	}
	
	
	public String ToString()
	{
		return Integer.toString(id)  + " " + fname + " " + lname + " " + Character.toString(type);
	}
	
}
