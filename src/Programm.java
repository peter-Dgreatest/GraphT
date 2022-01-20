  import java.io.*;
import java.util.*;


    public class Programm {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter wr = new PrintWriter(System.out);
            int T = Integer.parseInt(br.readLine().trim());
            for (int t_i = 0; t_i < T; t_i++) {
                String[] strNums = br.readLine().split(" ");
                int initCharge = Integer.parseInt(strNums[0]);
                int finalCharge = Integer.parseInt(strNums[1]);

                int out_ = chargingSmartPhone(initCharge, finalCharge);
                System.out.println(out_);
            }

            wr.close();
            br.close();
        }

        static int chargingSmartPhone(int initCharge, int finalCharge) {
            // Write your code here
            int fCharge = initCharge;
            int time = 0;
            int c2add = 0;
            int hgCharge = 0;
            while (fCharge < finalCharge) {
                if (fCharge < 11) {
                    c2add = 10;
                    hgCharge = 10;
                } else if (fCharge > 10 && fCharge < 231) {
                    c2add = 5;
                    hgCharge = 231;
                } else if (fCharge > 230 && fCharge < 560) {
                    c2add = 8;
                    hgCharge = 559;
                } else if (fCharge >= 560 && fCharge <= 1009) {
                    c2add = 2;
                    hgCharge = 1009;
                } else if (fCharge >= 1010 && fCharge <= 5000) {
                    c2add = 7;
                    hgCharge = 5000;
                } else if (fCharge >= 5001 && fCharge <= 10000) {
                    c2add = 8;
                    hgCharge = 10000;
                } else if (fCharge >= 10001 && fCharge <= Math.pow(10, 9)) {
                    c2add = 3;
                    hgCharge = (int) Math.pow(10, 9);
                }
                int s = ((Math.min(hgCharge,finalCharge) - fCharge) / c2add)+1;

                time+=s;
                System.out.println(time);

                if(time>0)
                    fCharge += (c2add * time);
                else {
                    fCharge+=c2add;
                    time++;
                }
                System.out.println(fCharge);
             //   System.out.println(finalCharge+" ;;;");
                // time++;
            }
            System.out.println(time);
            return time;
        }
    }
