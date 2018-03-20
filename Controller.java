import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class Controller  {
	//The GUI that is going to be used
	private GUI frame;
	/*
	 * This is the constructor for the controller where the GUI and model are set
	 * @param g is the GUI
	 * @param m is the model
	 */
	public Controller(GUI g )
	{
		frame = g;
		frame.addInsertListener( new MyListener());
		frame.addDisplayListener(new MyListener1());
		frame.addClearListener(new MyListener2());
		frame.addSaveListener(new MyListener3());
		frame.addDeleteListener(new MyListener4());
		frame.addsearchListener(new MyListener5());
		frame.addclearsearchListener(new MyListener6());
		
	}
	class MyListener extends JFrame implements ActionListener  {
	public void actionPerformed(ActionEvent e) {
		
			JPanel calcPanel = new JPanel ();
			 
			
			 JLabel Labelid = new JLabel ("Enter the Client's id");
			 JLabel Labelfac = new JLabel ("Enter First Name");
			 JLabel Labelmaj = new JLabel ("Enter Last Name");
			 JLabel Labelyear = new JLabel ("Enter Address");
			 JLabel post = new JLabel ("Postal Code");
			 JLabel Phone= new JLabel ("Phone Number");
			 JLabel Type = new JLabel ("Client Type");
			 JTextField id = new JTextField(10);
			 JTextField fac = new JTextField(10);
			 JTextField maj = new JTextField(10);
			 JTextField year = new JTextField(10);
			 JTextField postcode = new JTextField(10);
			 JTextField phone = new JTextField(10);
			 JTextField type = new JTextField(10);
			
			 JButton Ins = new JButton("Insert");
			 Ins.addActionListener(new ActionListener()
					 {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							if(id.getText().equals("") || fac.getText().equals("") || maj.getText().equals("") || year.getText().equals("") || postcode.getText().equals("") || phone.getText().equals("") || type.getText().equals("")) 
							{
								JOptionPane.showMessageDialog(null, "Please fill every feild",
										"Error", JOptionPane.PLAIN_MESSAGE);
							}
							else if(!type.getText().equals("C") && !type.getText().equals("R"))
							{
								JOptionPane.showMessageDialog(null, "Please make sure client type is either 'C' or 'R' ",
										"Error", JOptionPane.PLAIN_MESSAGE);
							}
							else
							{
								
							
							
							try {
								frame.clients.add(new Client(Integer.parseInt(id.getText()), fac.getText() , maj.getText() , year.getText() , postcode.getText() , phone.getText() ,type.getText().charAt(0)));
								frame.displayAll();
							}
							catch(NumberFormatException ex)
							{
								JOptionPane.showMessageDialog(null, "Please make sure client id is a number ",
										"Error", JOptionPane.PLAIN_MESSAGE);
							}
								
								id.setText("");
								fac.setText("");
								maj.setText("");
								year.setText("");
								postcode.setText("");
								phone.setText("");
								type.setText("");
								setVisible(false);
							}
						}
					 }
			 );
			JButton leave = new JButton("return to Main Window");
			leave.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e) {
							
							setVisible(false);
						}
				
					});
				
			
			setTitle ( "Insert");
			JPanel subPanel1 = new JPanel();
			subPanel1.add( "South", Ins);
			subPanel1.add( "South", leave);
			add(subPanel1, BorderLayout.SOUTH);
			setSize(500, 200);
			calcPanel.add(Labelid);
			calcPanel.add(id);
			calcPanel.add(Labelfac);
			calcPanel.add(fac);
			calcPanel.add(Labelmaj);
			calcPanel.add(maj);
			calcPanel.add(Labelyear);
			calcPanel.add(year);
			calcPanel.add(post);
			calcPanel.add(postcode);
			calcPanel.add(Phone);
			calcPanel.add(phone);
			calcPanel.add(Type);
			calcPanel.add(type);
			
			add(calcPanel);
			setVisible(true);
			
			
		
		}
	}
	 public class MyListener1 implements ActionListener {
			
			
			public void actionPerformed(ActionEvent e) {
				try {
					String str = new String(frame.text.getSelectedText());
					Client c = null;
					for(int i = 0; i < frame.clients.size(); i++)
					{
						if(str.equals(Integer.toString(frame.clients.get(i).getId())))
						{
							c = frame.clients.get(i);
						}
					}
					if(c == null)
					{
						JOptionPane.showMessageDialog(null, "Please select only one id number from the given clients ",
								"Error", JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
					frame.currid = c.getId();
					frame.id.setText(Integer.toString(c.getId()));
					frame.fname.setText(c.getfName());
					frame.lname.setText(c.getlName());
					frame.address.setText(c.getaddress());
					frame.Postal.setText(c.getpost());
					frame.Phonenum.setText(c.getphone());
					frame.type.setText(Character.toString(c.getType()));
					}
					
					
					
			
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Please only highlight one Client",
							"Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		}
	 public class MyListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.id.setText("");
			frame.fname.setText("");
			frame.lname.setText("");
			frame.address.setText("");
			frame.Postal.setText("");
			frame.Phonenum.setText("");
			frame.type.setText("");
			
			
		}
		 
	 }
	 public class MyListener3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			Client c = null;
			for(int i = 0; i < frame.clients.size(); i++)
			{
				if(frame.currid == frame.clients.get(i).getId())
				{
					c = frame.clients.get(i);
				}
			}
				try {
				c.setId(Integer.parseInt(frame.id.getText()));
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Please Make sure ID is a number",
							"Error", JOptionPane.PLAIN_MESSAGE);
				}
				if(!frame.type.getText().equals("C") && !frame.type.getText().equals("R"))
				{
					JOptionPane.showMessageDialog(null, "Please make sure client type is either 'C' or 'R' ",
							"Error", JOptionPane.PLAIN_MESSAGE);
				}
				else if(frame.fname.getText().equals("") || frame.lname.getText().equals("") || frame.address.getText().equals("") || frame.Postal.getText().equals("") || frame.Phonenum.getText().equals("") || frame.type.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please make sure every field is filled out ",
							"Error", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
				
				c.setFname(frame.fname.getText());
				c.setlname(frame.lname.getText());
				c.setadd(frame.address.getText());
				c.setpost(frame.Postal.getText());
				c.setNum(frame.Phonenum.getText());
				c.setType(frame.type.getText().charAt(0));
				frame.displayAll();
				}
			
		}
		 
	 }
	 public class MyListener4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Client c = null;
			int i;
			for( i = 0; i < frame.clients.size(); i++)
			{
				if(frame.currid == frame.clients.get(i).getId())
				{
					break;
				}
				
			}
			frame.clients.remove(i);
			frame.displayAll();
			frame.id.setText("");
			frame.fname.setText("");
			frame.lname.setText("");
			frame.address.setText("");
			frame.Postal.setText("");
			frame.Phonenum.setText("");
			frame.type.setText("");
			
			
		}
		 
		 
	 }
	 public class MyListener5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(frame.byId.getState())
			{
				try {
				frame.displaybyID(Integer.parseInt(frame.searchperam.getText()));
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Please make sure you use a number to search for IDs ",
							"Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
			else if(frame.bylastname.getState())
			{
				frame.displaybyLast(frame.searchperam.getText());
			}
			else if(frame.bytype.getState())
			{
				frame.displaybytype(frame.searchperam.getText().charAt(0));
			}
		}
		 
	 }
	 public class MyListener6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.displayAll();
			
		}
		 
	 }
	 
	 
}

