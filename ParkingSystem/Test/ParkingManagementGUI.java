package ParkingSystem.Test;

import ParkingSystem.Exceptions.ParkingSlotNotAvailableException;
import ParkingSystem.Exceptions.VehicleNotFoundException;
import ParkingSystem.Service.ParkingManagement;
import ParkingSystem.Service.ResidentVehicle;
import ParkingSystem.Service.VisitorVehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingManagementGUI extends JFrame implements ActionListener {

    boolean flag;
    CardLayout card;
    JPanel panel;
    ImageIcon logo;
    ParkingManagement parkingManagement;

    JPanel hp;
    JButton b1,b2,b3;
    JTextField tf1;

    JPanel rvp;
    JButton b4,b5,b6,b7;
    JTextField tf2;

    JPanel cio;
    JTextField tf9,tf10;
    JLabel l6;
    JButton b9,b10,b11;

    JPanel ot;
    JTextField tf11,tf12,tf13;
    JLabel l7,l8;
    JButton b12,b13;

    JPanel ap;
    JTextField tf3,tf4,tf5,tf6,tf7,tf8;
    JLabel l1,l2,l3,l4,l5;
    JButton b8,b14;

    JPanel dp;
    JTextField tf14;
    JTextArea ta1;
    JButton b15;
    JScrollPane scroll;




    ParkingManagementGUI()
    {
        panel = new JPanel();
        card = new CardLayout();
        panel.setLayout(card);
        flag = true;
        parkingManagement = new ParkingManagement();


        homePage();
        add();
        residentOrVisitorPage();
        checkIO();
        setOutTime();
        details();

        setFont();

        panel.add(hp,"1");
        panel.add(rvp,"2");
        panel.add(cio,"3");
        panel.add(ot,"4");
        panel.add(ap,"5");
        panel.add(dp,"6");

        card.show(panel,"1");

        add(panel);
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Parking System");

        // ImageIcon logo;
        logo  = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\ParkingManagementSystem" +
                                      "\\src\\main\\java\\ParkingSystem\\Test\\logo.png");
        // give absolute path for image
        setIconImage(logo.getImage());

    }

    public  void homePage(){
        hp = new JPanel();
        hp.setLayout(null);
        hp.setBackground(new Color(30, 74, 186));

        b1 = new JButton("Resident");
        b2 = new JButton("Visitor");
        b3 = new JButton("Display");

        tf1 = new JTextField("Home Page");

        tf1.setBackground(new Color(8, 245, 141));
        tf1.setForeground(new Color(0,0,0));
        tf1.setHorizontalAlignment(JTextField.CENTER);
        tf1.setEditable(false);

        hp.add(tf1);hp.add(b1);hp.add(b2);
        hp.add(b3);

        tf1.setBounds(0,0,500,35);
        b1.setBounds(200,100,100,50);
        b2.setBounds(200,200,100,50);
        b3.setBounds(200,300,100,50);

        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void residentOrVisitorPage(){
        rvp = new JPanel();
        rvp.setLayout(null);
        rvp.setBackground(new Color(178, 18, 196));

        b4 = new JButton("Add");
        b5 = new JButton("Set");
        b6 = new JButton("Count");
        b7 = new JButton("Home");

        tf2 = new JTextField("Vehicle");

        tf2.setBackground(new Color(174, 245, 8));
        tf2.setForeground(new Color(0,0,0));
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf2.setEditable(false);

        tf2.setBounds(0,0,500,35);
        b4.setBounds(200,70,100,50);
        b5.setBounds(200,170,100,50);
        b6.setBounds(200,270,100,50);
        b7.setBounds(200,370,100,50);

        rvp.add(b4);rvp.add(b5);
        rvp.add(b6);rvp.add(b7);
        rvp.add(tf2);

        b4.setFocusable(false);
        b5.setFocusable(false);
        b6.setFocusable(false);
        b7.setFocusable(false);

        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    }

    public void checkIO()
    {
        cio = new JPanel();
        cio.setLayout(null);
        cio.setBackground(new Color(158, 39, 39));


        l6 = new JLabel("Reg No");
        l6.setBounds(100,100,100,50);
        l6.setFont(new Font("Times new roman", Font.BOLD,25));

        tf10 = new JTextField();
        tf10.setBounds(205,113,100,25);

        tf9 = new JTextField("CheckIn/CheckOut");
        tf9.setBounds(50,100,100,50);


        tf9.setBackground(new Color(8, 115, 245));
        tf9.setForeground(new Color(21, 20, 20));
        tf9.setHorizontalAlignment(JTextField.CENTER);
        tf9.setEditable(false);

        tf9.setBounds(0,0,500,35);

        b9  = new JButton("In");
        b10 = new JButton("Out");
        b11 = new JButton("Home");
        b9.setBounds(100,170,100,50);
        b10.setBounds(220,170,100,50);
        b11.setBounds(340,170,100,50);

        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);

        b9.setFocusable(false);
        b10.setFocusable(false);
        b11.setFocusable(false);

        b11.setVisible(false);

        cio.add(tf9);cio.add(tf10);
        cio.add(l6);cio.add(b9);
        cio.add(b10);cio.add(b11);
    }

    public void setOutTime()
    {
        ot = new JPanel();
        ot.setLayout(null);
        ot.setBackground(new Color(23, 182, 76));

        tf11 = new JTextField("OutTime");
        tf11.setBounds(0,0,500,50);



        tf11.setBackground(new Color(134, 8, 245));
        tf11.setForeground(new Color(21, 20, 20));
        tf11.setHorizontalAlignment(JTextField.CENTER);
        tf11.setEditable(false);

        l7 = new JLabel("Reg No");
        l7.setBounds(100,100,100,50);
        l7.setFont(new Font("Times new roman", Font.BOLD,25));

        tf12 = new JTextField();
        tf12.setBounds(205,113,100,25);

        tf13 = new JTextField();
        tf13.setBounds(205,163,100,25);

        b12 = new JButton("Set");
        b13 = new JButton("Home");


        l8 = new JLabel("OutTime");
        l8.setBounds(100,150,100,50);
        l8.setFont(new Font("Times new roman", Font.BOLD,25));


        b12.setBounds(100,220,100,50);
        b13.setBounds(220,220,100,50);



        b12.addActionListener(this);
        b13.addActionListener(this);

        b12.setFocusable(false);
        b13.setFocusable(false);

        ot.add(tf11);ot.add(tf12);
        ot.add(b12);ot.add(b13);
        ot.add(l7);ot.add(l8);
        ot.add(tf13);

    }


    public void add()
    {
        ap = new JPanel();
        ap.setLayout(null);
        ap.setBackground(new Color(21, 236, 161));

        tf3 = new JTextField("Add");

        tf3.setBounds(0,0,500,50);

        tf3.setBackground(new Color(245, 8, 241));
        tf3.setForeground(new Color(21, 20, 20));
        tf3.setHorizontalAlignment(JTextField.CENTER);
        tf3.setEditable(false);

        l1 = new JLabel("Reg No");
        l1.setBounds(80,100,100,50);
        l1.setFont(new Font("Times new roman", Font.BOLD,25));

        l2 = new JLabel("Name");
        l2.setBounds(80,150,100,50);
        l2.setFont(new Font("Times new roman", Font.BOLD,25));

        l3 = new JLabel("Phone No");
        l3.setBounds(80,200,120,50);
        l3.setFont(new Font("Times new roman", Font.BOLD,25));


        l4 = new JLabel("Flat No");
        l4.setBounds(80,250,100,50);
        l4.setFont(new Font("Times new roman", Font.BOLD,25));

        l5 = new JLabel("InTime");
        l5.setBounds(80,300,100,50);
        l5.setFont(new Font("Times new roman", Font.BOLD,25));

        tf4 = new JTextField();
        tf4.setBounds(220,115,100,25);

        tf5 = new JTextField();
        tf5.setBounds(220,165,100,25);

        tf6 = new JTextField();
        tf6.setBounds(220,215,100,25);

        tf7 = new JTextField();
        tf7.setBounds(220,265,100,25);

        tf8 = new JTextField();
        tf8.setBounds(220,315,100,25);

        b8 = new JButton("Submit");
        b14 = new JButton("Home");

        b14.setBounds(100,365,100,50);
        b8.setBounds(220,365,100,50);

        b8.addActionListener(this);
        b14.addActionListener(this);

        b8.setFocusable(false);

        ap.add(tf3);ap.add(l1);ap.add(l2);
        ap.add(l3);ap.add(l4);ap.add(l5);
        ap.add(tf4);ap.add(tf5);ap.add(tf6);ap.add(tf7);
        ap.add(tf8);ap.add(b8);ap.add(b14);
    }

    public void details()
    {
        dp = new JPanel();
        dp.setLayout(null);

        tf14 = new JTextField("Vehicle Details");

        tf14.setBounds(0,0,500,50);

        tf14.setBackground(new Color(8, 40, 245));
        tf14.setForeground(new Color(21, 20, 20));
        tf14.setHorizontalAlignment(JTextField.CENTER);
        tf14.setEditable(false);



        ta1 = new JTextArea("Hai");

        ta1.setEditable(false);
        scroll = new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
                ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(0,50,490,300);
        scroll.setVisible(true);
        b15 = new JButton("Home");
        b15.setBounds(360,360,100,50);

        b15.setFocusable(false);

        dp.add(b15);dp.add(scroll);dp.add(tf14);
        dp.add(scroll);
        b15.addActionListener(this);


    }

    public void setFont(){
        Font f1 = new Font("Courier",Font.BOLD,25);
        tf1.setFont(f1);tf2.setFont(f1);tf3.setFont(f1);
        tf11.setFont(f1);tf14.setFont(f1);tf9.setFont(f1);

        Font f2 = new Font("Times",Font.BOLD,15);
        b1.setFont(f2);b2.setFont(f2);b3.setFont(f2);
        b4.setFont(f2);b5.setFont(f2);b6.setFont(f2);
        b7.setFont(f2);b8.setFont(f2);b9.setFont(f2);
        b10.setFont(f2);b11.setFont(f2);b12.setFont(f2);
        b13.setFont(f2);b14.setFont(f2);b15.setFont(f2);


        ta1.setFont(f2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            flag = true;
            tf2.setText("Resident Vehicle");
            rvp.setBackground(new Color(178, 18, 196));
            card.show(panel,"2");
        }
        else if(e.getSource() == b2){
            flag = false;
            tf2.setText("Visitor Vehicle");
            rvp.setBackground(new Color(23, 92, 76));
            card.show(panel,"2");
        }
        else if(e.getSource() == b7 || e.getSource() == b11 ||
                e.getSource() == b13 || e.getSource() == b14 || e.getSource() == b15){
            card.show(panel,"1");
        }
        else if(e.getSource() == b5){
            if(flag) {
                b11.setVisible(false);
                tf10.setText("");
                card.show(panel, "3");
            }
            else{

                tf12.setText("");
                card.show(panel, "4");
            }
        }
        else if(e.getSource() == b9){
            boolean status = parkingManagement.setParkingStatus(tf10.getText().trim(),true);
            if(status)
                JOptionPane.showMessageDialog(this
                              ,"status set successfully");
            else
                JOptionPane.showMessageDialog(this
                                       ,"Wrong register number"
                                      ,"Wrong",JOptionPane.WARNING_MESSAGE);
            b11.setVisible(true);
        }
        else if(e.getSource() == b10){
            boolean status = parkingManagement.setParkingStatus(tf10.getText().trim(),false);
            if(status)
                JOptionPane.showMessageDialog(this
                               ,"status set successfully");
            else
                JOptionPane.showMessageDialog(this
                          ,"Wrong register number"
                          ,"Wrong",JOptionPane.WARNING_MESSAGE);
            b11.setVisible(true);
        }
        else if(e.getSource() == b12){

            try {
                parkingManagement.setVisitorVehicleOutTime(tf12.getText().trim()
                                       ,tf13.getText().trim());
                JOptionPane.showMessageDialog(this
                                        ,"OutTime set successfully");
            } catch (VehicleNotFoundException vehicleNotFoundException) {
                JOptionPane.showMessageDialog(this
                                      ,"Wrong register number"
                                      ,"Wrong",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource() == b4){
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
            if(flag){
                l5.setVisible(false);
                tf8.setVisible(false);
            }
            else{
                l5.setVisible(true);
                tf8.setVisible(true);
            }
            card.show(panel,"5");
        }
        else if(e.getSource() == b3){
            ta1.setText("");
            String s = parkingManagement.displayAllVehicles();

            ta1.setText(s);
            card.show(panel,"6");
        }
        else if(e.getSource() == b6){
            if(flag){
                int count = parkingManagement.getParkedResidentVehicleCount();
                JOptionPane.showMessageDialog(this
                                  ,"No of Resident Vehicle count : "+count);
            }
            else{
                int count = parkingManagement.getParkedVisitorVehicleCount();
                JOptionPane.showMessageDialog(this
                        ,"No of Visitor Vehicle count : "+count);
            }
        }
        else if(e.getSource() == b8){
            if(flag){
                try {
                    String s = parkingManagement.addVehicle(new ResidentVehicle(tf4.getText(),
                            tf5.getText(),Long.valueOf(tf6.getText()),
                            Integer.parseInt(tf7.getText()),true));
                    JOptionPane.showMessageDialog(this,s);
                } catch (ParkingSlotNotAvailableException parkingSlotNotAvailableException) {

                }
            }
            else{
                try {
                    String s = parkingManagement.addVehicle(new VisitorVehicle(tf4.getText(),
                            tf5.getText(),Long.valueOf(tf6.getText()),
                            Integer.parseInt(tf7.getText()),tf8.getText()));
                    JOptionPane.showMessageDialog(this,s);
                } catch (ParkingSlotNotAvailableException parkingSlotNotAvailableException) {
                    JOptionPane.showMessageDialog(this
                            ,parkingSlotNotAvailableException.getMessage());
                }
            }
            card.show(panel,"1");
        }
    }

    public static void main(String[] args){
        new ParkingManagementGUI();
    }
}