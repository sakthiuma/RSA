/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author Sakthi
 */
import java.util.*;
import java.math.*;

public class RSA {

    public static int n,p,q,e,d,message,phi;
    public static double encryptText,decryptText;
    
    public static double encrypt(int text){
        double message = 0;
        double inter_val= Math.pow(text,e);
        System.out.println(inter_val);
        BigInteger inter_res;
        
        inter_res=BigDecimal.valueOf(inter_val).toBigInteger();
        BigInteger res=inter_res.mod(BigInteger.valueOf(n));
        message=res.intValue();
        System.out.println(message);
        
        return message;
    }
    
    public static double decrypt(double text)
    {
        double message;
        System.out.println("d"+d);
        BigDecimal text_temp=BigDecimal.valueOf(text);
        BigDecimal inter_val= text_temp.pow(d);
        System.out.println(inter_val);
        BigDecimal inter_res;
        
     
        BigDecimal res=inter_val.remainder(BigDecimal.valueOf(n));
        message=res.intValue();
        System.out.println(message);
        return message;
    }
    
    public static void keyGeneration()
    {
        BigInteger d_val,e_val;
        e_val=BigInteger.valueOf(e);
        phi=(p-1)*(q-1);
        d_val=e_val.modInverse(BigInteger.valueOf(phi));
        d=d_val.intValue();
        System.out.println(d);
        n=p*q;
        System.out.println(n);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the prime numbers \'p\' and \'q\'");
        p=s.nextInt();
        q=s.nextInt();
        
        System.out.println("Enter the value of \'e\'");
        e=s.nextInt();
        keyGeneration();
        System.out.println("Enter the message to be encrypted");
        message=s.nextInt();
        encryptText=encrypt(message);
       
        decryptText=decrypt(encryptText);
        
        
    }
}
