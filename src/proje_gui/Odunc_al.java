package proje_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Odunc_al extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField odunc_kitap;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Odunc_al frame = new Odunc_al();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Odunc_al() {
		setTitle("ÖDÜNÇ AL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Almak istediğiniz kitap :");
		lblNewLabel.setForeground(new Color(131, 20, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(40, 71, 159, 24);
		contentPane.add(lblNewLabel);
		
		odunc_kitap = new JTextField();
		odunc_kitap.setBounds(210, 69, 150, 32);
		contentPane.add(odunc_kitap);
		odunc_kitap.setColumns(10);
		
		JButton odunc_al = new JButton("ÖDÜNÇ AL");
		odunc_al.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     String kitapAdi = odunc_kitap.getText();

	                // Veritabanı bağlantısı
	                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitap_listesi","root","Me21li52ke.")) {
	                    // SQL sorgusu
	                    String sql = "SELECT * FROM kitap WHERE kitap_adi = ?";
	                    PreparedStatement stmt = conn.prepareStatement(sql);
	                    stmt.setString(1, kitapAdi);
	                    ResultSet rs = stmt.executeQuery();

	                    if (rs.next()) {
	                        JOptionPane.showMessageDialog(null, "Ödünç alma başarılı: " + kitapAdi);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Kitap bulunamadı: " + kitapAdi);
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                   
	                }

			}
		});
		odunc_al.setForeground(new Color(255, 119, 119));
		odunc_al.setFont(new Font("Tahoma", Font.BOLD, 13));
		odunc_al.setBounds(72, 138, 122, 38);
		contentPane.add(odunc_al);
		
		btnNewButton = new JButton("GERİ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  Menu menu = new Menu();
			        menu.setVisible(true);
			        dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 119, 119));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(241, 138, 107, 38);
		contentPane.add(btnNewButton);
	}
}
