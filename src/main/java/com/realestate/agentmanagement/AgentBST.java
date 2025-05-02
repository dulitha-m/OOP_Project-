package com.realestate.agentmanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgentBST {
    private AgentNode root;
    private static final String FILE_PATH = "src/main/resources/agents.txt";

    public AgentBST() {
        this.root = null;
        loadFromFile();
    }

    // Insert an agent into the BST
    public void insert(Agent agent) {
        root = insertRec(root, agent);
        saveToFile();
    }

    private AgentNode insertRec(AgentNode root, Agent agent) {
        if (root == null) {
            return new AgentNode(agent);
        }
        if (agent.getId() < root.getAgent().getId()) {
            root.setLeft(insertRec(root.getLeft(), agent));
        } else if (agent.getId() > root.getAgent().getId()) {
            root.setRight(insertRec(root.getRight(), agent));
        }
        return root;
    }

    // Search for an agent by ID
    public Agent search(int id) {
        AgentNode node = searchRec(root, id);
        return node != null ? node.getAgent() : null;
    }

    private AgentNode searchRec(AgentNode root, int id) {
        if (root == null || root.getAgent().getId() == id) {
            return root;
        }
        if (id < root.getAgent().getId()) {
            return searchRec(root.getLeft(), id);
        }
        return searchRec(root.getRight(), id);
    }

    // Update an agent
    public boolean update(Agent updatedAgent) {
        AgentNode node = searchRec(root, updatedAgent.getId());
        if (node != null) {
            node.setAgent(updatedAgent);
            saveToFile();
            return true;
        }
        return false;
    }

    // Delete an agent
    public void delete(int id) {
        root = deleteRec(root, id);
        saveToFile();
    }

    private AgentNode deleteRec(AgentNode root, int id) {
        if (root == null) {
            return root;
        }
        if (id < root.getAgent().getId()) {
            root.setLeft(deleteRec(root.getLeft(), id));
        } else if (id > root.getAgent().getId()) {
            root.setRight(deleteRec(root.getRight(), id));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setAgent(minValue(root.getRight()).getAgent());
            root.setRight(deleteRec(root.getRight(), root.getAgent().getId()));
        }
        return root;
    }

    private AgentNode minValue(AgentNode root) {
        AgentNode current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    // Get all agents (in-order traversal)
    public List<Agent> getAllAgents() {
        List<Agent> agents = new ArrayList<>();
        inOrderRec(root, agents);
        return agents;
    }

    private void inOrderRec(AgentNode root, List<Agent> agents) {
        if (root != null) {
            inOrderRec(root.getLeft(), agents);
            agents.add(root.getAgent());
            inOrderRec(root.getRight(), agents);
        }
    }

    // Selection Sort by rating
    public List<Agent> sortByRating() {
        List<Agent> agents = getAllAgents();
        for (int i = 0; i < agents.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < agents.size(); j++) {
                if (agents.get(j).getRating() < agents.get(minIdx).getRating()) {
                    minIdx = j;
                }
            }
            Agent temp = agents.get(minIdx);
            agents.set(minIdx, agents.get(i));
            agents.set(i, temp);
        }
        return agents;
    }

    // Save agents to file
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(getAllAgents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load agents from file
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                List<Agent> agents = (List<Agent>) ois.readObject();
                for (Agent agent : agents) {
                    insert(agent);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}