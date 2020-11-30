package lz;
import java.util.Scanner;
import java.util.Vector;

public class LZ77 {
    public Vector<Vector<Integer>> LZ77Compression(String unCompressedStr){
        Vector<Vector<Integer>> tags = new Vector<Vector<Integer>>();
        String window = "";
        String temp = "";
        int index = 0;
        for (int counter = 0; counter < unCompressedStr.length(); counter++){
            temp += unCompressedStr.charAt(counter);
            //check if this word exist in window
            if(window.contains(temp)){
                index = window.indexOf(temp);
            }else{
                //this word not exist so i will start make new tag
                Vector<Integer> tag = new Vector<Integer>();
                if(temp.length() > 1){
                    tag.add(window.length() - index);
                }else{

                    tag.add(0);
                }
                tag.add(temp.length() - 1);
                tag.add((int)unCompressedStr.charAt(counter));
                window += temp;
                temp = "";
                index = 0;
                tags.add(tag);
            }
        }
        if(temp.length() > 0){
            Vector<Integer> tag = new Vector<Integer>();
            tag.add(temp.length() - 1);
            tag.add(temp.length() - 1);
            tag.add((int)temp.charAt(temp.length() - 1));
            tags.add(tag);
        }
        return tags;
    }


    public String LZ77DeCompression(Vector<Vector<Integer>> compressedStr){
        String data = "";
        for (int counter = 0; counter < compressedStr.size(); counter++){
            if(compressedStr.get(counter).get(0) != 0){
                data += data.substring(data.length() - compressedStr.get(counter).get(0), data.length() - compressedStr.get(counter).get(0) + compressedStr.get(counter).get(1));
            }
            data += Character.toString(compressedStr.get(counter).get(2));
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
