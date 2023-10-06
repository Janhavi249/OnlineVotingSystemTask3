import javax.swing.*;
import javafx.scene.control.Button;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;


class OnlineVotingSystem
{
    static HashMap<String , String> map=new HashMap<>();
    static int A=0;
    static int B=0;
    static int C=0;
    static String out;
    

    public static void main(String args[])
    {
        JFrame frame1 = new JFrame("Online Voting System");

        JPanel panel1 = new JPanel();

        JLabel head = new JLabel("ONLINE VOTING SYSTEM");
        JLabel lable1 = new JLabel("    ENTER NAME");
        JLabel lable2 = new JLabel("    ENTER PHONE");
        JLabel lable3 = new JLabel("    CAST YOUR VOTE HERE");

        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();

        JRadioButton radiobutton1 = new JRadioButton("PARTY A");
        JRadioButton radiobutton2 = new JRadioButton("PARTY B");
        JRadioButton radiobutton3 = new JRadioButton("PARTY C");

        JButton button1 = new JButton("SUBMIT YOUR VOTE");
        JButton button2 = new JButton("CHECK RESULT");

        ButtonGroup groupbutton = new ButtonGroup();

        Font font1 = new Font("SERIF", Font.PLAIN, 20);

        panel1.setLayout(null);
        head.setBounds(50, 0, 400, 50);
        lable1.setBounds(0, 40, 220, 50);
        lable2.setBounds(0, 90, 220, 50);
        lable3.setBounds(0, 160, 220, 100);
        text1.setBounds(210, 50, 300, 30);
        text2.setBounds(210, 100, 300, 30);
        radiobutton1.setBounds(13, 220, 150, 50);
        radiobutton2.setBounds(13, 270, 150, 50);
        radiobutton3.setBounds(13, 320, 150, 50);
        button1.setBounds(170, 230, 150, 50);
        button2.setBounds(170, 310, 150, 50);
        head.setFont(font1);
        groupbutton.add(radiobutton1);
        groupbutton.add(radiobutton2);
        groupbutton.add(radiobutton3);
        panel1.add(head);
        panel1.add(lable1);
        panel1.add(lable2);
        panel1.add(lable3);
        panel1.add(text1);
        panel1.add(text2);
        panel1.add(radiobutton1);
        panel1.add(radiobutton2);
        panel1.add(radiobutton3);
        panel1.add(button1);
        panel1.add(button2);
        panel1.setBackground(Color.CYAN);
        
        button1.addMouseListener(
            new MouseListener() {
                public void mouseEntered(MouseEvent e){
                }         

                public void mouseExited(MouseEvent e){
                }

                public void mousePressed(MouseEvent e){
                }

                public void mouseReleased(MouseEvent e){
                }

                public void mouseClicked(MouseEvent e){
                    String str1 = text1.getText();
                    String str2 = text2.getText();
                    if(str1.isEmpty()){
                        JOptionPane.showMessageDialog(new JFrame(), "Please enter Name");
                    }
                    else if (str2.isEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Please enter Phone");
                    }
                    else if (map.containsKey(str1) || map.containsKey(str2)) {
                        JOptionPane.showMessageDialog(new JFrame(), "You have already voted");
                    }
                    else {
                        int i = JOptionPane.showConfirmDialog(new JFrame(), "DO You Want To Confirm Your Vote?");
                        if (i==0)
                        {
                            if (radiobutton1.isSelected()) {
                                A += 1;
                            }
                            else if (radiobutton2.isSelected()) {
                                B +=1;
                            }
                            else if (radiobutton3.isSelected()) {
                                C += 1;
                            }
                            map.put(str1, str2);
                            text1.setText("");
                            text2.setText("");
                            groupbutton.clearSelection();
                        }
                    }
                }
            });

            button2.addMouseListener(
                    new MouseListener() {
                public void mouseEntered(MouseEvent e){
                }         

                public void mouseExited(MouseEvent e){
                }

                public void mousePressed(MouseEvent e){
                }

                public void mouseReleased(MouseEvent e){
                }

                public void mouseClicked(MouseEvent e){
                    if (A > B && A > C) {
                        out = "Party A has a Lead";
                    }
                    else if (B > A && B > C) {
                        out = "Party B has a Lead";
                    }
                    else if(C > A && C > B) {
                        out = "Party C has a Lead";
                    }
                    else {
                        out = "Something Went Wrong";
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "PARTY A"+ A + "\nPARTY B " + B +"\nPARTY C"+ C +"\n\n" +out);
                }
            });

            frame1.add(panel1);
            frame1.setSize(550,450);
            frame1.setLocation(300, 80);
            frame1.setVisible(true);
            frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
     }
}