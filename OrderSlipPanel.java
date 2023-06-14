public class OrderSlipPanel extends ContentPanel implements ActionListener {
    private JFrame uListFrame, mListFrame;
    private JPanel orderSlipPanel, itemsPanel, merchPanel,uListPanel, mListPanel;
    private JButton confirm, next, previous, itemsFL, merchFL;
    private JLabel orderSlipLabel, uniformsLabel, merchLabel, uLabel;
    private JTable table;
    private JScrollPane uniformsList, merchList, unifList, merchfList;

    OrderSlipPanel(int color) {
        super(color);

        itemsPanel = new JPanel();
        itemsPanel.setBackground(new Color(0xFFFF78));
        itemsPanel.setBounds(0, 0, 685, 585);
        itemsPanel.setLayout(null);
        
        
        List<String> imagePaths = Arrays.asList(
        "C:\\Users\\Charles\\Downloads\\unifs\\unif1.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif2.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif3.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif4.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif5.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif6.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif1.1.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif1.2.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif2.1.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif2.2.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif3.1.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif3.2.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif4.1.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif4.2.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif5.1.jpg",
        "C:\\Users\\Charles\\Downloads\\unifs\\unif6.1.jpg"
        );

        int imageHeight = 425; // Set the desired height for the images
        int yPos = 10; // Starting position for the first image label

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

        for (String imagePath : imagePaths) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();

            int scaledWidth = (int) (imageHeight * ((double) originalWidth / originalHeight));

            Image image = imageIcon.getImage().getScaledInstance(scaledWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
            imageIcon = new ImageIcon(image);

            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(10, yPos, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            panel.add(imageLabel);

            yPos += imageIcon.getIconHeight() + 10; // Increment the y-position for the next image
        }

        uniformsList = new JScrollPane(panel);
        uniformsList.setBounds(50, 75, 590, 425); // Adjust the bounds based on your desired positioning within itemsPanel

        next = new JButton("Merchandise");
        next.setHorizontalAlignment(SwingConstants.CENTER);
        next.setFont(new Font("Tahoma", Font.BOLD, 15));
        next.setBackground(new Color(0x293478));
        next.setForeground(Color.WHITE);
        next.setBounds(380, 525, 150, 25);
        next.setFocusable(false);
        next.addActionListener(this);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            List<String> imagePaths = Arrays.asList(
                "C:\\Users\\Charles\\Downloads\\merch\\merch1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch1.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch2.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch2.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch3.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch3.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch4.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch5.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch5.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch6.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch6.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch7.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch7.1.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch7.2.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch7.3.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch7.4.jpg",
                "C:\\Users\\Charles\\Downloads\\merch\\merch7.5.jpg"
            );

            int imageHeight = 425; // Set the desired height for the images
            int yPos = 10; // Starting position for the first image label

            merchPanel = new JPanel();
            merchPanel.setBackground(new Color(0xFFFF78));
            merchPanel.setBounds(0, 0, 685, 585);
            merchPanel.setLayout(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

            for (String imagePath : imagePaths) {
                ImageIcon imageIcon = new ImageIcon(imagePath);
                int originalWidth = imageIcon.getIconWidth();
                int originalHeight = imageIcon.getIconHeight();

                int scaledWidth = (int) (imageHeight * ((double) originalWidth / originalHeight));

                Image image = imageIcon.getImage().getScaledInstance(scaledWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
                imageIcon = new ImageIcon(image);

                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setBounds(10, yPos, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                panel.add(imageLabel);

                yPos += imageIcon.getIconHeight() + 10; // Increment the y-position for the next image
            }

            merchList = new JScrollPane(panel);
            merchList.setBounds(50, 75, 590, 425); // Adjust the bounds based on your desired positioning within merchPanel
            merchPanel.add(merchList); // Add uniformsList to the merchPanel
            merchLabel = new JLabel("MERCHANDISE");
            merchLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
            merchLabel.setForeground(new Color(0x293476));
            merchLabel.setBounds(200, 25, 280, 30);
            merchLabel.setHorizontalAlignment(SwingConstants.CENTER);
            merchPanel.add(merchLabel); // Add merchLabel to merchPanel
            merchPanel.add(merchFL);
            
            // Remove all components from itemsPanel except the buttons
            Component[] components = itemsPanel.getComponents();
                for (Component component : components) {
                    if (!(component instanceof JButton)) {
                        itemsPanel.remove(component);
                    }
                }

                itemsFL.setVisible(false);
                next.setVisible(false);
                previous.setVisible(true);
                itemsPanel.setLayout(null); // Set layout to null for custom positioning
                itemsPanel.add(merchPanel); // Add merchPanel to the itemsPanel

                itemsPanel.revalidate();
                itemsPanel.repaint();
            }
        });
                
        previous = new JButton("Uniforms");
        previous.setHorizontalAlignment(SwingConstants.CENTER);
        previous.setFont(new Font("Tahoma", Font.BOLD, 15));
        previous.setBackground(new Color(0x293478));
        previous.setForeground(Color.WHITE);
        previous.setBounds(150, 525, 150, 25);
        previous.setFocusable(false);
        previous.setVisible(false); 
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsPanel.remove(merchPanel); // Remove merchPanel from itemsPanel
                itemsPanel.add(uniformsList); // Add uniformsList back to itemsPanel
                itemsPanel.add(uniformsLabel); // Add uniformsLabel back to itemsPanel
                itemsPanel.add(next); // Add next button back to itemsPanel
                itemsPanel.add(itemsFL);
                
                merchPanel.setVisible(false); // Hide the merchPanel
                next.setVisible(true);
                previous.setVisible(false);
                itemsFL.setVisible(true);
                
                itemsPanel.revalidate(); // Revalidate the itemsPanel
                itemsPanel.repaint(); // Repaint the itemsPanel
            }
        });
        
        itemsFL = new JButton("View Full List");
        itemsFL.setHorizontalAlignment(SwingConstants.CENTER);
        itemsFL.setFont(new Font("Tahoma", Font.BOLD, 15));
        itemsFL.setBackground(new Color(0x293478));
        itemsFL.setForeground(Color.WHITE);
        itemsFL.setBounds(150, 525, 150, 25);
        itemsFL.setFocusable(false);
        itemsPanel.add(itemsFL);
        itemsFL.addActionListener(this); // Register the action listener
        itemsFL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame uListFrame = new JFrame("UNIFORM LIST");
                uListFrame.setSize(1000, 1000);
                
                JLabel uLabel = new JLabel("OFFICIAL UNIFORM LIST");
                uLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
                uLabel.setForeground(new Color(0xFFBD59));
                uLabel.setBounds(150, 25, 700, 60);
                uLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label horizontally
                
                // Create the merchPanel
                JPanel uListPanel = new JPanel();
                uListPanel.setBackground(new Color(0x293478));
                uListPanel.setBounds(0, 0, 1000, 1000);
                uListPanel.setLayout(null);

                // Create the list of image paths
                List<String> imagePaths = Arrays.asList(
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl1.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl3.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl4.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl5.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl6.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl8.jpg",                  
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl9.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl11.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl3.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\uf14.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl5.jpg",
                  "C:\\Users\\Charles\\Downloads\\ufl\\ufl6.jpg"
                );

                int imageHeight = 1257; // Set the desired height for the images
                int imageWidth = 780; // Set the desired width for the images
                int yPos = 10; // Starting position for the first image label

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

                for (String imagePath : imagePaths) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image originalImage = imageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
                    imageIcon = new ImageIcon(scaledImage);

                    JLabel imageLabel = new JLabel(imageIcon);
                    imageLabel.setBounds(10, yPos, imageWidth, imageHeight);
                    panel.add(imageLabel);

                    yPos += imageHeight + 10; // Increment the y-position for the next image
                }

                JScrollPane unifList = new JScrollPane(panel);
                unifList.setBounds(100, 100, 800, 600); // Adjust the size of the scroll pane to accommodate the resized images


                // Add components to the merchPanel
                uListPanel.add(uLabel);
                uListPanel.add(unifList);

                // Add the merchPanel to the frame
                uListFrame.getContentPane().add(uListPanel);

                // Set frame properties
                uListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                uListFrame.setLocationRelativeTo(null); // Center the frame on the screen
                uListFrame.setVisible(true); // Make the frame visible
            }
        });
        
        merchFL = new JButton("View Full List");
        merchFL.setHorizontalAlignment(SwingConstants.CENTER);
        merchFL.setFont(new Font("Tahoma", Font.BOLD, 15));
        merchFL.setBackground(new Color(0x293478));
        merchFL.setForeground(Color.WHITE);
        merchFL.setBounds(380, 525, 150, 25);
        merchFL.setFocusable(false);
        merchFL.addActionListener(this); // Register the action listener
        merchFL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame mListFrame = new JFrame("MERCHANDISE LIST");
                mListFrame.setSize(1000, 1000);
                
                JLabel mLabel = new JLabel("OFFICIAL MERCHANDISE LIST");
                mLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
                mLabel.setForeground(new Color(0xFFBD59));
                mLabel.setBounds(140, 25, 700, 60);
                mLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label horizontally
                
                // Create the merchPanel
                JPanel mListPanel = new JPanel();
                mListPanel.setBackground(new Color(0x293478));
                mListPanel.setBounds(0, 0, 1000, 1000);
                mListPanel.setLayout(null);

                // Create the list of image paths
                List<String> imagePaths = Arrays.asList(
                "C:\\Users\\Charles\\Downloads\\mfl\\mfl1.jpg",
                "C:\\Users\\Charles\\Downloads\\mfl\\mfl2.jpg",
                "C:\\Users\\Charles\\Downloads\\mfl\\mfl3.jpg",
                "C:\\Users\\Charles\\Downloads\\mfl\\mfl4.jpg",
                "C:\\Users\\Charles\\Downloads\\mfl\\mfl6.jpg",
                "C:\\Users\\Charles\\Downloads\\mfl\\mfl7.jpg"
                );

                int imageHeight = 1257; // Set the desired height for the images
                int imageWidth = 780; // Set the desired width for the images
                int yPos = 10; // Starting position for the first image label

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack the images vertically

                for (String imagePath : imagePaths) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image originalImage = imageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH); // Resize the image
                    imageIcon = new ImageIcon(scaledImage);

                    JLabel imageLabel = new JLabel(imageIcon);
                    imageLabel.setBounds(10, yPos, imageWidth, imageHeight);
                    panel.add(imageLabel);

                    yPos += imageHeight + 10; // Increment the y-position for the next image
                }

                JScrollPane merchfList = new JScrollPane(panel);
                merchfList.setBounds(100, 100, 800, 600); // Adjust the size of the scroll pane to accommodate the resized images


                // Add components to the merchPanel
                mListPanel.add(mLabel);
                mListPanel.add(merchfList);

                // Add the merchPanel to the frame
                mListFrame.getContentPane().add(mListPanel);

                // Set frame properties
                mListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mListFrame.setLocationRelativeTo(null); // Center the frame on the screen
                mListFrame.setVisible(true); // Make the frame visible
            }
        });
