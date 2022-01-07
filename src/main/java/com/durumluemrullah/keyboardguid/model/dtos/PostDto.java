package com.durumluemrullah.keyboardguid.model.dtos;

import java.math.BigInteger;
import java.util.*;

public class PostDto {

    private BigInteger postId;
    private String userName;
    private String companyName;
    private String departmentName;
    private String context;
    private String comment;
    private List<PostCommentDto> postCommentDtoList;
    private List<UserPostDto> userLikes;
    private List<UserPostDto> userDisLikes;



}
