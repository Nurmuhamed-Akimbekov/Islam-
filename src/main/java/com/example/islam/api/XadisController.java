package com.example.islam.api;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Xadis;
import com.example.islam.service.XadisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/xadist")
@RequiredArgsConstructor

public class XadisController {
    private final XadisService xadisService;

    @GetMapping("/new")
    public String createXadis(Model model){
        model.addAttribute("newXadis", new Xadis());
        return "/xadis/newXadis";
    }

    @PostMapping("/newXadis")
    public String saveXadis(@ModelAttribute Xadis xadis){
        xadisService.saveXadis(xadis);
        return "redirect:/xadist/xadis";
    }

    @GetMapping
    public String getAllXadis(Model model){
        model.addAttribute("xadis", xadisService.findAllXadis());
        return "/home-pagh";
    }

    @GetMapping("/xadis")
    public String getXadis(Model model){
        model.addAttribute("xadis", xadisService.findAllXadis());
        return "/xadis/xadis-main";
    }

    @GetMapping("/update/{xadisId}")
    public String fetById(@PathVariable Long xadisId, Model model) throws MyException {
        model.addAttribute("xadis", xadisService.findById(xadisId));
        return "/xadis/update-xadis";
    }

    @PostMapping("update/{xadisId}")
    public String update(@PathVariable Long xadisId,@ModelAttribute Xadis xadis) {
        xadisService.updateXadis(xadisId,xadis);
        return "redirect:/xadist/xadis";
    }

    @PostMapping("/{xadisId}/delete")
    public String delete(@PathVariable Long xadisId){
        xadisService.deleteXadisById(xadisId);
        return "redirect:/xadist/xadis";
    }

    @GetMapping("/search")
    public String searchXadis(@RequestParam String word, Model model){
        List<Xadis> xadis = xadisService.XadisSearch(word);
        model.addAttribute("xadist", xadis);
        return "/xadis/xadis-search";
    }
}
