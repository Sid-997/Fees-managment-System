package fpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import fpack.DBFConnections;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addstudent extends JFrame implements ActionListener {
	private JTextField tname;
	private JTextField temail;
	private JTextField tfees;
	private JTextField tpaid;
	private JTextField tdue;
	private JTextField tadd;
	private JTextField tcountry;
	private JTextField tcn;
	private JComboBox tcourse;
	private JComboBox tyear;
	int id;
	private JButton back;
	private JTextField tid;
	private JButton adds;


	public addstudent() {
		setVisible(true);
		getContentPane().setLayout(null);

		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddStudent.setBounds(135, 11, 101, 33);
		getContentPane().add(lblAddStudent);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 55, 58, 17);
		getContentPane().add(lblNewLabel);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(25, 94, 58, 17);
		getContentPane().add(lblYear);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(25, 136, 58, 17);
		getContentPane().add(lblEmail);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(25, 175, 58, 17);
		getContentPane().add(lblCourse);

		JLabel lblFees = new JLabel("fees:");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFees.setBounds(25, 216, 58, 17);
		getContentPane().add(lblFees);

		JLabel lblPaid = new JLabel("Paid:");
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaid.setBounds(25, 255, 58, 17);
		getContentPane().add(lblPaid);

		JLabel lblDues = new JLabel("Due:");
		lblDues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDues.setBounds(25, 294, 58, 17);
		getContentPane().add(lblDues);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(25, 330, 70, 17);
		getContentPane().add(lblAddress);

		JLabel lblCountary = new JLabel("Country:");
		lblCountary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCountary.setBounds(25, 402, 70, 17);
		getContentPane().add(lblCountary);

		JLabel lblContactNo = new JLabel("Contact No. :");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContactNo.setBounds(25, 446, 92, 26);
		getContentPane().add(lblContactNo);

		adds = new JButton("Add Student");
		adds.setBounds(74, 533, 113, 35);
		getContentPane().add(adds);

		back = new JButton("Back");
		back.setBounds(232, 533, 101, 35);
		getContentPane().add(back);

		tname = new JTextField();
		tname.setBounds(135, 55, 198, 26);
		getContentPane().add(tname);
		tname.setColumns(10);

		temail = new JTextField();
		temail.setColumns(10);
		temail.setBounds(135, 133, 198, 26);
		getContentPane().add(temail);

		tfees = new JTextField();
		tfees.setBackground(Color.WHITE);
		tfees.setColumns(10);
		tfees.setBounds(135, 213, 198, 26);
		getContentPane().add(tfees);

		tpaid = new JTextField();
		tpaid.setColumns(10);
		tpaid.setBounds(135, 255, 198, 26);
		getContentPane().add(tpaid);

		tdue = new JTextField();
		tdue.setBackground(Color.WHITE);
		tdue.setColumns(10);
		tdue.setBounds(135, 294, 198, 26);
		getContentPane().add(tdue);

		tadd = new JTextField();
		tadd.setColumns(10);
		tadd.setBounds(135, 337, 198, 51);
		getContentPane().add(tadd);

		tcountry = new JTextField();
		tcountry.setColumns(10);
		tcountry.setBounds(135, 399, 198, 26);
		getContentPane().add(tcountry);

		tcn = new JTextField();
		tcn.setColumns(10);
		tcn.setBounds(135, 446, 198, 26);
		getContentPane().add(tcn);

		tyear = new JComboBox();
		tyear.setModel(new DefaultComboBoxModel(new String[] {"[--Select--]", "First year", "Second year", "Third year", "Fourth year"}));
		tyear.setBounds(135, 94, 198, 26);
		getContentPane().add(tyear);

		tcourse = new JComboBox();
		tcourse.setModel(new DefaultComboBoxModel(new String[] {"[--select--]", "B.tech", "B.sc", "B.Arch", "B.com"}));
		tcourse.setBounds(135, 175, 198, 26);
		getContentPane().add(tcourse);

		JLabel lblIdNo = new JLabel("ID no :");
		lblIdNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdNo.setBounds(25, 499, 92, 26);
		getContentPane().add(lblIdNo);

		tid = new JTextField();
		tid.setBackground(Color.WHITE);
		tid.setEditable(false);
		tid.setColumns(10);
		tid.setBounds(135, 496, 198, 26);
		getContentPane().add(tid);
		setSize(400, 630);
		setVisible(true);
		getID();
		back.addActionListener(this);
		adds.addActionListener(this);
		tcourse.addItemListener(new ItemListener() {


			public void itemStateChanged(ItemEvent arg0) {

			}
		});
		setVisible(true);
	}


	public static void main(String[] args) {

		new addstudent();


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==back){
			int yn=JOptionPane.showConfirmDialog(null,"Are you sure you want to go back?");
			if(yn==0){
				new accsec();
				dispose();
			}
			else if(yn==1){
			}
		}
		else if(ob==adds){
			String name=tname.getText();
			String year=tyear.getSelectedItem().toString();
			if(!(year.contains("--Select--")))


				if(year.contains("First year")){
					year="First year";}

			if(year.contains("Second year")){
				year="Second year";}


			if(year.contains("Third year")){
				year="Third year";}

			if(year.contains("Fourth year")){
				year="Fourth year";}
			String email=temail.getText();
			String course=tcourse.getSelectedItem().toString();
			double fees=Double.parseDouble(tfees.getText());
			double paid=Double.parseDouble(tpaid.getText());
			double due=Double.parseDouble(tdue.getText());
			String address=tadd.getText();
			String country=tcountry.getText();
			String contact=tcn.getText();
			String st="insert into student (eid,paid,due,fees," +"name,email,address,country,contact,year,course) values(?,?,?,?,?,?,?,?,?,?,?)";
			Connection c =DBFConnections.connects();
			try{
				PreparedStatement ps=c.prepareStatement(st);
				ps.setInt(1, id);
				ps.setString(5, name);
				ps.setString(10, year);
				ps.setString(6, email);
				ps.setString(11, course);
				ps.setDouble(4, fees);
				ps.setDouble(2, paid);
				ps.setDouble(3, due);
				ps.setString(7, address);
				ps.setString(8, country);
				ps.setString(9, contact);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "done");
				dispose();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(NullPointerException nf){
				
			}
			
			
		}

	}
	void getID(){
		Connection con=DBFConnections.connects();
		String st="select max(eid) from student";
		try{
			PreparedStatement ps=con.prepareStatement(st);
			ResultSet rs =ps.executeQuery();
			rs.next();
			id=rs.getInt(1);
		}
		catch(SQLException se)
		{
			se.printStackTrace();

		}

		++id;
		tid.setText(String.valueOf(id));

	}
	
		
	}





