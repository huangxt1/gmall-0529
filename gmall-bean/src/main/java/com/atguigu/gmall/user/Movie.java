package com.atguigu.gmall.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
/*有参构造器*/
@AllArgsConstructor
/*无参构造器*/
@NoArgsConstructor
public class Movie implements Serializable{
    private String id;
    private  String name;
}
