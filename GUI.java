import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.TextAreaPeer;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Popup;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.StyledDocument;

public class GUI extends JFrame {
	//The text area where the tree is displayed if the user clicks browse
		//the insert button
	int currid;
	JTextPane text =  new JTextPane();
	ArrayList<Client> clients = new ArrayList();
	 CheckboxGroup cbg = new CheckboxGroup();
	Checkbox byId = new Checkbox("Client ID", cbg, true);
	Checkbox bylastname = new Checkbox("Last Name", cbg, true);
	Checkbox bytype = new Checkbox("Client Type", cbg, true);
		JScrollPane scroll = new JScrollPane(text);
		JLabel l = new JLabel("Search Results: ");
		JLabel Labelid = new JLabel ("Client ID                                 ");
		 JLabel Labelfname = new JLabel ("First Name                                 ");
		 JLabel Labellname = new JLabel ("Last Name                                 ");
		 JLabel Labeladdress = new JLabel ("Address                                 ");
		 JLabel Labelpost = new JLabel ("Postal code                                 ");
		 JLabel Labelphonenum = new JLabel ("Phone number                                 ");
		 JLabel Labeltype = new JLabel ("Client Type (either C or R)     ");
		 JLabel param = new JLabel ("Enter the seach parameter here");
		 
		 
		 
		 JTextField id = new JTextField(10);
		 JTextField fname = new JTextField(10);
		 JTextField lname = new JTextField(10);
		 JTextField address = new JTextField(10);
		 JTextField Postal = new JTextField(10);
		 JTextField Phonenum = new JTextField(10);
		 JTextField type = new JTextField(10);
		 
		 JTextField searchperam = new JTextField(10);
		 
		 
		 
		 JScrollPane ta = new JScrollPane();
		 JButton GetSelectedText = new JButton("Display?");
		 JButton save = new JButton("Save");
		 JButton delete = new JButton("Delete");
		 JButton clear = new JButton("Clear");
		 JButton search = new JButton("Search");
		 JButton clearsearch = new JButton("Clear search");
		 JButton insert = new JButton("Insert New");
		 
		/*
		 * The constructor of the GUI that takes the dimensions of the frame and creates the GUI
		 * @param widthInPixels is the width of the frame
		 * @param heightInPixels is the height of the frame
		 */
			public GUI (int widthInPixels, int heightInPixels ) throws BadLocationException
			{
		 text.setEditable(false);
		
		 
			setTitle ( "Application to maintain customers");
			setSize(widthInPixels, heightInPixels);
			setLayout (new BorderLayout ( ) );
			JPanel subsubPanel = new JPanel();
			subsubPanel.setLayout(new GridLayout(3, 1));
			 subsubPanel.add(byId);
			 subsubPanel.add(bylastname);
			 subsubPanel.add(bytype);
			JPanel subPanel = new JPanel();
			JPanel subPanelcent = new JPanel();
			subPanelcent.setLayout(new BorderLayout());
			
			subPanelcent.add(param, BorderLayout.NORTH);
			subPanelcent.add(searchperam, BorderLayout.CENTER);
			JPanel ToManyPanels = new JPanel();
			
			ToManyPanels.add(search);
			ToManyPanels.add(clearsearch);
			ToManyPanels.add(insert);
			subPanelcent.add(ToManyPanels, BorderLayout.SOUTH);
			
			scroll.setPreferredSize(new Dimension(250, 350));
			JPanel WeNeverLearnedthisInClass = new JPanel();
			WeNeverLearnedthisInClass.setLayout(new BorderLayout());
			WeNeverLearnedthisInClass.add(l, BorderLayout.NORTH);
			WeNeverLearnedthisInClass.add(scroll, BorderLayout.SOUTH);
			subPanel.setLayout(new BorderLayout());
			
			
			subPanel.add(WeNeverLearnedthisInClass,BorderLayout.SOUTH );
			subPanel.add(subsubPanel, BorderLayout.NORTH);
			subPanel.add(subPanelcent, BorderLayout.CENTER);
			ta.setSize(new Dimension(20, 20));
			
			
			
			
			
			JPanel subPanelright = new JPanel();
			subPanelright.add(Labelid);
			subPanelright.add(id);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labelfname);
			subPanelright.add(fname);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labellname);
			subPanelright.add(lname);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labeladdress);
			subPanelright.add(address);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labelpost);
			subPanelright.add(Postal);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labelpost);
			subPanelright.add(Postal);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labelphonenum);
			subPanelright.add(Phonenum);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(Labeltype);
			subPanelright.add(type);
			subPanelright.add(Box.createVerticalStrut(60));
			subPanelright.add(GetSelectedText);
			subPanelright.add(save);
			subPanelright.add(delete);
			subPanelright.add(clear);
			add(subPanel, BorderLayout.WEST);
			add(subPanelright);
			setVisible(true);
			}
			public void add(String s) throws BadLocationException
			{
				StyledDocument document = (StyledDocument) text.getDocument();
			     document.insertString(document.getLength(), s+ "\n", null);
			    
			}
			void addInsertListener (ActionListener listenForInsButton)
			{
				insert.addActionListener(listenForInsButton);
			}
			void addDisplayListener (ActionListener listenForInsButton)
			{
				GetSelectedText.addActionListener(listenForInsButton);
			}
			void addClearListener (ActionListener listenForInsButton)
			{
				clear.addActionListener(listenForInsButton);
			}
			void addSaveListener (ActionListener listenForInsButton)
			{
				save.addActionListener(listenForInsButton);
			}
			void addDeleteListener (ActionListener listenForInsButton)
			{
				delete.addActionListener(listenForInsButton);
			}
			void addsearchListener (ActionListener listenForInsButton)
			{
				search.addActionListener(listenForInsButton);
			}
			void addclearsearchListener (ActionListener listenForInsButton)
			{
				clearsearch.addActionListener(listenForInsButton);
			}
			public void displayAll()
			{
				text.setText("");
				for(int i = 0 ; i < clients.size(); i ++)
				{
					try {
						add(clients.get(i).ToString());
						
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
			public void displaybyID(int id)
			{
				text.setText("");
				for(int i = 0 ; i < clients.size(); i ++)
				{
					try {
						if(clients.get(i).getId() == id)
						{
						add(clients.get(i).ToString());
						}
						
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
			public void displaybyLast(String id)
			{
				text.setText("");
				for(int i = 0 ; i < clients.size(); i ++)
				{
					try {
						if(clients.get(i).getlName().equals(id))
						{
						add(clients.get(i).ToString());
						}
						
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
			public void displaybytype(char id)
			{
				text.setText("");
				for(int i = 0 ; i < clients.size(); i ++)
				{
					try {
						if(clients.get(i).getType() == id)
						{
						add(clients.get(i).ToString());
						}
						
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
			//The main function where the GUI and model are created
			public static void main (String [] args) throws BadLocationException{
				GUI gui = new GUI(680, 600);
				Controller c = new Controller(gui);
			}


}
