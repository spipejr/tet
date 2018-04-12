/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borfunction;

/**
 *
 * @author s386
 */
public class BORUtilities {
    public static double getAGV(double Money,double n)
    {
        double sum = 0;
        if(n!=0)
        {
           sum = Money/n;
        }
        
        
        return sum;
    }
    
    public static double getSum(double[] sum )
    {
            double ans = 0;
            for(int i=0; i<sum.length; i++)
            {
                ans += sum[i];
            }
            return ans;
    }
}
