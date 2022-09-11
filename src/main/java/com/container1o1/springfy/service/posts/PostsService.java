package com.container1o1.springfy.service.posts;

import com.container1o1.springfy.domain.posts.Posts;
import com.container1o1.springfy.domain.posts.PostsRepository;
import com.container1o1.springfy.web.modules.posts.dto.PostsResponseDto;
import com.container1o1.springfy.web.modules.posts.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    public List<PostsResponseDto> findAll() {
        List<Posts> posts = postsRepository.findAll();

        return posts.stream().map(PostsResponseDto::new).collect(Collectors.toList());
    }
}
