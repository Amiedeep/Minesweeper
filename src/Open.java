
import java.awt.*;



public class Open 
{
    int[][] v;
//    Open(Button b[][],int x,int y,int[][]z)
//    {
//        
//        let(b,x,y,z);
//    }
//     void let(Button o[][],int c,int d,int[][]m)
//        {
//            for (int k = c-1;k<=c+1; k++) 
//                        {
//                            if(k>=0 && k<=14)
//                            {
//                                for (int l = d-1; l <=d+1; l++) 
//                                {
//                                    if(l>=0 && l<=14)
//                                    {
//                                        if(m[k][l]==0 && (k!=c || l!=d))
//                                        {
//                                            o[k][l].setLabel(""+0);
////                                            let(o,k,l,m);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//        }
    Open()
    {
        v=new int[15][15];
    }
    int[][] show(int c,int d)
    {
        v[c][d]=1;
        return v;
    }
    int[][] display(int c,int d,int[][] z,Button bt[][],Label lb[][])
    {
//        for (int k = c-1;k<=c+1; k++) 
//                        {
//                            if(k>=0 && k<=14)
//                            {
//                                for (int l = d-1; l <=d+1; l++) 
//                                {
//                                    if(l>=0 && l<=14)
//                                    {
//                                        if(v[k][l]==0)
//                                        {
//                                        }
//                                    }
//                                }
//                            }
//                        }
//        while(true)
//        {
//            for (int i = c-1; i <=c+1; i++) 
//            {
//                for (int j = d-1; j <=d+1; j++) 
//                {
//                    if(v[c][d]==0 && z[c][d]==0)
//                    {
//                        
//                    }
//                }
//            }
//            break;
//        }
        while(true)
        {
            for (int i = c; i <=14; i++) 
            {
                if(i>=0)
                {
                    for (int j = d; j <=14; j++) 
                        {
                            if(j>0)
                            {
                                if(v[i][j]==0 && z[i][j]==0)
                                {
                                  bt[i][j].setVisible(false);
                                  lb[i][j].setVisible(true);
                                  v[i][j]=1;
                                  i=i-1;
                                  j=j-1;
                                }
                            }
                        }
                }
                
            }
            break;
        }
        return v;
    }
}
