package org.eltech.ddm.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import org.eltech.ddm.common.ExecuteJob;
import org.eltech.ddm.common.ExecuteResult;
import org.eltech.ddm.handlers.AgentMiningExecutor;

import java.io.IOException;

public class AgentModerator extends Agent {

    private Object[] args;
    private AgentInfo agent;
    private ExecuteJob executeJob;
    private AgentMiningExecutor thisExecutor;

    public void setup() {

        args = getArguments();

        agent = (AgentInfo) args[0];
        thisExecutor = (AgentMiningExecutor) args[1];
        executeJob = (ExecuteJob) args[2];

        addBehaviour(new SendingMsg());

    }

    class SendingMsg extends OneShotBehaviour{

        //TODO: logger, ArchiveREinitiator

        public void action() {

            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            AID receiverAID = new AID(agent.getName() +"@"+ agent.getIp() + ":" + agent.getTcpPort() + "/JADE");
            receiverAID.addAddresses("http://" + agent.getHost() + ":" + agent.getHttpPort() +  "/acc");
            msg.addReceiver(receiverAID);
            msg.setContent(agent.getFilePath());
            try {
                msg.setContentObject(executeJob);
            } catch (IOException e) {
                e.printStackTrace();
            }
            send(msg);

            System.out.println("Sent a message to " + agent.getName() +"@"+ agent.getIp() + ":" +
                    agent.getTcpPort() + "/JADE");
            addBehaviour(new ReceiveMsg());

        }
    }

    class ReceiveMsg extends SimpleBehaviour {

        private boolean finish = false;
        private ExecuteResult result;

        public void action() {

            ACLMessage msg = myAgent.receive();

            if (msg != null) {

                //TODO: instaceof ExecuteResult...
                System.out.println(msg.toString());

                try{
                    result = (ExecuteResult) msg.getContentObject();
                    System.out.println("Received a message from " + msg.getSender().getLocalName());

                } catch (UnreadableException e){ e.printStackTrace();}


                thisExecutor.setResult(result);

                finish = true;
            }
            else {
                block();
            }
        }

        public boolean done() {
            return finish;
        }


    }

}
