package com.easylife.vo.SecondHandCommunityVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdleUserBean {
    //简化传送到前台的用户信息，在CommunityServiceImpl使用
    private Integer id;
    private String photo;
    private String username;
    private String phone;
    private Integer yidou;
}
