package com.realestate.agentmanagement;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    private final AgentBST agentBST;

    public AgentService() {
        this.agentBST = new AgentBST();
    }

    public void addAgent(Agent agent) {
        agentBST.insert(agent);
    }

    public Agent getAgent(int id) {
        return agentBST.search(id);
    }

    public List<Agent> getAllAgents() {
        return agentBST.getAllAgents();
    }

    public List<Agent> getSortedAgentsByRating() {
        return agentBST.sortByRating();
    }

    public boolean updateAgent(Agent agent) {
        return agentBST.update(agent);
    }

    public void deleteAgent(int id) {
        agentBST.delete(id);
    }
}