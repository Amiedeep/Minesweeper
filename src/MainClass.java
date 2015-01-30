
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainClass extends JFrame implements ActionListener
{
    JPanel panel;
    JButton bt[][];
    JButton bt_flag;
    int x;
    int y;
    boolean flag[][];
    int[][] value;
//    Open t;
    boolean[][] open;
//    Thread t1;
    JLabel[][] lb;
    JButton bt_new;
    JLabel lb_flag;
//    OpenBox obj;
//    Thread openBox;
    boolean gameOver;
    Icon icn_flag;
    Icon icn_mine;
    Icon icn_minex;
//    public void paint(Graphics g)
//    {
//        try 
//        {
//                x=85;
//                y=100;
//                for (int j = 0; j < 15; j++) 
//                {
//                    g.drawLine(x,y,x+(15*20),y);
//                    y=y+20;
//                }
//                x=85;
//                y=100;
//                for (int j = 0; j < 15; j++) 
//                {
//                    g.drawLine(x,y,x,y+(15*20));
//                    x=x+20;
//                }
//        }
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//        }
//        
//    }
    MainClass()
    {
        
        this.setTitle("minesweeper implemented by Amandeep Singh(AmIe)");
        panel=new JPanel();
        panel.setLayout(null);
//        t=new Open();
        open=new boolean[15][15];
        flag=new boolean[15][15];
//        t1=new Thread(t);
//        t1.start();
        y=100;
        setLayout(null);
        gameOver=false;
        this.setSize(500,500);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(200, 100);
        bt=new JButton[15][15];
        bt_flag=new JButton("click");
        lb=new JLabel[15][15];
        bt_new=new JButton("Restart :-)");
        lb_flag=new JLabel("Attack");
        panel.setBounds(0, 0, 500, 500);
        bt_new.setBounds(150,40,170,50);
        bt_flag.setBounds(150,420,80,20);
        lb_flag.setBounds(240,420,80,20);
        bt_new.setForeground(Color.red);
        bt_new.setBackground(Color.black);
        bt_new.setFocusable(false);
        lb_flag.setForeground(Color.red);
        bt_flag.setForeground(Color.red);
        bt_flag.setBackground(Color.black);
        panel.add(bt_new);
        panel.add(lb_flag);
        panel.add(bt_flag);
        for (int i = 0; i <15; i++) 
        {
            x=85;
            for (int j = 0; j <15; j++) 
            {
                bt[i][j]=new JButton("");
                bt[i][j].setBounds(x,y,20,20);
                bt[i][j].setVisible(true);
                bt[i][j].setFocusable(false);
                bt[i][j].addActionListener(this);
                x=x+20;
                panel.add(bt[i][j]);
            }
            y=y+20;
        }
        y=100;
        for (int i = 0; i <15; i++) 
        {
            x=85;
            for (int j = 0; j <15; j++) 
            {
                lb[i][j]=new JLabel("");
                lb[i][j].setBounds(x,y,20,20);
                lb[i][j].setVisible(false);
                lb[i][j].setBackground(Color.WHITE);
                lb[i][j].setFocusable(false);
                panel.add(lb[i][j]);
                x=x+20;
            }
            y=y+20;
        }
        panel.setVisible(true);
        add(panel);
        this.setVisible(true);
        bt_flag.addActionListener(this);
        bt_new.addActionListener(this);
        Random r=new Random();
        value=r.value();
        for (int i = 0; i < 15; i++) 
        {
            for (int j = 0; j < 15; j++) 
            {
                System.out.print(value[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
//            obj=new OpenBox();
//            openBox=new Thread(obj);
//            openBox.start();
        }
        icn_flag=new ImageIcon("F:\\flag.jpg");
        icn_mine=new ImageIcon("F:\\mine.jpg");
        icn_minex=new ImageIcon("F:\\minex.jpg");
        
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bt_flag)
        {
            if(lb_flag.getText().equalsIgnoreCase("attack"))
            {
                lb_flag.setText("flag");
            }
            else
                lb_flag.setText("attack");
        }
        if(e.getSource()==bt_new)
        {
            new MainClass();
            this.dispose();
        }
        if(lb_flag.getText().equalsIgnoreCase("attack"))
        {
            for (int i = 0; i < 15; i++) 
            {
                for (int j = 0; j < 15; j++) 
                {
                    if(e.getSource()==bt[i][j] && flag[i][j]==false)
                    {
                        if(e.getSource()==bt[i][j] && value[i][j]!=9 && value[i][j]!=0)
                        {
                            open[i][j]=true;
                            setLabel(i,j);
                            status();
                        }
                        else if(e.getSource()==bt[i][j] && value[i][j]==9)
                        {
                            bt_new.setText("you lost :-(");
                            gameOver();
                            mineClicked();
                        }
                        if(e.getSource()==bt[i][j] && value[i][j]==0)
                        {
                            open[i][j]=true;
                            setLabel(i,j);
//                            open(i,j);
                            emptyBoxClicked(i,j);
                            status();
                        }
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < 15; i++) 
            {
                for (int j = 0; j < 15; j++) 
                {
                    if(e.getSource()==bt[i][j])
                    {
                        if(flag[i][j]==false)
                        {
                            flag[i][j]=true;
                            bt[i][j].setIcon(icn_flag);
                        }
                        else
                        {
                            flag[i][j]=false;
//                            bt[i][j].setBackground(Color.DARK_GRAY);
                            bt[i][j].setIcon(null);
                        }
                        
                    }
                }
            }
        }
            
            
    }
//    class Open implements Runnable
//    {
//        String s="";
//        public void run() 
//        {
//            while(true)
//            {
//                for (int i = 0; i < 15; i++) 
//                {
//                    for (int j = 0; j < 15; j++) 
//                    {
//                        if(bt[i][j].getLabel()!=null)
//                        {
//                            s=bt[i][j].getLabel();
//                        int n=Integer.parseInt(s);
//                        if(n==0)
//                        {
//                            open(i,j);
//                            i=i-2;
//                            j=j-2;
//                        }
//                        }
//                        
//                    }
//                }
//            }
//        }
//}
        void setLabel(int i,int j)
        {
                            if(value[i][j]==1)
                            {
                                lb[i][j].setForeground(Color.BLUE);
                            }
                            else if(value[i][j]==2)
                            {
                                lb[i][j].setForeground(Color.GREEN);
                            }
                            else if(value[i][j]==3)
                            {
                                lb[i][j].setForeground(Color.pink);
                            }
                            else
                            {
                                lb[i][j].setForeground(Color.RED);
                            }
                            bt[i][j].setVisible(false);
                            lb[i][j].setVisible(true);
                            lb[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                            if(value[i][j]!=0)
                            {
                                lb[i][j].setText(""+value[i][j]);
                            }
                            
        }
//        void open(int c,int d)
//        {
//            for (int k = c-1;k<=c+1; k++) 
//                        {
//                            if(k>=0 && k<=14)
//                            {
//                                for (int l = d-1; l <=d+1; l++) 
//                                {
//                                    if(l>=0 && l<=14)
//                                    {
//                                        if(open[k][l]==0)
//                                        {
//                                            bt[k][l].setVisible(false);
//                                            lb[k][l].setVisible(true);
//                                            open=t.show(k,l);
//                                            setLabel(k,l);
//                                            status();
//                                            if(flag==false)
//                                            {
//                                                bt_new.setText("you win :-)");
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//        }
        void status()
        {
            outer: for (int k= 0; k < 15; k++) 
            {
                for (int l= 0; l < 15;l++) 
                {
                    if(open[k][l]==false && value[k][l]!=9)
                    {
                        gameOver=true;
                        break outer;
                    }
                    else
                        gameOver=false;
                }
            }
            if(gameOver==false)
                {
                    bt_new.setText("you win :-)");
                    gameOver();
                }
        }
        void gameOver()
        {
              
              for (int k= 0; k < 15; k++) 
                    {
                        for (int l= 0; l < 15;l++) 
                        {
                            bt[k][l].setEnabled(false);
                        }
                    }
        }
    
//    class OpenBox implements Runnable
//    {
//        public void run() 
//        {
//            while(true)
//            {
//                for (int i = 0; i <15; i++) 
//                {
//                    for (int j = 0; j <15; j++) 
//                    {
//                        if(value[i][j]==0 && open[i][j]==1)
//                        {
//                            open(i,j);
//                        }
//                    }
//                }
//            }
//        }
//    }
    void mineClicked()
    {
                            for (int k= 0; k < 15; k++) 
                            {
                                for (int l= 0; l < 15;l++) 
                                {
                                    if(flag[k][l]==true && value[k][l]!=9)
                                    {
                                        bt[k][l].setVisible(false);
                                        lb[k][l].setVisible(true);
                                        lb[k][l].setIcon(icn_minex);
                                    }
                                    if(value[k][l]==9)
                                    {
                                        bt[k][l].setVisible(false);
                                        lb[k][l].setVisible(true);
                                        lb[k][l].setIcon(icn_mine);
                                    }
                                }
                            }
    }
    void emptyBoxClicked(int k,int l)
    {
        if(k-1>=0)
        {
            if(l-1>=0 && open[k-1][l-1]==false)
            {
                open[k-1][l-1]=true;
                setLabel(k-1,l-1);
                status();
                if(value[k-1][l-1]==0)
                {
                    emptyBoxClicked(k-1,l-1);
                }
            }
            if(open[k-1][l]==false)
            {
                open[k-1][l]=true;
                setLabel(k-1,l);
                status();
                if(value[k-1][l]==0)
                {
                    emptyBoxClicked(k-1,l);
                }
            }
            if(l+1<15 && open[k-1][l+1]==false)
            {
                open[k-1][l+1]=true;
                setLabel(k-1,l+1);
                status();
                if(value[k-1][l+1]==0)
                {
                    emptyBoxClicked(k-1,l+1);
                }
            }
        }
            if(l-1>=0 && open[k][l-1]==false)
            {
                open[k][l-1]=true;
                setLabel(k,l-1);
                status();
                if(value[k][l-1]==0)
                {
                    emptyBoxClicked(k,l-1);
                }
            }
            if(l+1<15 && open[k][l+1]==false)
            {
                open[k][l+1]=true;
                setLabel(k,l+1);
                status();
                if(value[k][l+1]==0)
                {
                    emptyBoxClicked(k,l+1);
                }
            }
        if(k+1<15)
        {
            if(l-1>=0 && open[k+1][l-1]==false)
            {
                open[k+1][l-1]=true;
                setLabel(k+1,l-1);
                status();
                if(value[k+1][l-1]==0)
                {
                    emptyBoxClicked(k+1,l-1);
                }
            }
            if(open[k+1][l]==false)
            {
                open[k+1][l]=true;
                setLabel(k+1,l);
                status();
                if(value[k+1][l]==0)
                {
                    emptyBoxClicked(k+1,l);
                }
            }
            if(l+1<15 && open[k+1][l+1]==false)
            {
                open[k+1][l+1]=true;
                setLabel(k+1,l+1);
                status();
                if(value[k+1][l+1]==0)
                {
                    emptyBoxClicked(k+1,l+1);
                }
            }
        }
            
    }
}
