package com.rps.projetodois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
            int id = scoreRepo.findTopByOrderByIdAsc().getId();
            score = scoreRepo.findById(id).get();
            scoreRepo.save(score);
        } catch (Exception e) {
            score = new Score();
            scoreRepo.save(score);
        }
        
        return score;
    }

    @GetMapping("/teste")
    public String teste(@RequestParam(name="escolha", required=false, defaultValue="World") String aEscolha, Model model) {
        Score score = getScore();
        String saida = "empate";
        if(aEscolha.equalsIgnoreCase("papel")){
            saida = "ganhou";
            score.incrementaVitorias();
        } else if(aEscolha.equalsIgnoreCase("tesoura")){
            saida = "perdeu";
            score.incrementaDerrotas();
        } else{
            score.incrementaEmpates();
        }

        scoreRepo.save(score);

        model.addAttribute("saida", saida);
        model.addAttribute("aEscolha", aEscolha);
        model.addAttribute("score", score);
        return "resultado";
    }

    @PostMapping("/reiniciar")
    public String reiniciarPlacar(Model model) {
        Score score = new Score();
        score.reset();
        scoreRepo.save(score);

        model.addAttribute("score", score);
        return "novo_jogo";
    }
}
