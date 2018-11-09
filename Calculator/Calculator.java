import java.io.*;
class Calculator
{
    public static void main ()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println ("1 2 3 +");
        System.out.println ("4 5 6 -");
        System.out.println ("7 8 9 *");
        System.out.println (". 0 / Ent");
        System.out.println (" ");
        System.out.println ("Enter the problem below");
        String n = br.readLine()+" ";
        int l = n.length();char c;int k=0;
        String ar[] = new String [l];int o=0;
        for (int i=0;i<l;i++)
        {
            c = n.charAt(i);
            if (c=='+'||c=='-')
            ar[k++]=Character.toString(c);
            if (c=='*'||c=='/')
            o=1;
        }
        int j=k+1;String s="";int co=0;
        String a[]=new String [j];
        for (int i=0;i<l;i++)
        {
            c = n.charAt(i);
            if (c=='+'||c=='-'||i==(l-1))
            {
                a[co++]=s;
                s="";
            }
            else
            s = s+c;
        }
        double arr[]=new double[j];
        if (o==1)
        {
            double P;
            for (int i=0;i<j;i++)
            {
                P = isCalculate(a[i]);
                arr[i]=P;
            }
        }
        else
        {
            for (int i=0;i<j;i++)
            arr[i]=Double.parseDouble(a[i]);
        }
        double s1=arr[0];
        for (int i=1;i<j;i++)
        {
            if (ar[i-1].equals("+"))
            s1=s1+arr[i];
            if (ar[i-1].equals("-"))
            s1=s1-arr[i];
        }
        System.out.println ("Ans. "+s1);
    }
    static double isCalculate(String n)
    {
        n = n+" ";
        int l=n.length();int j=0,k=0;
        String ar[]=new String[l];String s="";
        double a[]=new double[l];char c;
        for (int i=0;i<l;i++)
        {
            c = n.charAt(i);
            if (c=='*'||c=='/'||i==(l-1))
            {
                a[j++]=Double.parseDouble(s);
                s="";
                ar[k++]=Character.toString(c);
            }
            else
            s=s+c;
        }
        double f=a[0];
        for (int i=1;i<j;i++)
        {
            if (ar[i-1].equals("*"))
            f = f*a[i];
            if (ar[i-1].equals("/"))
            f = f/a[i];
        }
        return f;
    }
}