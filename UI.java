package nomen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener{
	
	JFrame Screen;
	JPanel tmp;
	JLabel text;
	JButton signup,login;
	Font bFont = new Font("Times New Roman", Font.PLAIN, 45);
	Font tFont = new Font("Times New Roman", Font.PLAIN, 75);
	void start() {		//Initial function
		Screen = new JFrame("Nomen");
		openMenu();
	}
	
	void openMenu(){	//first menu
		tmp = new JPanel();//area of screen
		tmp.setBounds(0,0,500,750);
		
		text = new JLabel("Nomen");
		text.setFont(tFont);
		
		login = new JButton("login");
		login.setFont(bFont);
		
		signup = new JButton("signup");
		signup.setFont(bFont);
		signup.addActionListener(this);

		


		
		Screen.setSize(500,750);
		Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen.getContentPane().setBackground(Color.white);
		Screen.setLayout(null);
		Screen.setResizable(false);
		
		tmp.add(text);
		tmp.add(login);
		tmp.add(signup);
		Screen.add(tmp);
		Screen.setVisible(true);//what enables us to see it!!!
	}
	
	void signupMenu() {}
	
	void loginMenu() {}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}