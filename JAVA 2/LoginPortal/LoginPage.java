

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
		int height = screenSize.height - 40;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login Page GROUP 22");
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		// Background image panel
		JPanel backgroundPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				URL imageUrl = getClass().getResource("/Assets/background.jpg");
				if (imageUrl != null) {
					ImageIcon imageIcon = new ImageIcon(imageUrl);
					Image img = imageIcon.getImage();
					g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		backgroundPanel.setLayout(new GridBagLayout());

		// Split left and right panels
		JPanel leftPanel = new JPanel();
		leftPanel.setOpaque(false);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setBorder(BorderFactory.createEmptyBorder(80, 60, 80, 40));

		JLabel welcomeLabel = new JLabel("<html><span style='font-size:48px;font-weight:bold;color:white;'>Welcome<br>Back</span></html>");
		welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftPanel.add(welcomeLabel);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

		JLabel descLabel = new JLabel("<html><span style='font-size:16px;color:white;'>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using</span></html>");
		descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftPanel.add(descLabel);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel socialPanel = new JPanel();
		socialPanel.setOpaque(false);
		socialPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		String[] icons = {"facebook", "twitter", "instagram", "youtube"};
		for (String icon : icons) {
			JLabel iconLabel = new JLabel(icon.substring(0, 1).toUpperCase() + icon.substring(1));
			iconLabel.setForeground(Color.WHITE);
			iconLabel.setFont(new Font("Arial", Font.BOLD, 18));
			socialPanel.add(iconLabel);
		}
		leftPanel.add(socialPanel);

		// Right login form panel
		JPanel rightPanel = new JPanel();
		rightPanel.setOpaque(false);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(80, 40, 80, 80));

		JLabel signInLabel = new JLabel("<html><span style='font-size:32px;font-weight:bold;color:white;'>Sign in</span></html>");
		signInLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(signInLabel);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

		JLabel emailLabel = new JLabel("<html><span style='color:white;'>Email Address</span></html>");
		emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(emailLabel);
		JTextField emailField = new JTextField(20);
		emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		rightPanel.add(emailField);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel passwordLabel = new JLabel("<html><span style='color:white;'>Password</span></html>");
		passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(passwordLabel);
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		// Panel for password field and show/hide icon
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		passwordPanel.setOpaque(false);
		passwordPanel.add(passwordField);

		// Load and scale show/hide icons
		URL showIconUrl = getClass().getResource("/Assets/showPassword.png");
		URL hideIconUrl = getClass().getResource("/Assets/hidePassword.png");
		int iconWidth = 20;
		int iconHeight = 20;
		ImageIcon showIcon = null;
		ImageIcon hideIcon = null;
		if (showIconUrl != null) {
			Image img = new ImageIcon(showIconUrl).getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
			showIcon = new ImageIcon(img);
		}
		if (hideIconUrl != null) {
			Image img = new ImageIcon(hideIconUrl).getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
			hideIcon = new ImageIcon(img);
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

		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JCheckBox rememberMe = new JCheckBox("Remember Me");
		rememberMe.setOpaque(false);
		rememberMe.setForeground(Color.WHITE);
		rememberMe.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(rememberMe);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton signInButton = new JButton("Sign in now");
		signInButton.setBackground(new Color(255, 87, 34));
		signInButton.setForeground(Color.WHITE);
		signInButton.setFocusPainted(false);
		signInButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(signInButton);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel lostPassword = new JLabel("<html><a href='#' style='color:white;'>Lost your password?</a></html>");
		lostPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lostPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(lostPassword);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

		JLabel terms = new JLabel("<html><span style='color:white;'>By clicking on 'Sign in now' you agree to <a href='#' style='color:white;'>Terms of Service</a> | <a href='#' style='color:white;'>Privacy Policy</a></span></html>");
		terms.setAlignmentX(Component.LEFT_ALIGNMENT);
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


