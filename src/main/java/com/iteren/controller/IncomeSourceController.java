package com.iteren.controller;

import com.iteren.model.plan.IncomeSource;
import com.iteren.service.IncomeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/income")
public class IncomeSourceController {
    @Autowired
    private IncomeSourceService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public @ResponseBody List<IncomeSource> getAll() {
        return service.getAll();
    }
}
