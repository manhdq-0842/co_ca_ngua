package Games;
import javax.swing.*;

import Util.Xucxac;
public class Start extends JFrame {
	 // Variables declaration - do not modify//GEN-BEGIN:variables
		int j = 0;
	    int i = 4;    //chon so nguoi choi 1-4
	    JFrame windowBefore;
	    static Music music = new Music("HopeYou.mp3");
	    
	    private ButtonGroup  Number_player;
	    private JButton 	 btnStart;
	    private JButton 	 btnSpeaker;
	    private JLabel 		 lb_SoNguoiChoi;
	    private JLabel 		 iconCaNgua;
	    private JRadioButton one_player;
	    private JRadioButton two_player;
	    private JRadioButton three_player;
	    private JRadioButton four_player;
	    // End of variables declaration//GEN-END:variables
	    
    public Start(JFrame windowBefore) {
    	this.windowBefore = windowBefore;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	  try {
              for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                      UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          } catch (ClassNotFoundException ex) {
              java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (UnsupportedLookAndFeelException ex) {
              java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
    	
        Number_player =		new ButtonGroup();
        iconCaNgua =	 	new JLabel();
        lb_SoNguoiChoi = 	new JLabel();
        one_player = 		new JRadioButton();
        two_player = 		new JRadioButton();
        three_player = 		new JRadioButton();
        four_player = 		new JRadioButton();
        btnStart = 			new JButton();
        btnSpeaker = 		new JButton();

        setLocation(344, 75);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        iconCaNgua.setForeground(new java.awt.Color(255, 255, 102));
        iconCaNgua.setIcon(new ImageIcon(Handler.ImageTool.getImage(80))); // NOI18N
        iconCaNgua.setText("iconCaNgua");

        lb_SoNguoiChoi.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lb_SoNguoiChoi.setText("Số người chơi");

        Number_player.add(one_player);
        one_player.setText("1 Người chơi");
        one_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	one_playerActionPerformed(evt);
                
            }
        });
        
        Number_player.add(two_player);
        two_player.setText("2 Người chơi");
        two_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	two_playerActionPerformed(evt);
                
            }
        });
        
        Number_player.add(three_player);
        three_player.setText("3 Người chơi");
        three_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	three_playerActionPerformed(evt);
                
            }
        });
        
        Number_player.add(four_player);
        four_player.setText("4 Người chơi");
        four_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                four_playerActionPerformed(evt);
                
            }
        });

        btnStart.setBackground(new java.awt.Color(0, 204, 204));
        btnStart.setFont(new java.awt.Font("Rosewood Std Regular", 2, 36)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 0, 0));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
            	btnStartActionPerformed(evt);
            }
        });
        music.play();
        btnSpeaker.setIcon(new ImageIcon(Handler.ImageTool.getImage(82))); // NOI18N
        btnSpeaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(j==0){
            		btnSpeaker.setIcon(new ImageIcon(Handler.ImageTool.getImage(81)));
            		music.stop();
            		j = 1;
            	}else{
            		btnSpeaker.setIcon(new ImageIcon(Handler.ImageTool.getImage(82)));           		
            		music.stop();
            		music.play();
            		j = 0;
        		}
            }
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSpeaker, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(iconCaNgua, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(two_player)
                                    .addComponent(one_player)
                                    .addComponent(three_player)
                                    .addComponent(four_player))
                                .addGap(48, 48, 48))
                            .addComponent(lb_SoNguoiChoi))
                        .addGap(132, 132, 132)
                        .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSpeaker)
                .addGap(8, 8, 8)
                .addComponent(iconCaNgua, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_SoNguoiChoi, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(one_player, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(two_player)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(three_player))
                    .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(four_player)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
        
    }// </editor-fold>//GEN-END:initComponents

    private void one_playerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_four_playerActionPerformed
    	setI(1);		 	
    }//GEN-LAST:event_four_playerActionPerformed
    
    private void two_playerActionPerformed(java.awt.event.ActionEvent evt) {
    	setI(2);    	
    }
    
    private void three_playerActionPerformed(java.awt.event.ActionEvent evt) {
		setI(3);    
    }
    
    private void four_playerActionPerformed(java.awt.event.ActionEvent evt) {
		setI(4);    	
    }
    
	public void setI(int i) {
		DummiesGame.currChoice = i;
	}

	private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		windowBefore.setVisible(true);
	}
}
