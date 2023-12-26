package proje_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teslim_et extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teslim_et frame = new Teslim_et();
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
	public Teslim_et() {
		setTitle("TESLİM ET ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teslim Edeceğiniz Kitap :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(46, 72, 163, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("TESLİM ET");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     String kitapAdi = textField.getText();

	                // Veritabanı bağlantısı
	                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitap_listesi","root","Me21li52ke.")) {
	                    // SQL sorgusu
	                    String sql = "SELECT * FROM kitap WHERE kitap_adi = ?";
	                    PreparedStatement stmt = conn.prepareStatement(sql);
	                    stmt.setString(1, kitapAdi);
	                    ResultSet rs = stmt.executeQuery();

	                    if (rs.next()) {
	                        JOptionPane.showMessageDialog(null, "Teslim etme başarılı: " + kitapAdi);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Kitap bulunamadı: " + kitapAdi);
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                   
	                }

			}
		});
		btnNewButton.setBounds(104, 116, 116, 35);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(240, 62, 170, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("GERİ");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Menu menu = new Menu();
		        menu.setVisible(true);
		        dispose(); // Şu anki pencereyi kapatır
		    }
		});

		btnNewButton_1.setBounds(269, 116, 104, 35);
		contentPane.add(btnNewButton_1);
	}
}
