package org.example.controller;

import lombok.extern.log4j.Log4j;
import org.example.vo.SampleDTOList;
import org.example.vo.SampleVo;
import org.example.vo.TodoDTO;
import org.example.vo.TodoVo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/sample/*")
@Log4j
public class SampleController {
    @RequestMapping("")
    public String SampleController() {

        log.info("basic,,,,,,,,,,,,,");

        return "index";
    }

    @RequestMapping(value = "/ex01")
    public String ex01(SampleVo vo , @ModelAttribute("page") int page) {
        log.info("page"+ page);
        log.info("vo" + vo);
        return "index";
    }

    @RequestMapping(value = "/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("old") int old) {


        log.info("" + name);
        log.info("" + old);

        return "index";
    }

    @RequestMapping(value = "/ex03")
    public String ex03(@RequestParam("ids") ArrayList<String> ids) {


        log.info("" + ids);

        return "index";
    }

    @RequestMapping(value = "/ex04")
    public String ex03(@RequestParam("ids") String[] ids) {


        log.info("array ids: " + Arrays.toString(ids));

        return "index";
    }

    @GetMapping("/ex05")
    public String ex05(SampleDTOList list) {


        log.info("array ids: " + list);

        return "index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dataFormat,false));
    }

    @GetMapping("/ex06")
    public String ex06(TodoDTO vo){

        log.info("todo:"+ vo);
        return "indesx";
    }

    @GetMapping("/ex07")
    public @ResponseBody SampleVo ex07(){

        log.info("/ex07............");

        SampleVo vo = new SampleVo();
        vo.setName("이원태");
        vo.setOld("123");

        return vo;
    }

    @GetMapping("/ex08")
    public ResponseEntity<String> ex08(){

        log.info("/ex08............");

        String msg = "{\"name\" : \"홍길동\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json;charset=UTF-8");


        return new ResponseEntity<>(msg,headers, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public String exUpload(){
        log.info("/exUpload....");
        return "exUpload";
    }
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files){

        files.forEach(file -> {

            log.info("--------------------");
            log.info("name: " + file.getOriginalFilename());
            log.info("size" + file.getSize());

        });

    }
}
