package com.ui;

import com.socket.Message;
import com.socket.SocketClient;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class ChatFrame extends javax.swing.JFrame {

	public SocketClient client;
	public int port;
	public String serverAddr, username, password;
	public Thread clientThread;
	public DefaultListModel model;
	public File file;

	public ChatFrame() {
		initComponents();
		this.setTitle("Quick Share Peer");
		model.addElement("All");
		jList1.setSelectedIndex(0);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					client.send(new Message("message", username, ".bye",
							"SERVER"));
					clientThread.stop();
				} catch (Exception ex) {
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	public boolean isWin32() {
		return System.getProperty("os.name").startsWith("Windows");
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();
		jSeparator1 = new javax.swing.JSeparator();
		jScrollPane2 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jButton2 = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		jTextField5 = new javax.swing.JTextField();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Host Address : ");

		jTextField1.setText("IP of Quick Share Server");

		jLabel2.setText("Host Port : ");

		jTextField2.setText("13000");

		jButton1.setText("Connect");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField3.setText("Enter your Username");
		jTextField3.setEnabled(false);

		jLabel3.setText("Password :");

		jLabel4.setText("Username :");

		jButton3.setText("SignUp");
		jButton3.setEnabled(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jPasswordField1.setText("");
		jPasswordField1.setEnabled(false);

		jList1.setModel((model = new DefaultListModel()));
		jScrollPane2.setViewportView(jList1);

		jButton2.setText("Login");
		jButton2.setEnabled(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton5.setText("Browse");
		jButton5.setEnabled(false);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("Send");
		jButton6.setEnabled(false);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jLabel6.setText("File to Share :");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator2)
												.addComponent(
														jSeparator1,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel4))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jTextField3)
																												.addComponent(
																														jTextField1))
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														jLabel2)
																												.addComponent(
																														jLabel3))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jTextField2)
																												.addComponent(
																														jPasswordField1))))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jButton1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														jButton2,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														70,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)

																												.addComponent(
																														jButton3,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														81,
																														Short.MAX_VALUE)))))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()

																.addComponent(
																		jScrollPane2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		600,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(23, 23,
																		23)
																.addComponent(
																		jLabel6)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jTextField5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		378,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		27,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		77,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))

								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()

								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton1))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3)
												.addComponent(jLabel4)
												.addComponent(jButton3)
												.addComponent(
														jPasswordField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton2))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)

								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jSeparator1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														10,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)

												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														528, Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)

												.addComponent(
														jSeparator2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														10,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jButton6,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton5,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(jLabel6)
												.addComponent(
														jTextField5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		serverAddr = jTextField1.getText();
		port = Integer.parseInt(jTextField2.getText());

		if (!serverAddr.isEmpty() && !jTextField2.getText().isEmpty()) {
			try {
				client = new SocketClient(this);
				clientThread = new Thread(client);
				clientThread.start();
				client.send(new Message("test", "testUser", "testContent",
						"SERVER"));
			} catch (Exception ex) {
				System.out.println("Error in Button 1!!");
			}
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		username = jTextField3.getText();
		password = jPasswordField1.getText();

		if (!username.isEmpty() && !password.isEmpty()) {
			client.send(new Message("login", username, password, "SERVER"));
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		username = jTextField3.getText();
		password = jPasswordField1.getText();

		if (!username.isEmpty() && !password.isEmpty()) {
			client.send(new Message("signup", username, password, "SERVER"));
		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showDialog(this, "Select File");
		file = fileChooser.getSelectedFile();

		if (file != null) {
			if (!file.getName().isEmpty()) {
				jButton6.setEnabled(true);
				String str;

				if (jTextField5.getText().length() > 30) {
					String t = file.getPath();
					str = t.substring(0, 20) + " [...] "
							+ t.substring(t.length() - 20, t.length());
				} else {
					str = file.getPath();
				}
				jTextField5.setText(str);
			}
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		long size = file.length();
		if (size < 120 * 1024 * 1024) {
			client.send(new Message("upload_req", username, file.getName(),
					jList1.getSelectedValue().toString()));
		}
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			System.out.println("Look & Feel exception");
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChatFrame().setVisible(true);
			}
		});
	}

	// Variable Declaration
	public javax.swing.JButton jButton1;
	public javax.swing.JButton jButton2;
	public javax.swing.JButton jButton3;
	public javax.swing.JButton jButton5;
	public javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	public javax.swing.JList jList1;
	public javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	public javax.swing.JTextArea jTextArea1;
	public javax.swing.JTextField jTextField1;
	public javax.swing.JTextField jTextField2;
	public javax.swing.JTextField jTextField3;
	public javax.swing.JTextField jTextField5;
	// End of variables declaration
}
