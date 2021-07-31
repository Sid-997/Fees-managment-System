package fpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;

public class adSec extends JFrame implements ActionListener{
	private JButton vac;
	private JButton adac;
	private JButton logout;

	public adSec()  {
		getContentPane().setLayout(null);

		JLabel lblAd = new JLabel("Administrator Section");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAd.setBounds(58, 11, 209, 57);
		getContentPane().add(lblAd);

		adac = new JButton("Add Accountant");
		adac.setFont(new Font("Tahoma", Font.BOLD, 14));
		adac.setBounds(78, 79, 161, 40);
		getContentPane().add(adac);

		vac = new JButton("View Accountant");
		vac.setFont(new Font("Tahoma", Font.BOLD, 14));
		vac.setBounds(78, 148, 161, 40);
		getContentPane().add(vac);

		logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.BOLD, 14));
		logout.setBounds(78, 211, 161, 40);
		getContentPane().add(logout);
		setSize(340,330);
		adac.addActionListener(this);
		vac.addActionListener(this);
		logout.addActionListener(this);
		setVisible(true);

	}

	public static void main(String[] args) {
		new adSec();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==logout){
			int yn=JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout");
			if(yn==0){
				new admin();
				dispose();
			}
			else if(yn==1){
			}
		}
			else if(ob==adac){
				new adac();
				dispose();
			}
			else if(ob==vac)
			{
				new view_accountant();
				dispose();
			}
		}
	}

