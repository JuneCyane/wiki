package com.cyane.wiki.service;

import com.cyane.wiki.domain.Ebook;
import com.cyane.wiki.domain.EbookExample;
import com.cyane.wiki.mapper.EbookMapper;
import com.cyane.wiki.req.EbookReq;
import com.cyane.wiki.resp.EbookResp;
import com.cyane.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        //写法固定
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        //动态sql
        if (!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        List<Ebook> ebooklist = ebookMapper.selectByExample(ebookExample);
        //从List<Ebook>变为List<EbookResp>
/*        List<EbookResp> respList=new ArrayList<>();
        for (Ebook ebook : ebooklist) {
            //实现实体类的复制
*/
        /*  EbookResp ebookResp = new EbookResp();
            //BeanUtils.copyProperties(source,target);
            BeanUtils.copyProperties(ebook,ebookResp);
        */
        /*

            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            respList.add(ebookResp);
        }*/
        List<EbookResp> respList = CopyUtil.copyList(ebooklist, EbookResp.class);
        return respList;
    }
}