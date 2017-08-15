import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class NewAccount extends JInternalFrame  {

	private JPanel jpInfo = new JPanel();
	private JLabel AccountNu,Fname,Lname,Address1,Address2,Address3,Email,Phone,Mobile,Date;
	private JTextField TAccountNu,TFname,TLname,TAddress1,TAddress2,TAddress3,TEmail,TPhone,TMobile,TDate;
	private JComboBox cboMonth, cboDay, cboYear;
	private JButton btnSave, btnCancel;

	private int count = 0;
	private int rows = 0;
	private	int total = 0;

	//String Type Array use to Load Records From File.
	private String records[][] = new String [500][6];

	//String Type Array use to Save Records into File.
	private String saves[][] = new String [500][6];

	private FileInputStream fis;
	private DataInputStream dis;

	NewAccount () {

		// super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super ("Create New Account", false, true, false, true);
		setSize (335, 500);

		jpInfo.setBounds (0, 0, 500, 115);
		jpInfo.setLayout (null);

		AccountNu = new JLabel ("Account No:");
		AccountNu.setForeground (Color.black);
		AccountNu.setBounds (15, 20, 80, 25);
	        Fname = new JLabel ("Name:");
		Fname.setForeground (Color.black);
	        Fname.setBounds (15, 55, 80, 25);
		Date = new JLabel ("Deposit Date:");
		Date.setForeground (Color.black);
		Date.setBounds (15, 90, 80, 25);
		Address1 = new JLabel ("Address:");
		Address1.setForeground (Color.black);
		Address1.setBounds (15, 125, 80, 25);
		Address2 = new JLabel ("Address:");
		Address2.setForeground (Color.black);
		Address2.setBounds (15, 160, 80, 25);
		Address3 = new JLabel ("Address:");
		Address3.setForeground (Color.black);
		Address3.setBounds (15,195, 80, 25);
        
		Email = new JLabel ("Email:");
		Email.setForeground (Color.black);
		Email.setBounds (15, 230, 80, 25);
		Phone = new JLabel ("Phone:");
		Phone.setForeground (Color.black);
		Phone.setBounds (15, 265, 80, 25);
		Mobile = new JLabel ("Mobile:");
		Mobile.setForeground (Color.black);
		Mobile.setBounds (15,300, 80, 25);
        
		TAccountNu = new JTextField ();
		TAccountNu.setHorizontalAlignment (JTextField.RIGHT);
		TAccountNu.setBounds (105, 20, 205, 25);
	    TFname = new JTextField ();
		TFname.setBounds (105, 55, 205, 25);

				TAddress1 = new JTextField ();
		TAddress1.setHorizontalAlignment (JTextField.RIGHT);
		TAddress1.setBounds (105, 125, 205, 25);

		TAddress2 = new JTextField ();
		TAddress2.setHorizontalAlignment (JTextField.RIGHT);
		TAddress2.setBounds (105, 160, 205, 25);

		TAddress3 = new JTextField ();
		TAddress3.setHorizontalAlignment (JTextField.RIGHT);
		TAddress3.setBounds (105, 195, 205, 25);

		TEmail = new JTextField ();
		TEmail.setHorizontalAlignment (JTextField.RIGHT);
		TEmail.setBounds (105, 230, 205, 25);

		TPhone = new JTextField ();
		TPhone.setHorizontalAlignment (JTextField.RIGHT);
		TPhone.setBounds (105, 265, 205, 25);

		TMobile = new JTextField ();
		TMobile.setHorizontalAlignment (JTextField.RIGHT);
		TMobile.setBounds (105, 300, 205, 25);

	/*	//Restricting The User Input to only Numerics in Numeric TextBoxes.
		txtNo.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
					getToolkit().beep ();
					ke.consume ();
      				}
    			}
  		}
		);
		txtDeposit.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
					getToolkit().beep ();
					ke.consume ();
      				}
    			}
  		}
		);

		//Creating Date Option.
		String Months[] = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
		cboMonth = new JComboBox (Months);
		cboDay = new JComboBox ();
		cboYear = new JComboBox ();
		for (int i = 1; i <= 31; i++) {
			String days = "" + i;
			cboDay.addItem (days);
		}
		for (int i = 2000; i <= 2015; i++) {
			String years = "" + i;
			cboYear.addItem (years);
		}

		//Aligning The Date Option Controls.
		cboMonth.setBounds (105, 90, 92, 25);
		cboDay.setBounds (202, 90, 43, 25);
		cboYear.setBounds (250, 90, 60, 25);

		//Aligning The Buttons.
		btnSave = new JButton ("Save");
		btnSave.setBounds (20, 165, 120, 25);
		btnSave.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (185, 165, 120, 25);
		btnCancel.addActionListener (this);
*/
		//Adding the All the Controls to Panel.
		jpInfo.add (AccountNu);
		jpInfo.add (TAccountNu);
		jpInfo.add (Fname);
		jpInfo.add (TFname);
	    jpInfo.add (Date);
		jpInfo.add (cboMonth);
		jpInfo.add (cboDay);
		jpInfo.add (cboYear);
		jpInfo.add (Address1);
		jpInfo.add (TAddress1);
		jpInfo.add (Address2);
		jpInfo.add (TAddress2);
		jpInfo.add (Address3);
		jpInfo.add (TAddress3);
		jpInfo.add (Email);
		jpInfo.add (TEmail);
		jpInfo.add (Mobile);
		jpInfo.add (TMobile);
		jpInfo.add (Phone);
		jpInfo.add (TPhone);
		
		//jpInfo.add (btnCancel);

		//Adding Panel to Window.
		getContentPane().add (jpInfo);

		//In the End Showing the New Account Window.
		setVisible (true);

	}

	//Function use By Buttons of Window to Perform Action as User Click Them.
	/*public void actionPerformed (ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj == btnSave) {
			if (txtNo.getText().equals("")) {
				JOptionPane.showMessageDialog (this, "Please! Provide Id of Customer.",
						"BankSystem - EmptyField", JOptionPane.PLAIN_MESSAGE);
				txtNo.requestFocus();
			}
			else if (txtName.getText().equals("")) {
				JOptionPane.showMessageDialog (this, "Please! Provide Name of Customer.",
						"BankSystem - EmptyField", JOptionPane.PLAIN_MESSAGE);
				txtName.requestFocus ();
			}
			else if (txtDeposit.getText().equals("")) {
				JOptionPane.showMessageDialog (this, "Please! Provide Deposit Amount.",
						"BankSystem - EmptyField", JOptionPane.PLAIN_MESSAGE);
				txtDeposit.requestFocus ();
			}
			else {
				populateArray ();	//Load All Existing Records in Memory.
				findRec ();		//Finding if Account No. Already Exist or Not.
			}
		}
		if (obj == btnCancel) {
			txtClear ();
			setVisible (false);
			dispose();
		}

	}

	//Function use to load all Records from File when Application Execute.
	void populateArray () {


              try
            {
    
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Driver LOading");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
          PreparedStatement ps=con.prepareStatement("insert into newacc values(?,?,?,?)");
          
        
      

                  String s=cboDay.getSelectedItem()+"/"+cboMonth.getSelectedItem()+"/"+cboYear.getSelectedItem();

               ps.setInt(1,Integer.parseInt(txtNo.getText()));
               ps.setString(2,txtName.getText());
               ps.setString(3,s);
			   ps.setInt(4,Integer.parseInt(txtDeposit.getText()));
			   int a=ps.executeUpdate();
               if(a>0)
                      {
                          JOptionPane.showMessageDialog(null,"File Saved","Message",JOptionPane.INFORMATION_MESSAGE);
                   }
               
             }
             catch(Exception ex){System.out.println("Exception="+ex);}
            
	}

	//Function use to Find Record by Matching the Contents of Records Array with ID TextBox.
	void findRec () {

		boolean found = false;
		for (int x = 0; x < total; x++) {
			if (records[x][0].equals (txtNo.getText())) {
				found = true;
				JOptionPane.showMessageDialog (this, "Account No. " + txtNo.getText () + " is Already Exist.",
							"BankSystem - WrongNo", JOptionPane.PLAIN_MESSAGE);
				txtClear ();
				break;
			}
		}
		if (found == false) {
			saveArray ();
		}

	}

	//Function use to add new Element to Array.
	void saveArray () {

		saves[count][0] = txtNo.getText ();
		saves[count][1] = txtName.getText ();
		saves[count][2] = "" + cboMonth.getSelectedItem ();
		saves[count][3] = "" + cboDay.getSelectedItem ();
		saves[count][4] = "" + cboYear.getSelectedItem ();
		saves[count][5] = txtDeposit.getText ();
		saveFile ();	//Save This Array to File.
		count++;
	
	}

	//Function use to Save new Record to the File.
	void saveFile () {

		try {
			FileOutputStream fos = new FileOutputStream ("Bank.dat", true);
			DataOutputStream dos = new DataOutputStream (fos);
			dos.writeUTF (saves[count][0]);
			dos.writeUTF (saves[count][1]);
			dos.writeUTF (saves[count][2]);
			dos.writeUTF (saves[count][3]);
			dos.writeUTF (saves[count][4]);
			dos.writeUTF (saves[count][5]);
			JOptionPane.showMessageDialog (this, "The Record has been Saved Successfully",
						"BankSystem - Record Saved", JOptionPane.PLAIN_MESSAGE);
			txtClear ();
			dos.close();
			fos.close();
		}
		catch (IOException ioe) {
			JOptionPane.showMessageDialog (this, "There are Some Problem with File",
						"BankSystem - Problem", JOptionPane.PLAIN_MESSAGE);
		}

	}

	//Function use to Clear all TextFields of Window.
	void txtClear () {

		txtNo.setText ("");
		txtName.setText ("");
		txtDeposit.setText ("");
		txtNo.requestFocus ();

	}*/
}	