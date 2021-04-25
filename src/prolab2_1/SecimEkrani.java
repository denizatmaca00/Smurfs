package prolab2_1;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SecimEkrani extends JFrame {
	private JPanel contentPane;

	public static void secimArayuz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecimEkrani frame = new SecimEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SecimEkrani() {
		setTitle("Secim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,80,900,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(49, 201, 225));

		JButton btnGozluklu = new JButton(new ImageIcon("gozlukluSecim.png"));
		btnGozluklu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oyun.sirin = new GozlukluSirin("Gozluklu Sirin", 1, "sirin", new Lokasyon(6, 5), 20, new ImageIcon("gozlukluLabirent.png"));
				Labirent.LabirentOyunu();
				dispose();
			}
		});
		btnGozluklu.setBounds(60, 160, 350, 470);
		contentPane.add(btnGozluklu);

		JButton btnTembel = new JButton(new ImageIcon("tembelSecim.png"));
		btnTembel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oyun.sirin = new TembelSirin("Tembel Sirin", 2, "sirin", new Lokasyon(6, 5), 20, new ImageIcon("tembelLabirent.png"));
				Labirent.LabirentOyunu();
				dispose();
			}
		});
		btnTembel.setBounds(470, 160, 350, 470);
		contentPane.add(btnTembel);

		JLabel lblNewLabel = new JLabel("Hangi sirin ile oynayacaksiniz?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel.setBounds(185, 30, 538, 109);
		contentPane.add(lblNewLabel);
	}
}