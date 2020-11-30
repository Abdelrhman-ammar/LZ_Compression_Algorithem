package lz;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class LZ78 {
    public Vector<Vector<Integer>> LZ78Compression(String unCompressedStr){
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        Vector<Vector<Integer>> tags = new Vector<Vector<Integer>>();
        String temp = "";
        int index = 1;
        int size = unCompressedStr.length();
        for (int counter = 0; counter < size; counter++ ) {
            temp += unCompressedStr.charAt(counter);
            if(!dictionary.containsKey(temp)){
                Vector<Integer> tag = new Vector<Integer>();
                dictionary.put(temp, index++);
                if(temp.length() == 1){
                    tag.add(0);
                    tag.add((int)temp.charAt(0));
                }else{
                    char nextChar = temp.charAt(temp.length() - 1);
                    temp = temp.substring(0, temp.length() - 1);
                    tag.add(dictionary.get(temp));
                    tag.add((int)nextChar);
                }
                tags.add(tag);
                temp = "";
            }
        }
        if(temp.length() > 0){
            Vector<Integer> tag = new Vector<Integer>();
            dictionary.put(temp, index++);
            if (temp.length() == 1) {
                tag.add(0);
                tag.add((int) temp.charAt(0));
            } else {
                char nextChar = temp.charAt(temp.length() - 1);
                temp = temp.substring(0, temp.length() - 1);
                tag.add(dictionary.get(temp));
                tag.add((int) nextChar);
                System.out.println(tag.get(0));
            }
            tags.add(tag);
        }
        return tags;
    }


    public String LZ78DeCompression(Vector<Vector<Integer>> compressedStr){
        String data = "";
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        int index = 1;
        String word = "";
        for(int counter = 0; counter < compressedStr.size(); counter++){
            if(compressedStr.get(counter).get(0) == 0){
                word = Character.toString(compressedStr.get(counter).get(1));

            }else{
                word = dictionary.get(compressedStr.get(counter).get(0)) + Character.toString(compressedStr.get(counter).get(1));
            }
            data += word;
            dictionary.put(index++, word);
        }
        return data;
    }

    public Vector<Vector<Integer>> makeTage(int numOfTags){
        Vector<Vector<Integer>> tags = new Vector<Vector<Integer>>();
        Vector<Integer> tag = new Vector<Integer>();
        Scanner input = new Scanner(System.in);
        int num;
        String nextChar;
        char c;
        for(int counter = 0; counter < numOfTags; counter++){
            System.out.println("Enter Tag Number " + (counter + 1));
            num = input.nextInt();
            tag.add(num);
            nextChar = input.nextLine();
            c =  nextChar.charAt(1);
            tag.add((int)c);
            tags.add(tag);
        }
        return tags;
    }
}
