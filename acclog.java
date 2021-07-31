package fpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import fpack.DBFConnections;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class acclog extends JFrame implements ActionListener
{
	private JTextField name;
	private JPasswordField password;
	private JButton back;
	private JLabel lblName;
	private JButton login;

	public acclog() 
	{
		setAlwaysOnTop(true);
		setBackground(Color.BLACK);
		setTitle("Admin Login");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel adl = new JLabel("Accountant Login");
		adl.setFont(new Font("Tahoma", Font.BOLD, 16));
		adl.setBounds(107, 58, 153, 40);
		getContentPane().add(adl);

		lblName = new JLabel("Name ID:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 123, 67, 28);
		getContentPane().add(lblName);

		JLabel lblPassword = new JLabel("password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 171, 82, 28);
		getContentPane().add(lblPassword);

		name = new JTextField();
		name.setBounds(123, 128, 168, 22);
		getContentPane().add(name);
		name.setColumns(10);

		password = new JPasswordField();
		password.setBounds(123, 177, 168, 22);
		getContentPane().add(password);

		back = new JButton("\u232BBack");
		back.setFont(new Font("Tahoma", Font.BOLD, 16));
		back.setBounds(3, 11, 89, 23);
		getContentPane().add(back);

		login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 14));
		login.setBounds(107, 243, 89, 23);
		getContentPane().add(login);
		setSize(340,330);
		setVisible(true);
		login.addActionListener(this);
		back.addActionListener(this);


	}

	public static void main(String[] args)
	{
		new acclog();

	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		if(ob==back)
		{
			int yn=JOptionPane.showConfirmDialog(null,"Are you sure you want to go back?");
			if(yn==0)
			{
				new first();
				dispose();
			}
			else if(yn==1)
			{
			}


		}
		else if(e.getSource()==login){
			String user=name.getText();
			String pass=new String(password.getPassword());
			Connection c=DBFConnections.connects();
			String st="select  * from fees where name=?"  + "and password=?";
			try {
				PreparedStatement ps = c.prepareStatement(st);
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					new accsec();
					dispose();
			}
				else{
					JOptionPane.showMessageDialog(this, "Invalid");
					password.setText("");
					name.setText("");
					name.requestFocusInWindow();
					
				}
			}
			catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}
}

