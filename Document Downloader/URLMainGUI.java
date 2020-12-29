import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLMainGUI extends JFrame implements ActionListener {

    JTextField tf1,tf2,tf3;
    JButton jb1,jb2;
    JLabel jl1,jl2;
    String folder;
    String URL;

    URLMainGUI(){
        setLayout(null);
        setVisible(true);
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(125, 248, 84));
        setTitle("Document Downloader");
        setIconImage(new ImageIcon("C:\\Java- DownLoad\\src\\logo.jpg").getImage());//Absolute path
        folder = "C:\\";
        URL = " ";


        jl1 = new JLabel("URL");
        jl2 = new JLabel("File Name");
        jb1 = new JButton("Download");
        jb2 = new JButton("Folder");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        jl1.setFont(new Font("Times New",Font.BOLD,25));
        jl2.setFont(new Font("Times New",Font.BOLD,25));

        jl1.setBounds(163,80,100,100);
        jl2.setBounds(100,150,150,100);

        tf1.setBounds(250,110,300,40);
        tf2.setBounds(250,180,300,40);jb2.setBounds(550,180,100,40);

        jb1.setBounds(450,240,200,40);
        tf3.setBounds(0,630,1000,50);

        tf3.setHorizontalAlignment(JTextField.CENTER);

        tf1.setFont(new Font("Times New",Font.BOLD,18));
        tf2.setFont(new Font("Times New",Font.BOLD,18));
        tf3.setFont(new Font("Times New",Font.BOLD,18));
        jb1.setFont(new Font("Times New",Font.BOLD,18));

        jb1.setBackground(new Color(31, 210, 159));
        jb2.setBackground(new Color(31, 210, 159));
        add(jl1);add(jl2);add(jb1);
        add(jb2);add(tf1);add(tf2);add(tf3);

        jb1.setFocusable(false);
        jb2.setFocusable(false);
        tf3.setEditable(false);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        tf3.setText("");
        if(e.getSource() == jb2){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                 folder = file.getAbsolutePath();
            }else{
                JOptionPane.showMessageDialog(this,"Select folder correctly");
            }
        }
        else if(e.getSource() == jb1){

            String file = tf2.getText().trim();
            if(!file.isEmpty())
                folder += "\\"+ file;
            else{
                JOptionPane.showMessageDialog(this,"Enter valid file name");
            }

            if(!tf1.getText().trim().isEmpty()){
                URL = tf1.getText().trim();
                run();
            }
            else{
                JOptionPane.showMessageDialog(this,"Enter valid URL");
            }

        }
    }



    public void run() {
        try{
            URL url = new URL(URL); // Object for URL
            HttpURLConnection http = (HttpURLConnection)url.openConnection(); //Enable connection
            File out = new File(folder);
            double fileSize = http.getContentLength();
            BufferedInputStream input = new BufferedInputStream(http.getInputStream()); // For Read Input from URL
            FileOutputStream fout = new FileOutputStream(out);
            BufferedOutputStream output = new BufferedOutputStream(fout,1024);// For Write output to Local(In system)

            byte[] buffer = new byte[1024];
            double downloaded =0.00;
            int read = 0;
            double percentDownloaded = 0.00;
            while((read = input.read(buffer,0,1024))>=0){
                output.write(buffer,0,read);
                downloaded += read;
                percentDownloaded = (downloaded*100)/fileSize;
                String percent = String.format("%.4f",percentDownloaded);
                tf3.setText("DownLoad "+percent+"% of a file");
            }
            tf3.setText("DownLoad Successfully");

            input.close();
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new URLMainGUI();
    }
}
