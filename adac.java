package fpack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class adac extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField temail;
	private JTextField add;
	private JTextField cn;
	private JPasswordField tpassword;
	private JTextField tname;
	private JButton back;
	private JButton adacc;
	int id;
	private JTextField tid;

	public adac()
	{
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Accoutant");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 8, 198, 28);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(26, 69, 55, 20);
		getContentPane().add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(26, 123, 82, 28);
		getContentPane().add(lblPassword);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(26, 171, 55, 20);
		getContentPane().add(lblEmail);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(26, 208, 82, 28);
		getContentPane().add(lblAddress);

		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContactNo.setBounds(26, 292, 90, 28);
		getContentPane().add(lblContactNo);

		temail = new JTextField();
		temail.setColumns(10);
		temail.setBounds(124, 169, 181, 28);
		getContentPane().add(temail);

		add = new JTextField();
		add.setColumns(10);
		add.setBounds(124, 214, 181, 63);
		getContentPane().add(add);

		cn = new JTextField();
		cn.setColumns(10);
		cn.setBounds(124, 298, 181, 28);
		getContentPane().add(cn);

		tname = new JTextField();
		tname.setColumns(10);
		tname.setBounds(124, 71, 181, 28);
		getContentPane().add(tname);

		tpassword = new JPasswordField();
		tpassword.setBounds(126, 129, 179, 22);
		getContentPane().add(tpassword);

		adacc = new JButton("Add Accountant");
		adacc.setBounds(55, 390, 118, 23);
		getContentPane().add(adacc);

		back = new JButton("Back");
		back.setBounds(232, 390, 109, 23);
		getContentPane().add(back);
		getRootPane().setDefaultButton(adacc);
		
		JLabel lblEid = new JLabel("ID no:");
		lblEid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEid.setBounds(26, 335, 90, 28);
		getContentPane().add(lblEid);
		
		tid = new JTextField();
		tid.setEditable(false);
		tid.setColumns(10);
		tid.setBounds(124, 337, 181, 28);
		getContentPane().add(tid);
		adacc.addActionListener(this);
		back.addActionListener(this);
		getID();
		setVisible(true);
		setSize(404,463);

	}

	public static void main(String[] args)
	{
		new adac();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==back){
			int yn=JOptionPane.showConfirmDialog(null,"Are you sure you want to go back?");
			if(yn==0){
				new adSec();
				dispose();
			}
			else if(yn==1){
			}
		}
		else if(ob==adacc)
		{
			String name=tname.getText();
			String password=new String(tpassword.getPassword());
			String email=temail.getText();
			String address=add.getText();
			String contact=cn.getText();
			String st="insert into fees(name,password,email,address,contact,"+"eid) values(?,?,?,?,?,?)";
			Connection c=DBFConnections.connects();
			try{
				PreparedStatement ps=c.prepareStatement(st);
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setString(4, address);
				ps.setString(5, contact);
				ps.setInt(6	, id);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "done");
				dispose();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
		}

	}
	void getID(){
		Connection con=DBFConnections.connects();
		String st="select max(eid) from fees";
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
