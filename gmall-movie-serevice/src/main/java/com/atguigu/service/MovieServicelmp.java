package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.movie.MovieService;
import com.atguigu.gmall.user.Movie;
import com.atguigu.gmall.user.User;
import com.atguigu.gmall.user.UserService;
@Service
public class MovieServicelmp implements MovieService {


    @Override
    public Movie getMovie(String id) {
        return new Movie("1","大海");
    }
}
