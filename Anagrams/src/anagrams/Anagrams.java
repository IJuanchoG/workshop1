/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagrams;

import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author 2152030
 */
public class Anagrams {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        args = new String[]{a,b};
        if(args.length<=1){
            isAnagram(false);
        } 
        else if(args.length == 2){
            isAnagram(compare(args));
        }
    }
    
    /**
     * verifica si es o no anagrama a partir del valor del comparado
     * @param is - Valor de estado del anagrama
     * 
     */
    private static void isAnagram(Boolean is){
        String result = is?"Anagrams":"Not Anagrams";
        System.out.println(result);
    }
    
    /**
     * 
     * @param args arreglo de Strings a verificar si son anagramas
     * @return Valor booleano que confirma o niega si los argumentos son anagramas o no 
     */
    private static Boolean compare(String[] args){
        Hashtable<Character,Integer> orderA = new Hashtable();
        args = new String[]{args[0].toLowerCase(),args[1].toLowerCase()};
        
        for (Character i: args[0].toCharArray()) {
            if(orderA.containsKey(i)) orderA.replace(i,orderA.get(i)+1);
            else orderA.put(i,1);
        }
        for (Character i: args[1].toCharArray()) {
            if(orderA.containsKey(i)) 
                if (orderA.get(i)>1)orderA.replace(i,orderA.get(i)-1);
                else orderA.remove(i);
            else return false;
        }
        return orderA.isEmpty();
    }
}



    /*private static Boolean compare(String[] args){
    char[] a = args[0].toLowerCase().toCharArray();
    char[] b = args[1].toLowerCase().toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a, b);
    }*/
    