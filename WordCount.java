/**
 * L.03 Word Counter
 * Anton John B. Pasigado
 * 06/27/2016
 * References: 
 */

import java.util.*;

public class WordCount {
    public static void main (String[]args){
        Scanner input = new Scanner (System.in);
        
        System.out.print ("Enter the phrase: ");
        String[] PhraseSplit = input.nextLine().toLowerCase().split(" ");
    
        String[] Sorted = getSorted(PhraseSplit);
        String[] List = getList(Sorted);
        int[] WordCount = getCount(List, Sorted);
        
        for (int i=0; i<List.length; i++){
            System.out.println (List[i] + " : " + WordCount[i]);
        }
    }
    
    public static String[] getSorted(String[] a){
        String[] word = a;
        for (int i=1; i<word.length; i++){
            int j=i;
            while (j>0 && word[j].compareTo(word[j-1])<0){
                String temp = word[j];
                word [j] = word[j-1];
                word [j-1] = temp;
                j--;
            }
        }
        return word;
    }
    
    public static String[] getList(String[] a){
        String[] words = a;
        String[] temp = new String[words.length];
        int ListCounter = 0;
        for (int i=0; i<words.length; i++){
            temp[ListCounter] = words[i];
            while (i<words.length-1 && words[i].equals(words[i+1])){
                i++;
            }
            ListCounter++;
        }        
        String[] List = new String[ListCounter];
        for (int i=0; i<ListCounter; i++){
            List[i] = temp[i];
        }
        return List;
    }
    
    public static int[] getCount(String[] a, String[] b){
        String[] list = a;
        String[] words = b;
        int[] count = new int[list.length];
        
        for (int i=0; i<list.length; i++){
            int temp=0;
            for (int j=0; j<words.length;j++){
                if (list[i].equals(words[j])){
                    temp++;
                }
                count[i]=temp;
            }
        }
        return count;
    }
}
