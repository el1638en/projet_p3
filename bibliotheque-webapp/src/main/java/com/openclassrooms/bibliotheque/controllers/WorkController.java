package com.openclassrooms.bibliotheque.controllers;

import com.openclassrooms.bibliotheque.models.SearchWork;
import com.openclassrooms.bibliotheque.service.WorkService;
import com.openclassrooms.bibliotheque.ws.WorkWs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class WorkController {

    private static Logger logger = LoggerFactory.getLogger(WorkController.class);

    @Autowired
    private WorkService workService;

    @GetMapping("/searchWork")
    public String searchWorkForm(Model model) {
        model.addAttribute("searchWork", new SearchWork());
        model.addAttribute("findResult", false);
        // retourne la jsp
        return "search";
    }


    @PostMapping(path = "/searchByAuthor")
    public String searchByAuthor(Model model, @ModelAttribute("searchWork") SearchWork searchWork) {
        List<WorkWs> listWorks = workService.findWorks(searchWork.getAuthor());
        model.addAttribute("findResult", true);
        model.addAttribute("listWorks" ,listWorks);
        return "search";
    }

    @GetMapping("/searchWorkByDate")
    public String searchWorkFormDate(Model model) {
        model.addAttribute("searchWorkByDate", new SearchWork());
        model.addAttribute("findResult", false);
        // retourne la jsp
        return "searchByPublicationDate";
    }

    @PostMapping(path = "/searchByPublicationDate")
    public String searchByPublicationDate(Model model, @ModelAttribute("searchWorkByDate") SearchWork searchWork) {
        List<WorkWs> listWorks = workService.findWorksByPublicationDate(searchWork.getPublicationDate());
        model.addAttribute("findResult", true);
        model.addAttribute("listWorks" ,listWorks);
        return "searchByPublicationDate";
    }

    @GetMapping("/searchWorkByTitle")
    public String searchWorkFormTitle(Model model) {
        model.addAttribute("searchWorkByTitle", new SearchWork());
        model.addAttribute("findResult", false);
        // retourne la jsp
        return "searchByTitle";
    }

    @PostMapping(path = "/searchByTitle")
    public String searchByTitle(Model model, @ModelAttribute("searchWorkByTitle") SearchWork searchWork) {
        List<WorkWs> listWorks = workService.findWorksByTitle(searchWork.getTitle());
        model.addAttribute("findResult", true);
        model.addAttribute("listWorks" ,listWorks);
        return "searchByTitle";
    }

}


