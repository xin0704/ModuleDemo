package com.demo.module_news.Util;

import com.demo.library.Base.adapter.IBaseCell;
import com.demo.module_news.Cell.NewsCell;
import com.demo.module_news.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/8.
 */

public class LoadNewsData {

    public static List<IBaseCell> getData() {

        List<News> list = new ArrayList<>();

        List<IBaseCell> cells = new ArrayList<>();

        list.add(new News(
                "驻朝鲜大使李进军会见中国人民志愿军烈士后代扫墓团",
                "2018-04-08 15:40",
                "驻朝鲜使馆",
                "http://06.imgmini.eastday.com/mobile/20180408/20180408154039_d0041f8863c05259aa04073259a8af09_4_mwpm_03200403.jpg"));

        list.add(new News(
                "2018大学英语四级考试时间安排表_英语四级作文万能模板",
                "2018-04-08 15:29",
                "齐鲁晚报",
                "http://04.imgmini.eastday.com/mobile/20180408/20180408152935_d7b0daae18503514d2e35c92a6296818_1_mwpm_03200403.jpg"));

        list.add(new News(
                "卢旺达驻华大使：“一带一路”为非洲大陆互联互通协同发展注入勃勃生机",
                "2018-04-08 15:23",
                "国际在线",
                "http://00.imgmini.eastday.com/mobile/20180408/20180408152320_bb24d5b727baf17ae3418f5da6e2340d_1_mwpm_03200403.jpg"));


        list.add(new News(
                "印度国防部网站疑遭入侵 黑客留下中文“禅”字意欲何为",
                "2018-04-08 15:09",
                "东方头条",
                "http://09.imgmini.eastday.com/mobile/20180408/20180408_f85ce07facdc51fc7418123ab870e8b6_mwpm_03200403.jpg"));


        list.add(new News(
                "九三学社先贤肖像画展走进湖北",
                "2018-04-08 15:05",
                "九三学社中央网站",
                "http://01.imgmini.eastday.com/mobile/20180408/20180408150557_faf96eae9be1939da925f15c6915fbf2_2_mwpm_03200403.jpg"));


        list.add(new News(
                "充分发挥社会组织作用　助力国际经贸活动高水平发展",
                "2018-04-08 15:02",
                "天津商务网",
                "http://02.imgmini.eastday.com/mobile/20180408/20180408150217_d6185d3a96af828198157ed048edf922_1_mwpm_03200403.jpg"));


        list.add(new News(
                "间谍中毒案内幕捂不住了？美英要给间谍中毒案主角签“蒸发密令”",
                "2018-04-08 14:57",
                "高峰军事观察",
                "http://02.imgmini.eastday.com/mobile/20180408/20180408_963903fc3e88bf5c32d0b0a3a62a710e_cover_mwpm_03200403.jpg"));


        for (int i = 0; i < list.size(); i++) {

            NewsCell newsCell = new NewsCell(list.get(i));
            cells.add(newsCell);

        }


        return cells;
    }

}
