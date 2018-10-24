
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author florenthaxha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] ips = {"128.199.144.199", "167.99.51.33", "46.101.253.149"};
        
        for (int i = 0; i < ips.length; i++) {
            String ip = ips[i];
            StringBuilder output = new StringBuilder();
            String interestingline = "";
            Process exec = Runtime.getRuntime().exec("ping -c 100 " + ip);

            exec.waitFor();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + " \n ");
                }
                String[] lines = output.toString().split("\n");
                interestingline = lines[lines.length - 2];
            }
            System.out.println("Time from this server: " + ip +interestingline);
        }
        
    }

}
