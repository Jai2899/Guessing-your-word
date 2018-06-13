import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Welcome extends Frame
{
	static Welcome frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Welcome()
	{
		Label la=new Label("I will guess your word"); 
		la.setFont(new Font("Tahoma", Font.PLAIN, 48));
		la.setForeground(Color.RED); 
        la.setBounds(450,300,450,55);
        Label lb=new Label("(Note:Maximum Size of word is 14)"); 
        lb.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lb.setForeground(Color.BLUE); 
        lb.setBounds(400,360,600,40);
        Button b1=new Button("NEXT");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		b1.setBackground(Color.CYAN);
        b1.setBounds(1150,650,150,60);
       	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Size.main(new String[]{});
		frame.dispose();
		}
		});
        add(la);
        add(lb);
        add(b1);
        setLayout(null);
        setSize(1370,730);
        setBackground(Color.ORANGE);
        addWindowListener(new WindowAdapter()
        {
        	public void windowClosing(WindowEvent ae)
        	{
        		System.exit(0);

        	}
        });
    }
}