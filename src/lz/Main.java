package lz;
import java.util.Vector;

public class Main {

    enum Level {
        LOW,
        MEDIUM,
        HIGH;

        public String toString(){
            if(this == HIGH)
                System.out.println("hello");
            return "this";
        }
    }

    public static void main(String[] args) {

        Level l = Level.LOW;
        l.toString();
        /*
        System.out.println("LZ77 Compression:");
        String str = "ABAABABAABBBBBBBBBBBBA";
        //str = "AhAAAmEdddd";
        System.out.println("Compression Tags:");
        LZ77 obj77 = new LZ77();
        Vector<Vector<Integer>> vec = obj77.LZ77Compression(str);
        for (int i = 0; i < vec.size(); i++) {
            System.out.println("< " + vec.get(i).get(0) + ", " + vec.get(i).get(1) + ", " + Character.toString(vec.get(i).get(2)) + " >");
        }
        System.out.println("String before compress: " + str);
        //vec = obj77.makeTage(1);
        System.out.println("String after de compress: " + obj77.LZ77DeCompression(vec));

        /***************************************************************/
/*
        LZ78 obj78 = new LZ78();
        System.out.println("\n\nLZ78 Compression:");
        String str2 = "ABAABABAABABBBBBBBBBBA";
        //str2 = "AhAAAmEdddd";
        System.out.println("Compression Tags:");
        Vector<Vector<Integer>> vec2 = obj78.LZ78Compression(str2);
        for (int i = 0; i < vec2.size(); i++)
            System.out.println("< " + vec2.get(i).get(0) + ", " + Character.toString(vec2.get(i).get(1)) + " >");
        System.out.println("String before compress: " + str2);
        //vec2 = obj78.makeTage(1);
        System.out.println("String after de compress: " + obj78.LZ78DeCompression(vec2));
*/
    }
}
