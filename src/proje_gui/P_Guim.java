package proje_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class P_Guim extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txt_ad;
	private JPasswordField txt_sifre;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_Guim frame = new P_Guim();
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
	public P_Guim() {
		setTitle("KÜTÜPHANE OTOMASYONU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 447);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel label_logo= new JLabel(new ImageIcon(getClass().getResource("YCO-00626-5.jpg")));
		label_logo.setBounds(0, 10, 352, 461);
		label_logo.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		getContentPane().add(label_logo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(376, 89, 435, 352);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("KULLANICI GİRİŞİ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblKulla = new JLabel("KULLANICI ADI:");
		lblKulla.setBounds(24, 54, 167, 29);
		lblKulla.setForeground(new Color(49, 21, 113));
		lblKulla.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		panel.add(lblKulla);
		
		JLabel lblifre = new JLabel("ŞİFRE:");
		lblifre.setForeground(new Color(49, 21, 113));
		lblifre.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblifre.setBounds(24, 109, 152, 29);
		panel.add(lblifre);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(201, 54, 198, 27);
		panel.add(txt_ad);
		txt_ad.setColumns(10);
		
		
		JButton btngiris = new JButton("GİRİŞ YAP");
		
		btngiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kull_adi = txt_ad.getText();
		        String sifre = new String(txt_sifre.getPassword());

		        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitap_listesi","root","Me21li52ke.")) {
		            String sqlSorgu = "SELECT * FROM kullanicilar WHERE kul_adi = ? AND sifre = ?";
		            PreparedStatement pstmt = conn.prepareStatement(sqlSorgu);
		            pstmt.setString(1, kull_adi);
		            pstmt.setString(2, sifre);
		            
		            // SQL sorgusunu çalıştır ve sonuçları al
		            ResultSet rs = pstmt.executeQuery();

		            if (rs.next()) {
		                // Kullanıcı doğrulandı, yeni pencereyi açabilirsiniz
		                Menu menu = new Menu();
		                menu.setVisible(true);
		                setVisible(false); // Mevcut pencereyi gizle
		            } else {
		                JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre yanlış.", "Hata", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
			
                   btngiris.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						Menu menu = new Menu();
						menu.setVisible(true);
						
						setVisible(false); 
							}
					
				});
				
				}
			
		});
		btngiris.setForeground(new Color(33, 14, 78));
		btngiris.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btngiris.setBounds(240, 181, 123, 40);
		panel.add(btngiris);
		
		JButton btnkaydol = new JButton("KAYDOL");
		btnkaydol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kull_adi = txt_ad.getText();
		        String sifre = new String(txt_sifre.getPassword());

		        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitap_listesi","root","Me21li52ke.")) {
		            String sqlSorgu = "INSERT INTO kullanicilar (kul_adi, sifre) VALUES (?, ?)";
		            PreparedStatement pstmt = conn.prepareStatement(sqlSorgu);
		            pstmt.setString(1, kull_adi);
		            pstmt.setString(2, sifre);

		            int affectedRows = pstmt.executeUpdate();
		            if (affectedRows > 0) {
		                JOptionPane.showMessageDialog(null, "Kullanıcı başarıyla kaydedildi.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "Kullanıcı kaydedilemedi.", "Hata", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
			}
		});
		btnkaydol.setForeground(new Color(33, 14, 78));
		btnkaydol.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnkaydol.setBounds(65, 181, 109, 40);
		panel.add(btnkaydol);
		
		txt_sifre = new JPasswordField();
		txt_sifre.setBounds(201, 112, 198, 29);
		panel.add(txt_sifre);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(55, 370, 1, 1);
		getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("KÜTÜPHANEMİZE HOŞ GELDİNİZ");
		lblNewLabel.setBounds(408, 38, 350, 29);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(49, 21, 113));
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
	}
}
