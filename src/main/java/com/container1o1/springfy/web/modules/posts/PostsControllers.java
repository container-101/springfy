package com.container1o1.springfy.web.modules.posts;

import com.container1o1.springfy.service.posts.PostsService;
import com.container1o1.springfy.web.modules.posts.dto.PostsListResponseDto;
import com.container1o1.springfy.web.modules.posts.dto.PostsResponseDto;
import com.container1o1.springfy.web.modules.posts.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsControllers {

    private final PostsService postsService;

    @GetMapping("/posts")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }


    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
