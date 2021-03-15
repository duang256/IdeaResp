package com.easylife.vo.SecondHandCommunityVo;

import com.easylife.pojo.CommunityIdle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdleAndUserVo {
//    关于二手社区的详细信息和用户的详细信息，用于显示到activity_idle_detail
    private CommunityIdle communityIdle;
    private IdleUserBean idleUserBean;
}
