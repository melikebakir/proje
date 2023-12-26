package proje_gui;

import java.awt.EventQueue;
//import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"Kitap adı", "Yazar adı", "Sayfa sayısı", "Türü"};
    Object [] satirlar = new Object[4];
    private JTextField txt_kitap;
    private JTextField txt_yazar;
    private JTextField txt_sayfa;
    private JTextField txt_türü;
    private JTextField txt_adsorgu;
    
    
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 139, 320, 346);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(51, 188, 342, 269);
		scrollPane.setViewportView(table); //scrollpane in görüş alanına table ı bağladık
		
		JButton btnLİSTELE = new JButton("LİSTELE");
		btnLİSTELE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0); //butona basıldığında listeyi sıfırlasın daha sonra veri tabanından gelen ve girilen değerleri eklesin
				
				ResultSet myRs = T_baglanti.yap();
				
				
				 try {
					while (myRs.next()) {
						satirlar[0]=myRs.getString("kitap_adi");
						satirlar[1]=myRs.getString("yazar_adi");
						satirlar[2]=myRs.getString("sayfa_sayisi");
						satirlar[3]=myRs.getString("türü");
						modelim.addRow(satirlar); //modelimin içine aktardık	
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				 table.setModel(modelim);
			}
		});
		
		JButton geriButon = new JButton("Geri");
		geriButon.setFont(new Font("Tahoma", Font.BOLD, 12));
		geriButon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Menu menu = new Menu();
		        menu.setVisible(true);
		        dispose(); // Şu anki pencereyi kapatır
		    }
		});
		geriButon.setBounds(509, 361, 100, 40);
		contentPane.add(geriButon);

		
		btnLİSTELE.setBounds(20, 96, 114, 33);
		contentPane.add(btnLİSTELE);
		
		txt_kitap = new JTextField();
		txt_kitap.setBounds(509, 168, 114, 26);
		contentPane.add(txt_kitap);
		txt_kitap.setColumns(10);
		
		JButton btnKaydet = new JButton("Ekle");
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnKaydet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			String kitap,yazar,sayfa,tür,sql_sorgu;
			
		   kitap = txt_kitap.getText();
		   yazar = txt_yazar.getText();
		   sayfa = txt_sayfa.getText();
		   tür = txt_türü.getText();
		   
		 
		   String sqlSorgu = "INSERT INTO kitap (kitap_adi, yazar_adi, sayfa_sayisi, türü) VALUES ('" +
                   kitap + "','" + yazar + "'," + sayfa + ",'" + tür + "')";
             T_baglanti.ekle(sqlSorgu);
		   
			}
		});
		btnKaydet.setBounds(386, 361, 100, 40);
		contentPane.add(btnKaydet);
		
		txt_yazar = new JTextField();
		txt_yazar.setColumns(40);
		txt_yazar.setBounds(509, 207, 114, 26);
		contentPane.add(txt_yazar);
		
		txt_sayfa = new JTextField();
		txt_sayfa.setColumns(10);
		txt_sayfa.setBounds(509, 251, 114, 26);
		contentPane.add(txt_sayfa);
		
		txt_türü = new JTextField();
		txt_türü.setColumns(10);
		txt_türü.setBounds(509, 296, 114, 26);
		contentPane.add(txt_türü);
		
		JLabel lblNewLabel = new JLabel("KİTAP ADI :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(386, 174, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblYazarAd = new JLabel("YAZAR ADI :");
		lblYazarAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYazarAd.setBounds(386, 213, 74, 13);
		contentPane.add(lblYazarAd);
		
		JLabel lblSayfaSays = new JLabel("SAYFA SAYISI :");
		lblSayfaSays.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSayfaSays.setBounds(386, 257, 113, 13);
		contentPane.add(lblSayfaSays);
		
		JLabel lblTr = new JLabel("TÜRÜ :");
		lblTr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTr.setBounds(386, 302, 45, 13);
		contentPane.add(lblTr);
		
		txt_adsorgu = new JTextField();
		txt_adsorgu.setBounds(20, 53, 114, 33);
		contentPane.add(txt_adsorgu);
		txt_adsorgu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Seçiniz :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(33, 25, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kitap", "Yazar ", "Sayfa ", "Tür"}));
		comboBox.setBounds(95, 22, 74, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sorgula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				
				String sql_sorgu = null;
				String seciniz = txt_adsorgu.getText();
				
				ResultSet myRs =null;
				
				int secilen = comboBox.getSelectedIndex(); //seçilen değerin indexini döndürecek
				
				if (secilen == 0) {
					 sql_sorgu= "select * from kitap where kitap_adi like'"+seciniz+"%'"; //%= sonu ne olursa olsun girilen harfle başlayanı getir
				}else if (secilen==1) {
					 sql_sorgu= "select * from kitap where yazar_adi like'"+seciniz+"%'";
				}else if (secilen==3) {
					 sql_sorgu= "select * from kitap where türü like'"+seciniz+"%'";
				}else if (secilen==2) {
					sql_sorgu = "select * from kitap where sayfa_sayisi =" + seciniz;
				}
				
				
				myRs = T_baglanti.sorgula(sql_sorgu); //tabloya bağlanacak kullanıcının aradığı ismi çekecek ve RS e atacak
			
				 try {
						while (myRs.next()) {
							satirlar[0]=myRs.getString("kitap_adi");
							satirlar[1]=myRs.getString("yazar_adi");
							satirlar[2]=myRs.getString("sayfa_sayisi");
							satirlar[3]=myRs.getString("türü");
							modelim.addRow(satirlar); //modelimin içine aktardık	
						}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					 table.setModel(modelim);
			
			}
			
		});
		btnNewButton.setBounds(144, 56, 90, 27);
		contentPane.add(btnNewButton);
		
		
		
	}	
}

