/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author PcKu-Asus
 */
public class RSA {
    BigInteger p,q,n,totient,e,d; 
    static String cipherteks;
    public static BigInteger GeneratePrime(int panjangbitprime){
        int N = panjangbitprime;
        SecureRandom random = new SecureRandom();
        BigInteger prime = BigInteger.probablePrime(N,random);
        return prime;
    }
    public static BigInteger hitungtotient(BigInteger p, BigInteger q){
        BigInteger t;
        BigInteger p1 = new BigInteger("1");
        p = p.subtract(p1);
        q = q.subtract(p1);
        t = p.multiply(q);
        return t;
    }
    public static BigInteger hitungN(BigInteger p, BigInteger q){
        BigInteger n;
        n= p.multiply(q);
        
        return n;
    }
    public static BigInteger gcd(BigInteger e,BigInteger totient){
        BigInteger r,temp;
        BigInteger nol = new BigInteger("0");
        int compare = e.compareTo(totient);
                
        if(compare == -1){
            temp = e;
            e=totient;
            totient = temp;
        }
        while(totient.compareTo(nol)!= 0){
            r = e.mod(totient);
            e = totient;
            totient = r;
        }
        return e;
    }
    public static BigInteger hitung_pvt(BigInteger e,BigInteger totient){
        BigInteger k,h,d;
        BigInteger satu = new BigInteger("1");
        k = new BigInteger("1");
        while(true){
            d = k.multiply(e);
            h = d.mod(totient);
           
            if(h.compareTo(satu) == 0){
                return k;
            }
            else{
                k = k.add(satu);
                
            }
        }
    }
    public static BigInteger[] enkripsi(String messagedigest,int panjangbitprime){
        String md = messagedigest;
        BigInteger test;
        BigInteger satu = new BigInteger("1");
        BigInteger p = GeneratePrime(panjangbitprime);
       BigInteger q = GeneratePrime(panjangbitprime);
        System.out.println("P ="+p+" Q= "+q);
        BigInteger n = hitungN(p,q);
        System.out.println("N = "+n);
        BigInteger totient = hitungtotient(p,q);
        System.out.println("totient = "+totient);
        BigInteger e;
        do{
            e = GeneratePrime(panjangbitprime);
            test = gcd(e,totient);
        }while(test.compareTo(satu) != 0);
        
        BigInteger d = hitung_pvt(e,totient);
        BigInteger h = new BigInteger(md);
        BigInteger S = h.modPow(d, n);
       
        return new BigInteger[] {e,S,n};
    }
    public static BigInteger dekripsi (BigInteger signature,BigInteger e,BigInteger n){
        BigInteger haksen = signature.modPow(e, n);
        return haksen;
    }
    
}
