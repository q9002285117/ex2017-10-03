import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbt1=new JButton("example");
    private JButton jbt2=new JButton("encryption");
    private JLabel jlb=new JLabel("key");
    private JButton jbt3=new JButton("clear");
    private JButton jbt4=new JButton("exit");
    private JPanel jpnc=new JPanel(new GridLayout(6,1,3,3));
    private JTextField jtfkey=new JTextField("3");
    private JTextArea jtaL=new JTextArea();
    private JTextArea jtaR=new JTextArea();
    private JScrollPane jspL=new JScrollPane(jtaL);
    private JScrollPane jspR=new JScrollPane(jtaR);
    private int count=0;
    public MainFrame(){
        init();
    }private void init(){
        this.setBounds(100,100,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("凱薩加密法");
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        jpnc.add(jbt1);
        cp.add(jpnc,BorderLayout.CENTER);
        jpnc.add(jbt2);
        jlb.setHorizontalAlignment(JLabel.CENTER);
        jpnc.add(jlb);
        jpnc.add(jtfkey);
        jpnc.add(jbt3);
        jpnc.add(jbt4);
        jtaL.setLineWrap(true);
        jtaL.setPreferredSize(new Dimension(200,400));
        cp.add(jspL,BorderLayout.WEST);
        cp.add(jspR,BorderLayout.EAST);
        jtaR.setLineWrap(true);
        jtaR.setPreferredSize(new Dimension(200,400));

        jbt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
             jtaL.setText("The first “Best of the Best” RedDot-awarded work “Neiwan Love Story” " +
                     "is designed by students, Tzu-Yen Huang, Ya-Ching Chiang, Hsiao-Yun Su and" +
                     " Ya-Chien Chang, from the VCD Dept. at AU. The work includes innovative designs " +
                     "of slogans, DMs, posters, guide books, as well as related APPs for use on smart phones, " +
                     "all aiming at promoting the propaganda of six scenic spots in the historical countryside " +
                     "of Neiwan in Hsinchu County, Taiwan");
            }
        });
        jbt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[]=jtaL.getText().toCharArray();
                int len=data.length,key=Integer.parseInt(jtfkey.getText());
                for(int i=0;i<len;i++){
                    data[i]+=key;
                }
                jtaR.setText(new String(data));
            }
        });
        jbt3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });
        jbt4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
        });
    }
}
