
public class Random 
{
    int mine;
    int count;
    int[][] v;
    Random()
    {
        v=new int[15][15];
        mine=((15*15)/10)+1;
//        mine=40;
        while(count<mine)
        {
            int x=(int)(0+(15-0)*Math.random());
            int y=(int)(0+(15-0)*Math.random());
            if(v[x][y]==9)
            {
                continue;
            }
            else
            {
                v[x][y]=9;
                count=count+1;
            }
        }
        for (int i = 0; i < 15; i++) 
        {
            for (int j = 0; j < 15; j++) 
            {
                if(v[i][j]==9)
                    {
                        continue;
                    }
                else
                    {
                        int b=0;
                        for (int k = i-1;k<=i+1; k++) 
                        {
                            if(k>=0 && k<=14)
                            {
                                for (int l = j-1; l <=j+1; l++) 
                                {
                                    if(l>=0 && l<=14)
                                    {
                                        if(v[k][l]==9)
                                        {
                                            b=b+1;
                                        }
                                    }
                                }
                            }
                        }
                        v[i][j]=b;
                    }
            }
        }
    }
    int[][] value()
    {
        return v;
    }
}
