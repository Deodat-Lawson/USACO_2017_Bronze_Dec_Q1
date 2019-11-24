import java.util.*;
import java.io.*;
public class USACO_2017_Bronze_Dec_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));


         int billboard1XPosS,billboard1YPosS,billboard1XPosE,billboard1YPosE,billboard2XPosS,billboard2YPosS,billboard2XPosE,billboard2YPosE,billboard3XPosS,billboard3YPosS,billboard3XPosE,billboard3YPosE;
        String bill1 = br.readLine();
        StringTokenizer tok = new StringTokenizer(bill1);
        billboard1XPosS = Integer.parseInt(tok.nextToken());
        billboard1YPosS = Integer.parseInt(tok.nextToken());
        billboard1XPosE = Integer.parseInt(tok.nextToken());
        billboard1YPosE = Integer.parseInt(tok.nextToken());

        String bill2 = br.readLine();
        StringTokenizer tok2 = new StringTokenizer(bill2);
        billboard2XPosS = Integer.parseInt(tok2.nextToken());
        billboard2YPosS = Integer.parseInt(tok2.nextToken());
        billboard2XPosE = Integer.parseInt(tok2.nextToken());
        billboard2YPosE = Integer.parseInt(tok2.nextToken());

        String bill3 = br.readLine();
        StringTokenizer tok3 = new StringTokenizer(bill3);
        billboard3XPosS = Integer.parseInt(tok3.nextToken());
        billboard3YPosS = Integer.parseInt(tok3.nextToken());
        billboard3XPosE = Integer.parseInt(tok3.nextToken());
        billboard3YPosE = Integer.parseInt(tok3.nextToken());

        br.close();

        int MaxNumX = Math.max(billboard1XPosE, Math.max(billboard2XPosE, billboard3XPosE));
        int MinNumX = Math.min(billboard1XPosS, Math.min(billboard2XPosS, billboard3XPosS));
        int MaxNumY = Math.max(billboard1YPosE, Math.max(billboard2YPosE, billboard3YPosE));
        int MinNumY = Math.min(billboard1YPosS, Math.min(billboard2YPosS, billboard3YPosS));

        boolean[][] area = new boolean[Math.abs(MaxNumX-MinNumX)][Math.abs(MaxNumY-MinNumY)];

        for (int i = billboard1XPosS-MinNumX; i < billboard1XPosE-MinNumX; i++) {
            for (int j = billboard1YPosS-MinNumY; j < billboard1YPosE-MinNumY;j++) {
                area[i][j] = true;
            }
        }

        for (int i = billboard2XPosS-MinNumX; i < billboard2XPosE-MinNumX; i++) {
            for (int j = billboard2YPosS-MinNumY; j < billboard2YPosE-MinNumY;j++) {
                area[i][j] = true;
            }
        }

        for (int i = billboard3XPosS-MinNumX; i < billboard3XPosE-MinNumX; i++) {
            for (int j = billboard3YPosS-MinNumY; j < billboard3YPosE-MinNumY;j++) {
                area[i][j] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length;j++) {
                if(area[i][j]) count++;
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        out.println(count);
        out.close();
    }



}
