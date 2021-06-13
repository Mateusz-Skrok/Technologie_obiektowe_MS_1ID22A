import javax.swing.*;

public class Message extends javax.swing.JFrame {


    public Message() {
        initComponents();
    }


    private void initComponents() {

        messageLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        messageButton = new javax.swing.JButton();

        setTitle("Message");
        setLocationByPlatform(true);

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        messageButton.setText("OK");
        messageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(messageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(messageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void messageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    public void setText(String text)
    {
        messageLabel.setText(text);
    }


    private javax.swing.JButton messageButton;
    private javax.swing.JLabel messageLabel;


}
