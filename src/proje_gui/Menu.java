package proje_gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ekle_sil = new JButton("KİTAP EKLE/SORGULA");
		ekle_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                  ekle_sil.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						Table menu = new Table();
						menu.setVisible(true);
						
						setVisible(false); 
							}
					
				});
				
				}
			
		});
		ekle_sil.setFont(new Font("Tahoma", Font.BOLD, 13));
		ekle_sil.setBounds(308, 437, 182, 36);
		contentPane.add(ekle_sil);
		
		JButton odunc_al = new JButton("ÖDÜNÇ AL");
		odunc_al.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 odunc_al.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							Odunc_al al = new Odunc_al();
							al.setVisible(true);
							
							setVisible(false); 
								}
						
					});
				}
		});
		
		odunc_al.setFont(new Font("Tahoma", Font.BOLD, 13));
		odunc_al.setBounds(320, 205, 124, 36);
		contentPane.add(odunc_al);
		
		JButton teslim_et = new JButton("TESLİM ET");
		teslim_et.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teslim_et.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						Teslim_et teslim = new Teslim_et();
						teslim.setVisible(true);
						
						setVisible(false); 
							}
					
				});
				
				}
				
		});
		teslim_et.setFont(new Font("Tahoma", Font.BOLD, 13));
		teslim_et.setBounds(71, 458, 115, 36);
		contentPane.add(teslim_et);
		
		JLabel label_odunc = new JLabel(new ImageIcon(getClass().getResource("indir.jpeg")));
		label_odunc.setBounds(267, 25, 223, 170);
		contentPane.add(label_odunc);
		
		JLabel lbl_eklesil = new JLabel(new ImageIcon(getClass().getResource("ekle.jpg")));
		lbl_eklesil.setBounds(267, 251, 238, 158);
		contentPane.add(lbl_eklesil);
		
		JLabel lbl_teslim = new JLabel(new ImageIcon(getClass().getResource("teslim1.jpg")));
		lbl_teslim.setBounds(10, 25, 248, 413);
		contentPane.add(lbl_teslim);
	}
}
