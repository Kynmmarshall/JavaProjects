

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class LoginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new LoginPage();
	}

	public LoginPage() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width ;
		int height = screenSize.height - 50;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login Page GROUP 22");
		// Set window icon
		URL iconUrl = getClass().getResource("/Assets/login.png");
		if (iconUrl != null) {
			frame.setIconImage(new ImageIcon(iconUrl).getImage());
		}
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		// Background image panel
		JPanel backgroundPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				URL imageUrl = getClass().getResource("/Assets/background.png");
				if (imageUrl != null) {
					ImageIcon imageIcon = new ImageIcon(imageUrl);
					Image img = imageIcon.getImage();
					g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		backgroundPanel.setLayout(new GridBagLayout());

		// Split left and right panels
		JPanel leftPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 150)); // semi-transparent black
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		leftPanel.setOpaque(false);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setBorder(BorderFactory.createEmptyBorder(100, -200, 100, 30));

		JLabel welcomeLabel = new JLabel("<html><span style='font-size:56px;font-weight:bold;color:white;'>Welcome<br>Back</span></html>");
		welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftPanel.add(Box.createVerticalGlue());
		leftPanel.add(welcomeLabel);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 50)));

		JLabel descLabel = new JLabel("<html><span style='font-size:22px;color:white;'>This is a simple login page by GROUP 22. The design is clean and user-friendly.</span></html>");
		descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftPanel.add(descLabel);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel socialPanel = new JPanel();
		socialPanel.setOpaque(false);
		socialPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 0));
		String[] iconNames = {"facebook", "twitter", "instagram", "youtube"};
		for (String icon : iconNames) {
			URL socialIconUrl = getClass().getResource("/Assets/" + icon + ".png");
			if (socialIconUrl != null) {
				Image img = new ImageIcon(socialIconUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				JLabel iconLabel = new JLabel(new ImageIcon(img));
				iconLabel.setToolTipText(icon.substring(0, 1).toUpperCase() + icon.substring(1));
				socialPanel.add(iconLabel);
			}
		}
		leftPanel.add(socialPanel);
		leftPanel.add(Box.createVerticalGlue());

		// Right login form panel
		JPanel rightPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 150)); // semi-transparent black
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		rightPanel.setOpaque(false);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(80, 40, 80, 80));


		// Add vertical glue to push content to fill the panel
		rightPanel.add(Box.createVerticalGlue());

		JLabel signInLabel = new JLabel("<html><span style='font-size:40px;font-weight:bold;color:white;'>Login in</span></html>");
		signInLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(signInLabel);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		// Email icon and label panel
		JPanel emailLabelPanel = new JPanel();
		emailLabelPanel.setLayout(new BoxLayout(emailLabelPanel, BoxLayout.X_AXIS));
		emailLabelPanel.setOpaque(false);
		URL emailIconUrl = getClass().getResource("/Assets/email.png");
		if (emailIconUrl != null) {
			Image emailImg = new ImageIcon(emailIconUrl).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			JLabel emailIconLabel = new JLabel(new ImageIcon(emailImg));
			emailLabelPanel.add(emailIconLabel);
			emailLabelPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		}
		JLabel emailLabel = new JLabel("<html><span style='font-size:22px;color:white;'>Email Address</span></html>");
		emailLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		emailLabelPanel.add(emailLabel);
		emailLabelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(emailLabelPanel);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		JTextField emailField = new JTextField(20);
		emailField.setFont(new Font("Arial", Font.PLAIN, 22));
		emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		emailField.setPreferredSize(new Dimension(0, 50));
		rightPanel.add(emailField);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

		// Password icon and label panel
		JPanel passwordLabelPanel = new JPanel();
		passwordLabelPanel.setLayout(new BoxLayout(passwordLabelPanel, BoxLayout.X_AXIS));
		passwordLabelPanel.setOpaque(false);
		URL passwordIconUrl = getClass().getResource("/Assets/password.png");
		if (passwordIconUrl != null) {
			Image passwordImg = new ImageIcon(passwordIconUrl).getImage().getScaledInstance( 35, 35, Image.SCALE_SMOOTH);
			JLabel passwordIconLabel = new JLabel(new ImageIcon(passwordImg));
			passwordLabelPanel.add(passwordIconLabel);
			passwordLabelPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		}
		JLabel passwordLabel = new JLabel("<html><span style='font-size:22px;color:white;'>Password</span></html>");
		passwordLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		passwordLabelPanel.add(passwordLabel);
		passwordLabelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(passwordLabelPanel);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 22));
		passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		passwordField.setPreferredSize(new Dimension(0, 50));

		// Panel for password field and show/hide icon
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		passwordPanel.setOpaque(false);
		passwordPanel.add(passwordField);

		// Load and scale show/hide icons to fit nicely
		URL showIconUrl = getClass().getResource("/Assets/showPassword.png");
		URL hideIconUrl = getClass().getResource("/Assets/hidePassword.png");
		int iconWidth = 50;
		int iconHeight = 50;
		final ImageIcon showIcon;
		final ImageIcon hideIcon;
		if (showIconUrl != null) {
			Image img = new ImageIcon(showIconUrl).getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
			showIcon = new ImageIcon(img);
		} else {
			showIcon = null;
		}
		if (hideIconUrl != null) {
			Image img = new ImageIcon(hideIconUrl).getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
			hideIcon = new ImageIcon(img);
		} else {
			hideIcon = null;
		}

		JLabel togglePassword = new JLabel();
		if (showIcon != null) {
			togglePassword.setIcon(showIcon);
			togglePassword.setPreferredSize(new Dimension(iconWidth, iconHeight));
		} else {
			togglePassword.setText("Show");
			togglePassword.setPreferredSize(new Dimension(40, 30));
		}
		togglePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		togglePassword.setFocusable(true);
		togglePassword.setToolTipText("Show/Hide Password");
		togglePassword.setOpaque(false);
		passwordPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		passwordPanel.add(togglePassword);

		// Password visibility toggle logic
		togglePassword.addMouseListener(new java.awt.event.MouseAdapter() {
			private boolean isPasswordVisible = false;
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				isPasswordVisible = !isPasswordVisible;
				if (isPasswordVisible) {
					passwordField.setEchoChar((char)0);
					if (hideIcon != null) {
						togglePassword.setIcon(hideIcon);
					} else {
						togglePassword.setText("Hide");
					}
				} else {
					passwordField.setEchoChar('\u2022');
					if (showIcon != null) {
						togglePassword.setIcon(showIcon);
					} else {
						togglePassword.setText("Show");
					}
				}
			}
		});

		rightPanel.add(passwordPanel);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JCheckBox rememberMe = new JCheckBox("Remember Me");
		rememberMe.setOpaque(false);
		rememberMe.setForeground(Color.WHITE);
		rememberMe.setAlignmentX(Component.RIGHT_ALIGNMENT);
		rightPanel.add(rememberMe);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton signInButton = new JButton("Login now");
		signInButton.setBackground(new Color(255, 87, 34));
		signInButton.setForeground(Color.WHITE);
		signInButton.setFocusPainted(false);
		signInButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		rightPanel.add(signInButton);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel lostPassword = new JLabel("<html><a href='#' style='color:white;'>Lost your password?</a></html>");
		lostPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lostPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(lostPassword);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

		JLabel terms = new JLabel("<html><span style='color:white;'>By clicking on 'Login now' you agree to <a href='#' style='color:white;'>Terms of Service</a> | <a href='#' style='color:white;'>Privacy Policy</a></span></html>");
		terms.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(terms);

		// Layout: left and right panels in backgroundPanel
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1.0;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		backgroundPanel.add(leftPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		backgroundPanel.add(rightPanel, gbc);

		frame.setContentPane(backgroundPanel);
		frame.setVisible(true);
	}
}


