package com.xin.view;


import com.xin.model.enums.BusViewEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Author:  zhaohongyu
* @CreateDate:  2021-11-16 15:53
*/
@Controller
@RequestMapping("busForwardController")
public class BusForwardController {

    /**
    * @Author:  zhaohongyu
    * @CreateDate:  2021-11-16 15:53
    */
    @RequestMapping(value="/{systemcode}")
    public String fundNetWorthReport(@PathVariable("systemcode")String systemcode) {
        BusViewEnum viewEnum = BusViewEnum.getEnumBySystemcode(systemcode);
        return viewEnum.systempath;
    }



}
