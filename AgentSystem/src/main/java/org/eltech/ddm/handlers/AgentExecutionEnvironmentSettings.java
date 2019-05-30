package org.eltech.ddm.handlers;

import jade.wrapper.AgentContainer;
import org.eltech.ddm.environment.DataDistribution;
import org.eltech.ddm.sup.ConfigReader;
import org.eltech.ddm.agents.AgentInfo;
import org.eltech.ddm.sup.Parser;

import java.io.Serializable;
import java.util.ArrayList;

public class AgentExecutionEnvironmentSettings implements Serializable, Cloneable {

    private final DataDistribution dataDistribution;
    private ArrayList<AgentInfo> agentInfoArrayList;
    private AgentContainer mainContainer = null;

    public void setMainContainer(AgentContainer mainContainer) {
        this.mainContainer = mainContainer;
    }

    public AgentContainer getMainContainer() {
        return mainContainer;
    }

    public AgentExecutionEnvironmentSettings(DataDistribution dataDistribution,String AGENTS_INFO_PATH) {
        this.dataDistribution = dataDistribution;
        agentInfoArrayList = ConfigReader.readFile(AGENTS_INFO_PATH);
    }

    public AgentExecutionEnvironmentSettings(DataDistribution dataDistribution, String[] arrayOfAgents){
        this.dataDistribution = dataDistribution;
        agentInfoArrayList = Parser.parseArray(arrayOfAgents);
    }

    public DataDistribution getDataDistribution() {
        return dataDistribution;
    }

    public ArrayList<AgentInfo> getAgentInfoArrayList() {
        return agentInfoArrayList;
    }



}
