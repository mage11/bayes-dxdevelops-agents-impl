package org.eltech.ddm.sup;

import org.eltech.ddm.agents.AgentInfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/* AgentInfo info:
   <name>,<host>,<TcpPort>,<HttpPort>,<className>,<filePath> */

public class ConfigReader {
    public static  ArrayList<AgentInfo> readFile(String filePath){
        String line;
        String[] lines;
        String splitBySymbol = ",";

        ArrayList<AgentInfo> agentInfoArrayList = new ArrayList<>();

        try( BufferedReader bk = new BufferedReader(new FileReader(filePath)) )  {

            while ((line = bk.readLine()) != null) {
                lines = line.split(splitBySymbol);

                AgentInfo agentInfo = new AgentInfo();

                agentInfo.setName(lines[0]);
                agentInfo.setIp(lines[1]);
                agentInfo.setHost(lines[2]);
                agentInfo.setTcpPort(lines[3]);
                agentInfo.setHttpPort(lines[4]);
                agentInfo.setClassName(lines[5]);
                agentInfo.setFilePath(lines[6]);

                agentInfoArrayList.add(agentInfo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return agentInfoArrayList;
    }
}
