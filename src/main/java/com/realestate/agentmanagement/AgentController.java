package com.realestate.agentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agents")
public class AgentController {
    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    // Show registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("agent", new Agent(0, "", "", 0.0, ""));
        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String registerAgent(@ModelAttribute Agent agent) {
        agentService.addAgent(agent);
        return "redirect:/agents/list";
    }

    // Show agent list
    @GetMapping("/list")
    public String listAgents(Model model) {
        model.addAttribute("agents", agentService.getSortedAgentsByRating());
        return "list";
    }

    // View single agent
    @GetMapping("/view/{id}")
    public String viewAgent(@PathVariable int id, Model model) {
        Agent agent = agentService.getAgent(id);
        if (agent != null) {
            model.addAttribute("agent", agent);
            return "view";
        }
        return "redirect:/agents/list";
    }
}