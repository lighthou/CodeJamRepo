import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(runGame(3, 2, 3));


    }

    private static String runGame(int length, int complexity, int students) {
        HashSet<String> originals = new HashSet<>();
        String g = "G";
        String l = "L";
        String repeatedG = new String(new char[length]).replace("\0", g);
        String repeatedL = new String(new char[length]).replace("\0", l);
        // CREATE ORIGINAL SEQUENCES
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String newStr = repeatedG.substring(0,j) + "L" + repeatedG.substring(j + 1, length);
                originals.add(newStr);
            }
            String newRep = repeatedG.substring(0,i) + "L" + repeatedG.substring(i + 1, length);
            repeatedG = newRep;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String newStr = repeatedL.substring(0,j) + "G" + repeatedL.substring(j + 1, length);
                if (!originals.contains(newStr)) {
                    originals.add(newStr);
                }
            }
            String newRep = repeatedL.substring(0,i) + "G" + repeatedL.substring(i + 1, length);
            repeatedL = newRep;
        }
        //MULTIPLY SEQUENCES BY COMPLEXITY
        HashSet<String> finals = new HashSet<>();
        for (String s : originals){
            String str = s;
            for (int i = 0; i < complexity - 1; i++){
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : str.toCharArray()) {
                    if (c == 'L') {
                        stringBuilder.append(s);
                    } else {
                        stringBuilder.append(repeatedL); //RepeatedL is now G * N due to change of LLL to GGG
                    }
                }
                str = stringBuilder.toString();
            }
            finals.add(str);
        }



        return "Done";
    }
}
