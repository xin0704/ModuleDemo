package com.demo.module_girls.Util;

import com.demo.library.Base.adapter.IBaseCell;
import com.demo.module_girls.Cell.GirlsCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/8.
 */

public class LoadGirlsData {

    public static List<IBaseCell> getData() {

        List<IBaseCell> cells = new ArrayList<>();

        cells.add(new GirlsCell("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=862591842,2864954084&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2021991128,2296584601&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2996081471,759856654&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3906161185,333176228&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=765875353,3793971150&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1995050523,4191824477&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3369215836,774974048&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3102711909,683345632&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=865490461,298614916&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=937840224,4190645943&fm=27&gp=0.jpg"));
        cells.add(new GirlsCell("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=861121265,391138898&fm=27&gp=0.jpg"));

        return cells;
    }

}
