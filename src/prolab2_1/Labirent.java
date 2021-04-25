package prolab2_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Labirent extends JFrame {
	private JPanel contentPane;
	static JButton[][] kutu = new JButton[11][13];
	static int sayac = 0;


	public static void LabirentOyunu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labirent frame = new Labirent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Labirent() {
		frameOzellikleri();
		klavyeHareketleri();
		labirentCizimi();
		Obje.objeleriOlusturma();
		dusmanKapi();
	}
	
	
	public void frameOzellikleri() {
		setTitle("Labirent Oyunu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 900);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.PINK, Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	//UIManager.getColor("Button.light")
	public void klavyeHareketleri() {
		JLabel lblNewLabel = new JLabel("Skor: " + Oyun.sirin.getSkor());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 61));
		lblNewLabel.setBounds(978, 56, 301, 105);
		contentPane.add(lblNewLabel);

		if (Oyun.sirin.getID() == 1) {
			for (int i = 0; i < 2; i++) {
				KeyListener listener = new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_RIGHT:
							Oyun.sagaGit();
							break;
						case KeyEvent.VK_LEFT:
							Oyun.solaGit();
							break;
						case KeyEvent.VK_UP:
							Oyun.yukariGit();
							break;
						case KeyEvent.VK_DOWN:
							Oyun.asagiGit();
							break;
						}
						lblNewLabel.setText("Skor: " + Oyun.sirin.getSkor());
						oyunSonu();
						if(sayac!=0) {
							Oyun.dusmaniOynat();
							oyunSonu();
						}
						sayac++;
						if(sayac >=2 )
							sayac = 0;
					}
					@Override
					public void keyReleased(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				};
				addKeyListener(listener);
				setFocusable(true);
			}
		} else {
			KeyListener listener = new KeyListener() {
				@Override
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_RIGHT:
						Oyun.sagaGit();
						break;
					case KeyEvent.VK_LEFT:
						Oyun.solaGit();
						break;
					case KeyEvent.VK_UP:
						Oyun.yukariGit();
						break;
					case KeyEvent.VK_DOWN:
						Oyun.asagiGit();
						break;
					}
					lblNewLabel.setText("Skor: " + Oyun.sirin.getSkor());
					oyunSonu();
					Oyun.dusmaniOynat();
					oyunSonu();
				}
				@Override
				public void keyReleased(KeyEvent e) {
				}
				@Override
				public void keyTyped(KeyEvent e) {
				}
			};
			addKeyListener(listener);
			setFocusable(true);
		}
	}
	

	public void oyunSonu() {
		if (Oyun.sirin.getSkor() <= 0) {
			Oyun.kazandiMi = false;
			BitisEkrani.bitisArayuz();
			dispose();
		}
		if (Oyun.kazandiMi) {
			BitisEkrani.bitisArayuz();
			dispose();
		}
	}

	
	public void labirentCizimi() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 13; j++) {
				kutu[i][j] = new JButton();
				if (Oyun.harita[i][j] == 0) {
					kutu[i][j].setBackground(new Color(232, 49, 49));
					kutu[i][j].setBounds(j * 60 + 50, i * 60 + 75, 60, 60);
					contentPane.add(kutu[i][j]);
				} else {
					kutu[i][j].setBackground(new Color(51, 255, 153));
					kutu[i][j].setBounds(j * 60 + 50, i * 60 + 75, 60, 60);
					contentPane.add(kutu[i][j]);
				}
			}
		}
		kutu[Oyun.sirin.getLokasyon().getY()][Oyun.sirin.getLokasyon().getX()].setIcon(Oyun.sirin.getImg());
		kutu[7][12].setIcon(new ImageIcon("sirinekucuk.png"));
		if(Oyun.sirin.getID() == 1) {
			JButton sirinDurum = new JButton(new ImageIcon("gozlukluKenar.png"));
			sirinDurum.setBounds(917, 277, 404, 473);
			contentPane.add(sirinDurum);
		}else {
			JButton sirinDurum = new JButton(new ImageIcon("tembelKenar.png"));
			sirinDurum.setBounds(917, 277, 404, 473);
			contentPane.add(sirinDurum);
		}
	}

	
	public void dusmanKapi() {
		for (int a = 0; a < Oyun.dusman.size(); a++) {
			if (Oyun.dusman.get(a).getID() == 1) {
				kutu[Oyun.dusman.get(a).getLokasyon().getY()][Oyun.dusman.get(a).getLokasyon().getX()]
						.setIcon(new javax.swing.ImageIcon("gargamelLabirent.png"));
			} else {
				kutu[Oyun.dusman.get(a).getLokasyon().getY()][Oyun.dusman.get(a).getLokasyon().getX()]
						.setIcon(new javax.swing.ImageIcon("azmanLabirent.png"));
			}
		}
	}
}