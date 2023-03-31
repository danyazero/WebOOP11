package com.danyazero.weboop11.controllers;

import com.danyazero.weboop11.BLL.IStep;
import com.danyazero.weboop11.BLL.StepFunctions;
import com.danyazero.weboop11.models.Point;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/steps")
    public String steps(@RequestParam double start, @RequestParam double finish, @RequestParam double step, Model model){

        IStep bll = new StepFunctions();
        List<Point> points = bll.getPointList(start, finish, step);
        model.addAttribute("list", points);
        model.addAttribute("average", bll.average(points));
        model.addAttribute("max", bll.getMaxPoint(points).getY());
        model.addAttribute("min", bll.getMinPoint(points).getY());

        return "steps";
    }
}
