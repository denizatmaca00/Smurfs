package prolab2_1;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class BitisEkrani extends JFrame {

	private JPanel contentPane;

	public static void bitisArayuz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BitisEkrani frame = new BitisEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BitisEkrani() {
		setTitle("Sonuc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 90, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.PINK);

		JButton btnID1 = new JButton();
		btnID1.setBounds(42, 140, 350, 500);
		contentPane.add(btnID1);

		JButton btnID2 = new JButton();
		btnID2.setBounds(496, 140, 350, 500);
		contentPane.add(btnID2);

		if (Oyun.kazandiMi) {
			JLabel lblwin = new JLabel("KAZANDINIZ");
			lblwin.setFont(new Font("Tahoma", Font.PLAIN, 82));
			lblwin.setBounds(200, 30, 1000, 91);
			contentPane.add(lblwin);
			if (Oyun.sirin.getID() == 1)
				btnID2.setIcon(new ImageIcon("gozlukluSonuc.png"));
			else
				btnID2.setIcon(new ImageIcon("tembelSonuc.png"));
			btnID1.setIcon(new ImageIcon("sirineSonuc.png"));
		} else {
			JLabel lbllose = new JLabel("KAYBETTINIZ");
			lbllose.setFont(new Font("Tahoma", Font.PLAIN, 82));
			lbllose.setBounds(200,30, 1000, 91);
			contentPane.add(lbllose);
			contentPane.setBackground(SystemColor.controlShadow);
			btnID2.setIcon(new ImageIcon("gargamelSonuc.png"));
			btnID1.setIcon(new ImageIcon("azmanSonuc.png"));

		}

	}
}