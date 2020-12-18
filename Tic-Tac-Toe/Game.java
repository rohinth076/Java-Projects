import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game extends JFrame implements ActionListener {
     ImageIcon icon ;
     JTextField tf1;
     JButton [][]jb;
     JButton  rs,ng;
     JTextField tfx,tfy,xs,ys,vs;
     String [][]a;
     int x;

     final String [] tf1v = {"X-Turn","O-Turn"};
     Game()
     {
          x = 0;
          a = new String[3][3];

          tf1 = new JTextField(tf1v[0]);
          tf1.setForeground(Color.RED);
          tfx = new JTextField("Player X");
          tfy = new JTextField("Player O");
          xs  = new JTextField("0");
          ys  = new JTextField("0");
          vs = new JTextField("VS");
          icon = new ImageIcon(JFrame.class.getResource("/logo.jpg"));

          jb = new JButton[3][3];
          rs = new JButton("Restart");
          ng = new JButton("New Game");

          setLayout(null);
          getContentPane().setBackground(new Color(0x123456));
          for(int i=0;i<3;i++)
               for(int j=0;j<3;j++){
                    jb[i][j] = new JButton();   // Create button object
                    jb[i][j].setOpaque(true);
                    jb[i][j].setBackground(new Color(255,255,255));
                    add(jb[i][j]);
                    jb[i][j].setBounds(50+(j*100),80+(i*100),100,100);
                    jb[i][j].setFont(new Font("TORCH",Font.BOLD,75));
                    a[i][j] = "";
               }


          setVisible(true);
          setSize(500,500);


          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          setTitle("Tic-Tac-Toe");
          setResizable(false);
          setIconImage(icon.getImage());


          tf1.setFont(new Font("DenMark",Font.BOLD,20));
          tfx.setFont(new Font("Times new roman", Font.PLAIN,25));
          tfy.setFont(new Font("Times new roman", Font.PLAIN,25));
          xs.setFont(new Font("Times new roman", Font.PLAIN,25));
          ys.setFont(new Font("Times new roman", Font.PLAIN,25));
          vs.setFont(new Font("Times new roman", Font.BOLD,25));

          rs.setEnabled(false);
          ng.setEnabled(false);



          add(tf1);add(tfx);add(tfy);
          add(xs);add(ys);add(vs);
          add(rs);add(ng);

          tf1.setHorizontalAlignment(JTextField.CENTER);
          tfx.setBackground(new Color(0x4e42f5));
          tfy.setBackground(new Color(0x4e42f5));

          tf1.setBounds(0,0,500,30);
          rs.setBounds(380,100,100,50);
          ng.setBounds(380,170,100,50);
          tfx.setBounds(40,420,100,30);
          xs.setBounds(140,420,30,30);
          vs.setBounds(180,420,40,30);
          ys.setBounds(230,420,30,30);
          tfy.setBounds(260,420,100,30);

          tf1.setEditable(false);
          tfx.setEditable(false);
          tfy.setEditable(false);
          xs.setEditable(false);
          ys.setEditable(false);

          for(int i=0;i<3;i++)
               for(int j=0;j<3;j++)
                    jb[i][j].addActionListener(this);

          rs.addActionListener(this);
          ng.addActionListener(this);
         
     jb[0][0].setIcon(icon);
     }

    @Override
    public void actionPerformed(ActionEvent e) {

          if(e.getSource() == rs){
               restart();
          }
          else if(e.getSource() == ng){
               newGame();
          }
          else{
               for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++)
                         if(e.getSource() == jb[i][j]){
                              if(a[i][j].equals("")){
                                   if(x%2 == 0){
                                        jb[i][j].setText("X");
                                        jb[i][j].setForeground(Color.RED);
                                        a[i][j] = "X";
                                        tf1.setText(tf1v[1]);
                                        tf1.setForeground(Color.BLUE);
                                   }
                                   else{
                                        jb[i][j].setText("O");
                                        jb[i][j].setForeground(Color.BLUE);
                                        a[i][j] = "O";
                                        tf1.setText(tf1v[0]);
                                        tf1.setForeground(Color.RED);
                                   }
                                   String result = decision_maker();
                                   if(!result.isEmpty()){
                                        if(result.equalsIgnoreCase("X")){
                                             tf1.setText("Player X wins");
                                             tf1.setForeground(Color.RED);
                                             xs.setText(String.valueOf(Integer.valueOf(xs.getText())+1));
                                        }
                                        else if(result.equalsIgnoreCase("O")){
                                             tf1.setText("Player O wins");
                                             tf1.setForeground(Color.BLUE);
                                             ys.setText(String.valueOf(Integer.valueOf(ys.getText())+1));
                                        }
                                        else{
                                             tf1.setText("Tie");
                                             tf1.setForeground(Color.CYAN);
                                        }
                                        freeze();
                                        break;
                                   }
                                   x++;
                              }
                              break;
                         }
          }
    }
     /*After finished the game this function helps to freeze(disable) the box*/
    public void freeze(){
         for(int i=0;i<3;i++)
              for(int j=0;j<3;j++)
                   jb[i][j].setEnabled(false);
         rs.setEnabled(true);
         ng.setEnabled(true);
    }

     /*This function helps to find the winner of the game*/
     public String decision_maker()
     {
          String ans= "";
          for(int i=0;i<3;i++)
               if((! a[i][0].isEmpty()) && a[i][0].equals(a[i][1]) && a[i][0].equals(a[i][2]))
                    return a[i][0];

          for(int j=0;j<3;j++)
               if((! a[0][j].isEmpty()) && a[0][j].equals(a[1][j]) && a[0][j].equals(a[2][j]))
                    return a[0][j];

          if((! a[0][0].isEmpty()) && a[0][0].equals(a[1][1]) && a[0][0].equals(a[2][2]))
               return a[0][0];

          if((! a[0][2].isEmpty()) && a[0][2].equals(a[1][1]) && a[0][2].equals(a[2][0]))
               return a[0][2];

          int count = 0;
          for(int i=0;i<3;i++)
               for(int j=0;j<3;j++)
                    if(! a[i][j].isEmpty())
                         count++;
          if(count == 9)
               ans = "Tie";

          return ans;
     }

     /*This function clear all the marks from box*/
     public void newGame()
     {
          for(int i=0;i<3;i++)
               for(int j=0;j<3;j++)
                    jb[i][j].setText("");
          for(int i=0;i<3;i++)
               for(int j=0;j<3;j++)
                    a[i][j] = "";
          x = 0;
          for(int i=0;i<3;i++)
               for(int j=0;j<3;j++)
                    jb[i][j].setEnabled(true);
          rs.setEnabled(false);
          ng.setEnabled(false);
          tf1.setText(tf1v[0]);
          tf1.setForeground(Color.RED);
     }

     /*This function set the points as 0 and start the game from beginning*/
     public void restart()
     {
          xs.setText("0");
          ys.setText("0");
          newGame();
     }


     public static void main(String[] args) {
          new Game();
     }


}
