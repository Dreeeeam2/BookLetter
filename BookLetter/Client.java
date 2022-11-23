package BookLetter;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Client extends JFrame{
private PrintWriter writer = null;
Socket socket;
private JTextArea area = new JTextArea();//输入框
private  JTextField text = new JTextField();//文本域
public Client(){
    setTitle("Client");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container a = getContentPane();
    JScrollPane scrollPane = new JScrollPane();
    getContentPane().add(scrollPane,BorderLayout.CENTER);
    writer = new PrintWriter(System.out);
    a.add(text,"South");//设置外观
    text.addActionListener(new ActionListener() {//添加监听事件
        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println(text.getText().trim());
            area.append(text.getText()+"\n");
            text.setText("");
        }//设置文本域
    });
}
public void connect(){
    area.append("Try get server...\n");
    try {
        socket = new Socket("127.0.0.1",8998);//链接服务器
        writer = new PrintWriter(socket.getOutputStream(),true);
        area.append("Get server\n");
    }catch (IOException e) {
        e.printStackTrace();//抛出异常
    }
}
    public static void main(String[] args) {
Client c = new Client();
c.setSize(200,200);//设置尺寸
c.setVisible(true);//显示
c.connect();//开启
    }
}