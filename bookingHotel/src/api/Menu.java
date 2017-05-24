package api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pan, panNorth, panCenter, panSouth;
	private JLabel title;
	private JButton chambreMenu, client, hotel, reservation, disconnect;
	
	public Menu(int user_ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 800);
		setTitle("menu principal");
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		pan.setBackground(new Color(255, 255, 255));
		pan.setLayout(new BorderLayout(0, 0));
		setContentPane(pan);
		
		// North panel
		panNorth = new JPanel();
		panNorth.setBackground(new Color(255, 255, 255));
		pan.add(panNorth, BorderLayout.NORTH);
		
		title = new JLabel("");
		panNorth.add(title);
		
		// Center panel
		panCenter = new JPanel();
		panCenter.setBackground(new Color(255, 255, 255));
		panCenter.setLayout(new GridLayout(2, 2, 20, 40));
		pan.add(panCenter, BorderLayout.CENTER);
		
		chambreMenu = new JButton("");
                chambreMenu.setIcon(new ImageIcon(Menu.class.getResource("/img/chambre.jpg")));
		chambreMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chambreMenu frame = new chambreMenu(user_ID);
				frame.setVisible(true);
				dispose();
			}
		});
		panCenter.add(chambreMenu);
		
		client = new JButton("");
		client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client frame = new client(user_ID);
				frame.setVisible(true);
				dispose();
			}
		});
		panCenter.add(client);
		
		hotel = new JButton("");
		hotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hotel frame = new hotel(user_ID);
				frame.setVisible(true);
			}
		});
		panCenter.add(hotel);
		
		disconnect = new JButton("");
		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Identification frame = new Identification();
				frame.setVisible(true);
				dispose();
			}
		});
		panCenter.add(disconnect);
		
		
		// South panel
		panSouth = new JPanel();
		panSouth.setBackground(new Color(255, 255, 255));
		pan.add(panSouth, BorderLayout.SOUTH);
	
	}
	
}