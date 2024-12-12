package com.rps.projetodois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    public ScoreRepository scoreRepo;

    @ResponseBody
    @GetMapping("/score")
    public Score getScore(){
        Score score;
        try {            
            score = scoreRepo.findById(Integer.valueOf(1)).get();            
        } catch (Exception e) {
            score = new Score();
            scoreRepo.save(score);
        }
        return score;
    }

    @GetMapping("/teste")
    public String teste(@RequestParam(name="escolha", required=false, defaultValue="World") String aEscolha, Model model) {
        
        String saida = "empate";
        if(aEscolha.equalsIgnoreCase("papel")){
            saida = "ganhou";
        } else if(aEscolha.equalsIgnoreCase("tesoura")){
            saida = "perdeu";
        }

        model.addAttribute("saida", saida);
        model.addAttribute("aEscolha", aEscolha);
        return "resultado";
    }
}
