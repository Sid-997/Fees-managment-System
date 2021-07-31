package fpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JLabel;

public class accsec extends JFrame implements ActionListener {
	private JButton ads;
	private JButton vs;
	private JButton es;
	private JButton logout;

	public accsec() {
		setSize(288,300);
		setVisible(true);
		getContentPane().setLayout(null);
		
		ads = new JButton("Add Student");
		ads.setFont(new Font("Tahoma", Font.BOLD, 12));
		ads.setBounds(70, 74, 125, 33);
		getContentPane().add(ads);
		
		vs = new JButton("View Student");
		vs.setFont(new Font("Tahoma", Font.BOLD, 12));
		vs.setBounds(70, 118, 125, 33);
		getContentPane().add(vs);
		
		es = new JButton("Edit Student");
		es.setFont(new Font("Tahoma", Font.BOLD, 12));
		es.setBounds(70, 169, 125, 33);
		getContentPane().add(es);
		
		logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout.setBounds(91, 215, 91, 33);
		getContentPane().add(logout);
		
		JLabel lblAccountantSection = new JLabel("  Accountant Section");
		lblAccountantSection.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccountantSection.setBounds(41, 11, 202, 52);
		getContentPane().add(lblAccountantSection);
		logout.addActionListener(this);
		ads.addActionListener(this);
		vs.addActionListener(this);
	}

	public static void main(String[] args) {
		new accsec();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==logout){
			int yn=JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout?");
			if(yn==0){
				new acclog();
				dispose();
			}
			else if(yn==1){
			}
		
	}
		else if(ob==ads){
			new addstudent();
			dispose();
		}
		else if(ob==vs){
			new ViewStudent();
			
		}
		
		

	}
}
