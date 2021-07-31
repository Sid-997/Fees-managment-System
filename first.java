package fpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;



import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class first extends JFrame implements ActionListener
{
	private JButton exit;
	private JButton ac;
	private JButton ad;

	public first() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("fees Report");
		getContentPane().setLayout(null);

		ad = new JButton("Admin Login");
		ad.setFont(new Font("Tahoma", Font.BOLD, 14));
		ad.setBounds(77, 38, 180, 36);
		getContentPane().add(ad);

		ac = new JButton("Accoutant Login");
		ac.setFont(new Font("Tahoma", Font.BOLD, 14));
		ac.setBounds(77, 122, 180, 36);
		getContentPane().add(ac);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setFont(new Font("Tahoma", Font.BOLD, 12));
		exit.setBounds(109, 214, 106, 29);
		getContentPane().add(exit);
		setSize(353,324);
		exit.addActionListener(this);
		ac.addActionListener(this);
		ad.addActionListener(this);
		setVisible(true);

	}

	public static void main(String[] args) {
		new first();


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==ad){
			new admin();
			dispose();
		}
		else if(ob==ac){
			new acclog();
			dispose();
		}
		else if(ob==exit){
			int yn=JOptionPane.showConfirmDialog(null,"sure to exit");
			if(yn==0)
				System.exit(0);
		}
	}

}



