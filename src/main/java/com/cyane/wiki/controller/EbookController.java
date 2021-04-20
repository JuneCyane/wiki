package com.cyane.wiki.controller;

import com.cyane.wiki.domain.Ebook;
import com.cyane.wiki.resp.CommonResp;
import com.cyane.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list() {
        CommonResp<List<Ebook>> resp= new CommonResp<>();
        List<Ebook> list= ebookService.list();
        resp.setContent(list);
        return resp;
    }
}