import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by acer on 20-Oct-17.
 */
class main{
    public static void main(String[] args) {
        ProgressBar progressBar=new ProgressBar();
        progressBar.setLayout(new GridLayout(1,1));
        progressBar.setEnabled(true);
        progressBar.setVisible(true);
        progressBar.setTitle("Circular Progress Bar");
        progressBar.setSize(500,300);
        progressBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class ProgressBar extends JFrame{

    CustomPannel customPannel =new CustomPannel();
    CustomPannel customPannel1=new CustomPannel();
    GridBagConstraints conn = new GridBagConstraints();
    private JButton okButton;
    private JPanel panel1;
    private JLabel L1;

    public ProgressBar() {

        panel1 =new JPanel(new GridBagLayout());
        panel1.setVisible(true);
        panel1.setEnabled(true);
        add(panel1);

        okButton =new JButton("Ok");
        okButton.setEnabled(true);
        okButton.setVisible(true);
        conn.gridx=0;
        conn.gridy=0;
        conn.gridwidth=1;
        conn.gridheight=1;
        conn.fill=GridBagConstraints.BOTH;
        panel1.add(okButton,conn);

        L1=  new JLabel("2");
        L1.setEnabled(true);
        L1.setVisible(true);
        conn.gridx=1;
        conn.gridy=0;
        conn.gridwidth=1;
        conn.gridheight=1;
        conn.fill=GridBagConstraints.BOTH;
        panel1.add(L1,conn);

        customPannel.setVisible(true);
        customPannel.setEnabled(true);
        customPannel.radius=50;
        customPannel.barColor=Color.GREEN;
        customPannel.fontColor=Color.GREEN;
        conn.gridx=0;
        conn.gridy=1;
        conn.weighty=3;
        conn.weightx=3;
        conn.gridwidth=3;
        conn.gridheight=1;
        conn.fill=GridBagConstraints.BOTH;
        panel1.add(customPannel,conn);

        customPannel1.setVisible(true);
        customPannel1.setEnabled(true);
        conn.gridx=4;
        conn.gridy=1;
        conn.weighty=3;
        conn.weightx=3;
        conn.gridwidth=3;
        conn.gridheight=1;
        conn.fill=GridBagConstraints.BOTH;
        panel1.add(customPannel1,conn);

        okButton.addActionListener(new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (i=0;i<=100;i++) {
                            L1.setText(String.valueOf(i)+" %");
                            customPannel.Update(i);
                            customPannel.repaint();
                            customPannel1.Update(i);
                            customPannel1.repaint();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e1) {
                                JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
